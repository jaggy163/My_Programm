package Chapter11_Threads.apps1;

public class WalkTalk {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TaklThread talk = new TaklThread();
        Thread walk = new Thread(new WalkRunnable());
        talk.start();
        walk.start();
        long end1 = System.currentTimeMillis();
        System.out.println("main: " + (end1-start));
    }
}
