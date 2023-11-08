class MyThread extends Thread {
    String message;

    public MyThread(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(message);
    }
}

public class Multithreading {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Java is object-oriented, open source");
        MyThread thread2 = new MyThread("easy to learn, high performance, and fast.");

        thread1.start();
        thread2.start();
    }
}