class MyThread extends Thread {
    public void run() {
        System.out.println("Java is object-oriented, open source, easy to learn, high performance, and fast.");
    }
}

public class Multithreading {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();
    }
}