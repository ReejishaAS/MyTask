class FirstThread extends Thread {
    String name;

    public FirstThread(String name) {
        this.name = name;
        start();
    }

    public void run() {
        System.out.println(name);
    }
}

class SecondThread extends Thread {
    String name;

    public SecondThread(String name) {
        this.name = name;
        start();
    }

    public void run() {
        System.out.println(name);
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
