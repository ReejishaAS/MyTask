public class Sleep extends Thread {
    public void run() {
        for (int i = 0; i <= 2; i++) {
            /*
             * try {
             * Thread.sleep(500);
             * } catch (InterruptedException e) {
             * System.out.println(e);
             * }
             */
            try {
                Thread.sleep(-500);
            } catch (InterruptedException e) {// for IllegalArgumentException
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Sleep thread1 = new Sleep();
        Sleep thread2 = new Sleep();
        thread1.start();
        thread2.start();

    }
}