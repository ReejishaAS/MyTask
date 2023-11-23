public class Suspend extends Thread {
    public void run() {
        for (int i = 0; i <= 2; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        Suspend t1 = new Suspend();
        Suspend t2 = new Suspend();
        Suspend t3 = new Suspend();

        t1.start();
        t2.start();
        t2.suspend();
        t3.start();
    }
}