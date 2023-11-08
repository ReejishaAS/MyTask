public class CurrentThreadRef extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        CurrentThreadRef firstThreadRef = new CurrentThreadRef();
        CurrentThreadRef secondThreadRef = new CurrentThreadRef();

        firstThreadRef.start();
        secondThreadRef.start();
    }

}
