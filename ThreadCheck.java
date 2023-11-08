class Thread1 extends Thread {
    private String message;

    public Thread1(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println("This is Thread 1: " + message);

    }
}

class Thread2 extends Thread {
    public void run() {
        System.out.println("This is Thread 2");
    }
}

public class ThreadCheck {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1(" hello ");
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
        if (t1.isAlive()) {
            System.out.println("Tread 1 is alive");
        } else {
            System.out.println("Thread 1 is dead");
        }
        if (t2.isAlive()) {
            System.out.println("Tread 2 is alive");
        } else {
            System.out.println("Thread 2 is dead");
        }
    }
}
