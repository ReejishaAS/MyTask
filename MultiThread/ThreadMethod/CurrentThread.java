public class CurrentThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CurrentThread thread1 = new CurrentThread();
        CurrentThread thread2 = new CurrentThread();
        thread1.start();
        thread2.start();

    }

}