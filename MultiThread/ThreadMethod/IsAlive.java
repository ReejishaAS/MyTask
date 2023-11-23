public class IsAlive extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isAlive());
    }

    public static void main(String[] args) {
        IsAlive t1 = new IsAlive();
        IsAlive t2 = new IsAlive();

        t1.start();
        t2.start();
    }
}