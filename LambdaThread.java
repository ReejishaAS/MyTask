public class LambdaThread {
    public static void main(String[] args)
    {
        
        Runnable r1 =()->{
            System.out.println("I am working");
        };
        Thread t1 = new Thread(r1);
        t1.start();

    }
}