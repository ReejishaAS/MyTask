public class Get extends Thread {
    String name;

    public Get(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " name" + Thread.currentThread().getName());
        System.out.println(name + "id " + Thread.currentThread().getId());
        System.out.println(name + "priority " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        Get t1 = new Get("Thread 1");
        Get t2 = new Get("Thread 2");
        t1.start();
        try {
            t1.join();
            t2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}