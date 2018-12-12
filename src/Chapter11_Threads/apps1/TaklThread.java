package Chapter11_Threads.apps1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class TaklThread extends Thread {
    public void run() {
        try {
            sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        try {
        for (int i=0; i<5; i++) {
            InputStream in = new FileInputStream("D://exception");

        }

            Thread.sleep(7);
        } catch (InterruptedException e){
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
