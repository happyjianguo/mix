package test.okhttp;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * okhttp get
 */
public class testGet {
    public static final OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
        try {
            Response response = client.newCall(request).execute();

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
