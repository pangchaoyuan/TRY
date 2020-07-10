import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import javax.swing.tree.TreeNode;
import java.sql.PreparedStatement;

public class a200602经典多线程 {
    static int num = 0;
    //给定一个字符串多线程交替打印
    static class MyThread extends Thread{
        private  String str;
        private  String str2;
        public MyThread(String str,String str2) {
            this.str = str;
            this.str2 = str2;
        }
        @Override
        public void  run() {
            synchronized (MyThread.class){
              for(;num<str.length();){
                  System.out.println(str.charAt(num)+str2);
                  num++;
                  MyThread.class.notifyAll();
                  try{
                      MyThread.sleep(100);
                      MyThread.class.wait();
                  }catch (Exception E){
                      E.printStackTrace();
                  }
              }
            }
        }
    }


    public static void main(String[] args) {
        String str = "213456789";
        MyThread t1 = new MyThread(str,"第一个线程");
        MyThread t2 = new MyThread(str,"第二个线程");
        MyThread t3 = new MyThread(str,"第三个线程");
        t1.start();
        t2.start();
        t3.start();
    }
}


//=================阻塞队列=================================
class BlockingArrayQueue{
    int[] array = new int[10];
    int front = 0; //队尾
    int rear = 0; //队头
    int size = 0;

    //加 仅有生产者调用
   synchronized void put(int val) throws InterruptedException {
        while(size==array.length){
            this.wait();
        }

        array[rear] = val;
        rear = (rear+1)%array.length;
        size++;
        this.notifyAll();
    }
//取出仅有消费者调用
   synchronized int pop() throws InterruptedException {
       int v =0;
       while(size==0){
           this.wait();
        }
        {
            v = array[front];
            front = (front+1)%array.length;
            size--;
            this.notifyAll();
        }
       return v;
    }

   static BlockingArrayQueue blockingArrayQueue = new BlockingArrayQueue();


    static class Producer extends Thread{

        @Override
        public void run() {
            try{
                for(int i = 0 ;i<100;i++){
                    blockingArrayQueue.put(i);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //=================================================

    static class Thread3 implements Runnable{
       private   String str;

        public Thread3(String str) {
            this.str = str;
        }



       synchronized   public void run() {
           for(char a : str.toCharArray()){
               System.out.print(a);
           }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer1 = new Producer();
        producer1.start();

        Thread.sleep(1000);

        while(true){
            System.out.println(blockingArrayQueue.pop());
            if(blockingArrayQueue.size==0) break;
       }

        //=================================
        Thread3 ts =  new Thread3("afr324rfa");
         new Thread(ts).start();
        new Thread(ts).start();



    }

}


