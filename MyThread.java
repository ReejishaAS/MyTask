public class MyThread implements Runnable {

    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("My Second program is starting..");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        System.out.println("My first program starting...");
    }
}
