package Chapter13;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UnCheckedHost {
    public static void main(String[] args) {

        for (int i = 0; i<256; i++) {
            byte ip[] = {(byte)217, (byte)21, (byte)42, (byte)i};
            try {
                InetAddress addr = InetAddress.getByAddress("host", ip);
                System.out.println(i + " : " + addr.getHostName() + " -> соединение : " + addr.isReachable(100));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
