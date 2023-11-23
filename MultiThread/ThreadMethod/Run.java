public class Run extends Thread {
    // Calling using run itself and can use run methods multiple times
    String message;

    public Run(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(message + " is starting");
    }

    public static void main(String[] args) {
        Run thread1 = new Run("thread1");
        Run thread2 = new Run("Thread2");
        thread1.run();
        thread2.run();

    }

}