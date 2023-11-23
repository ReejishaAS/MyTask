public class Yield extends Thread {
    public void run() {
        Thread.yield();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        Yield t1 = new Yield();
        Yield t2 = new Yield();

        t1.start();
        System.out.println(t1.getName());

        try {
            t1.yield();
            t2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}