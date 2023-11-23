public class Start extends Thread {
    // start method using Thread extends
    String name;

    public Start(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " is Running...");
    }

    public static void main(String[] args) {
        Start thread1 = new Start("Thread1");
        Start thread2 = new Start("Thread2");
        thread1.start();
        thread2.start();
    }

}

/*
 * public class Start implements Runnable {
 * 
 * public void run() {
 * System.out.println("Thread is running");
 * }
 * 
 * public static void main(String[] args) {
 * Start thread = new Start();
 * Thread t1 = new Thread(thread);
 * Thread t2 = new Thread(thread);
 * t1.start();
 * t2.start();
 * }
 * }
 */
