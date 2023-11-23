public class Join extends Thread {
    public void run() {
        for (int i = 0; i <= 2; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Join thread1 = new Join();
        Join thread2 = new Join();
        Join thread3 = new Join();

        thread1.start();

        try {
            thread1.join(10);
            thread2.start();
            thread3.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}