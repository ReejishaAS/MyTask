class ShareResource {

    synchronized void printTable(int n) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 1; i < n; i++) {
            try {

                Thread.sleep(10);
            } catch (

            Exception e) {
                System.out.println(e);
            }
            System.out.println(i * n);
        }
    }

}

class ThreadFirst extends Thread {
    ShareResource resource;

    public ThreadFirst(ShareResource resource) {
        this.resource = resource;
    }

    public void run() {
        resource.printTable(5);

    }
}

class ThreadSecond extends Thread {

    public void run() {
        System.out.println("Name of the Thread 4 is " + Thread.currentThread().getName());
        System.out.println("Id of the Thread 4 is " + Thread.currentThread().getId());
        System.out.println("Priority of the thread 4 is " + Thread.currentThread().getPriority());

    }
}

public class MultiThreadFunctions {
    public static void main(String[] args) {
        ShareResource obj = new ShareResource();
        ThreadFirst t1 = new ThreadFirst(obj);
        ThreadFirst t2 = new ThreadFirst(obj);
        ThreadFirst t3 = new ThreadFirst(obj);
        ThreadSecond t4 = new ThreadSecond();

        t2.start();
        try {
            t2.join();
            t1.start();
            // t2.suspend(); //using suspend method to put thread in running state to
            // waiting
            // t2.yield();
            t3.start();
            t4.start();
            t4.setName("John");
            t4.setPriority(Thread.MAX_PRIORITY);// SetPriority method

        } catch (Exception e) {
            System.out.println(e);
        }
        // t2.resume();// using to resume thread
    }

}
