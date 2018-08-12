package test.okhttp;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * okhttp post
 */
public class TestPost {

    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    public final static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        System.out.println(new TestPost().getChronos());

    }

    public void testPost() {
        String postBody = ""
                + "Releases\n"
                + "--------\n"
                + "\n"
                + " * _1.0_ May 6, 2013\n"
                + " * _1.1_ June 15, 2013\n"
                + " * _1.2_ August 11, 2013\n";
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getChronos() {

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"biz_prefix\":\"cl\",\"db_table_index\":\"xxxxxx\"}");
        Request request = new Request.Builder()
                .url("http://172.22.252.8:21012/getId")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("App-Key", "test")
                .addHeader("sign", "f9c0aef5151a4c7e9f7566de0319476ff5e1577a")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "a34ea726-4201-43a4-83e6-6c58ce8bef5f")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
