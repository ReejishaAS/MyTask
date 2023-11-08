class FirstThread extends Thread {

    public FirstThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(" is starting...");
    }
}

class SecondThread extends Thread {

    public void run() {
        System.out.println(" is running...");
    }
}

public class ThreadCheck {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread("First");
        SecondThread secondThread = new SecondThread();

        firstThread.start();
        secondThread.start();

        System.out.println("Is first thread working? " + firstThread.isAlive());
        System.out.println("Is second thread working? " + secondThread.isAlive());
    }
}
