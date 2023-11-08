class Thread1 extends Thread {
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("My First program is starting..");
        } catch (InterruptedException e) {
            System.out.println("First Thread interrupted.");
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("My Second program is starting..");
        } catch (InterruptedException e) {
            System.out.println(" Second Thread interrupted.");
        }
    }
}

public class MyThread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
        System.out.println("My program starting...");
    }
}
