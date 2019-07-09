package gg.overwatch.util;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class URLClient {

    public static InputStreamReader getJsonString(String endpoint) throws Exception {
        URL url;
        URLConnection connection;

        url = new URL(endpoint);
        connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();

        return new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
    }
}
