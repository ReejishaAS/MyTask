class MyRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(500); // Sleep for 500 milliseconds
            System.out.println("My Second program is starting..");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

public class MyThread {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("My first program starting...");
    }
}
