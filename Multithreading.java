class MultiThread extends Thread {
    String[] message = { "Java is object-oriented, open source, easy to learn, high performance, and fast" };;

    public void run() {
        System.out.println(Thread.currentThread().isAlive() ? Thread.currentThread().getName() + " is lives" : "");

        String[] words = message[0].split("\\s+");

        for (String word : words) {
            System.out.println(Thread.currentThread().getName() + " " + word);
        }
        System.out.println(Thread.currentThread().getName() + " is dead.");

    }

}

public class Multithreading {
    public static void main(String[] args) {

        MultiThread thread0 = new MultiThread();
        MultiThread thread1 = new MultiThread();

        thread0.start();
        thread1.start();
    }
}
