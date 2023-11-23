public class Stop extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Hai");
    }

    public static void main(String[] args) {
        Stop t1 = new Stop();
        Stop t2 = new Stop();
        Stop t3 = new Stop();

        t1.start();
        t2.start();
        t3.start();

        t3.stop();

    }
}