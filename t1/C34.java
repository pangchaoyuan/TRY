public class C34 {
   private static class a extends Thread{
       @Override
       public void run() {
           System.out.println("哈哈哈");
       }
   }


    private static class b implements Runnable{
        @Override
        public void run() {
            System.out.println("嘿嘿嘿");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread a = new a();
        a.start();
        a.join();
        System.out.println("a");
        Thread b = new Thread(new a());
        b.start();
        b.join();
        System.out.println("b");
        Thread c = new Thread(new b());
        c.start();
        c.join();
        System.out.println("c");
    }
}
