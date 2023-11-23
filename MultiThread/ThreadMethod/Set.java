public class Set extends Thread {
    String name;

    public Set(String name) {
        this.name = name;
    }

    public void run() {
        Thread.currentThread().setName("Reejisha");
        // Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        // Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        // Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        // Thread.currentThread().setPriority(12);

        System.out.println(Thread.currentThread().getName() + name);
        System.out.println(Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        Set t1 = new Set("John");
        Set t2 = new Set("Rakesh");

        t1.start();
        t1.setName("Revathi");
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread 1 " + t1.getName());
        try {
            t1.join();

            t2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}