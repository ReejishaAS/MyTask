class MultiThread extends Thread {
    private String[] message;

    public MultiThread(String[] message) {
        this.message = message;
    }

    public void run() {

        String[] words = message[0].split("\\s+");

        for (String word : words) {
            System.out.println(Thread.currentThread().getName() + " " + word);
        }

    }
}

public class Multithreading {
    public static void main(String[] args) {
        String[] message = { "Java is object-oriented, open source, easy to learn, high performance, and fast" };

        MultiThread thread0 = new MultiThread(message);
        MultiThread thread1 = new MultiThread(message);

        thread0.start();
        thread1.start();

        System.out.println(thread0.isAlive() ? "Thread-0 is lives." : "");
        System.out.println(thread1.isAlive() ? "Thread-1 is lives." : "");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread-0 is dead.");
        System.out.println("Thread-1 is dead.");
    }
}
