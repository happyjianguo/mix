package test.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TestChronos {

    public static void main(String[] args) {

        String result = null;
        try {
            result = new TestChronos().getId("http://172.22.252.8:21012/getId");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public String getId(String url) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("App-Key", "test");
        httpPost.addHeader("sign", "f9c0aef5151a4c7e9f7566de0319476ff5e1577a");

        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("biz_prefix", "cl");
        jsonParam.put("db_table_index", "xxxxxx");

        StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        HttpResponse resp = client.execute(httpPost);
        if (resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he, "UTF-8");
        }
        return respContent;
    }
}
