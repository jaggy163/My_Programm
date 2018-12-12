package Chapter11_Threads.apps1;

public class WalkRunnable implements Runnable {
    public void run() {
        long start = System.currentTimeMillis();
        for (long i=0; i<5000000000l; i++) {
            long k=i>>1;
        }
        try {
            Thread.sleep(7);
        } catch (InterruptedException e){
            System.err.println(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Walk: " + (end-start));
        String[] args = new String[] {};
        WalkTalk.main(args);

    }
}
