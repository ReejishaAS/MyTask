class FirstThread extends Thread {
    public void run() {
        System.out.println("FirstThread is running...");
    }
}

class SecondThread extends Thread {
    public void run() {
        System.out.println("SecondThread is running...");
    }
}

public class ThreadCheck {
    private FirstThread firstThread;
    private SecondThread secondThread;

    public ThreadCheck() {
        firstThread = new FirstThread();
        secondThread = new SecondThread();
        firstThread.start();
        secondThread.start();
    }

    public void checkThreads() {
        System.out.println("Is first thread working? " + firstThread.isAlive());
        System.out.println("Is second thread working? " + secondThread.isAlive());
    }

    public static void main(String[] args) {
        ThreadCheck threadCheck = new ThreadCheck();
        threadCheck.checkThreads();
    }
}
