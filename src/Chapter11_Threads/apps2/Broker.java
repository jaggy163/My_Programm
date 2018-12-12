package Chapter11_Threads.apps2;

import static java.awt.Event.PAUSE;

public class Broker extends Thread {
    private Market market;
    public Broker (Market market) {
        this.market=market;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Current index: " + market.getIndex());
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            System.err.println("Ошибка: " + e);
        }
    }
}
