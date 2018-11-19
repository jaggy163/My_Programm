import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Whoscored {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String url = "https://www.whoscored.com/Matches/1293846/Live/Russia-Premier-League-2018-2019-FC-Ufa-Krylya-Sovetov-Samara/";
        String file = "D:\\Football\\UFA-KS.txt";
        int b;
        try (OutputStream outKrasnodarCSKA = new BufferedOutputStream(new FileOutputStream(file))) {
            URLConnection uc;
            System.out.println("Getting content for URL: " + url);
            URL source = new URL(url);
            uc = source.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0");
            uc.connect();
            uc.getInputStream();
            BufferedInputStream inKrasnodarCSKA = new BufferedInputStream(uc.getInputStream());

            while ( (b=inKrasnodarCSKA.read()) != -1) {
                outKrasnodarCSKA.write(b);
            }
        }
        catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + "milliseconds");
    }
}
