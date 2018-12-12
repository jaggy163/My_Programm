package Chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadDocument {
    public static void main(String[] args) {
        URL bsu = null;
        String ulrName = "https://www.bsu.by";
        try {
            bsu = new URL(ulrName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (bsu==null) throw new RuntimeException();
        try (BufferedReader d = new BufferedReader(new InputStreamReader(bsu.openStream()))){
            String line = "";
            while ((line=d.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
