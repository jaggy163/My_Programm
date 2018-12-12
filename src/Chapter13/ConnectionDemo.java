package Chapter13;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionDemo {
    public static void main(String[] args) {
        String urlName = "https://www.oracle.com";
        int timeout = 1_000;
        URL url;
        try {
            url = new URL(urlName);
            final URLConnection connection = url.openConnection();
            connection.setConnectTimeout(timeout);
            System.out.println(urlName + " content type " + connection.getContentType());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
