package Chapter13;

import javax.swing.JApplet;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ShowDocument extends JApplet {
    private URL bsu = null;
    public String getBaseURL() { return "http://bsu.by"; }
    public void paint(Graphics g) {
        int timer = 0;
        g.drawString("Загрузка страницы", 10, 10);
        try {
            for (; timer<30; timer++) {
                g.drawString(".", 10+timer*5, 25);
                Thread.sleep(100);
            }
            bsu = new URL(getBaseURL());
            this.getAppletContext().showDocument(bsu, "blank");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
