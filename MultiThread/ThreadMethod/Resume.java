public class Resume extends Thread {
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        Resume t1 = new Resume();
        Resume t2 = new Resume();
        Resume t3 = new Resume();

        t1.start();
        t2.start();

        t2.suspend();

        t3.start();

        t2.resume();
    }
}