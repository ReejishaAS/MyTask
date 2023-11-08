class FirstThread extends Thread {
    public FirstThread(String name) {
        super(name);
        start();
    }

    public void run() {
        System.out.println("FirstThread is running...");
    }
}

class SecondThread extends Thread {
    public SecondThread(String name) {
        super(name);
        start();
    }

    public void run() {
        System.out.println("SecondThread is running...");
    }
}

public class ThreadCheck {

    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread("First");
        SecondThread secondThread = new SecondThread("Second");

        System.out.println("Is first thread working? " + firstThread.isAlive());
        System.out.println("Is second thread working? " + secondThread.isAlive());
    }
}
