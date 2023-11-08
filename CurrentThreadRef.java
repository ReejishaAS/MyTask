class FirstThreadRef extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
    }

}

class SecondThreadRef extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
    }

}

public class CurrentThreadRef {
    public static void main(String[] args) {
        FirstThreadRef firstThreadRef = new FirstThreadRef();
        SecondThreadRef secondThreadRef = new SecondThreadRef();

        firstThreadRef.start();
        secondThreadRef.start();
    }

}
