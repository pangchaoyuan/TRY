import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//倒计时锁
public class a200604多线程CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(7);

        Customer cs = new Customer("顾客",latch);
        new Thread(new Waitress("服务员",latch)).start();
        for(int i = 0 ; i <3;i++){
            new Thread(cs).start();
        }


        Thread.sleep(6000);

        new Thread(cs).start();

    }
}


//顾客类
class Customer implements Runnable{
    private String name;
    private CountDownLatch latch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM--dd hh:MM:ss:SSS");
        Date date = new Date();
        String str = sp.format(date);
        System.out.println(str+"    "+name+"来到了店里");
    }
}

//服务员类
class Waitress implements Runnable{
    private  String name;
    private CountDownLatch latch;

    public Waitress(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }


    public void run() {
        try{

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM--dd  hh:MM:ss:SSS");
            System.out.println(dateFormat.format(new Date())+"    "+ name+"等候顾客");
            latch.await(5,TimeUnit.SECONDS);//
            System.out.println(dateFormat.format(new Date())+"    " +name+"开始服务");
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
