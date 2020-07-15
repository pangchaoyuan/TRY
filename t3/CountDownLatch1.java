import javax.swing.tree.TreeNode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//客人
class Customer implements Runnable {
   private CountDownLatch latch;
   private String name;

   Customer(CountDownLatch latch,String name){
       this.latch = latch;
       this.name = name;
   }

    @Override
    public void run() {
        latch.countDown();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd+ hh:MM:ss:SSS");
        System.out.println(dateFormat.format(new Date())+"客人 "+name+" 进店");

    }
}
//服务员
class Waitress implements Runnable{
    private CountDownLatch latch;
    private String name;

    Waitress(CountDownLatch latch, String name){
        this.latch = latch;
        this.name = name;
    }


    @Override
    public void run()  {
        try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd+ hh:MM:ss:SSS");
        System.out.println(dateFormat.format(new Date())+" 服务员 "+name+" 等待顾客");

            latch.await(3,TimeUnit.SECONDS);
            System.out.println(dateFormat.format(new Date())+" 服务员 "+name+" 开始上菜");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


public class CountDownLatch1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(8);//计数
        Customer cs = new Customer(latch,"客人");
        new Thread(new Waitress(latch,"老王")).start();
        Thread.sleep(100);


        for(int i = 0 ; i <4;i++){
            new Thread(cs).start();
        }


    }


}
