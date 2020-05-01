import java.util.*;

public class B11 {
    private class Node{

    }
    //加锁的三种方法
    synchronized static void aaa (){  //拿的是B11.class的锁

    }

    void aa(){
        Object a = new Object();//拿的是这个对象a的锁
        synchronized (a){

        }
    }

    synchronized void a(){   //普通方法依赖对象，所以拿的是该对象的锁

    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        System.out.println(B.str);

    }

}

 class daw {
  //匿名内部类的写法
     public static void main(String[] args) {
         Runnable r = new Runnable() {
             @Override
             public void run() {
                 System.out.println("a");
             }
         };
         Thread t = new Thread(){
             @Override
             public void run(){
                 System.out.println("sss");
             }
         };

     }
}

class A{
    public static String str = "asdadas";
    static {
        System.out.println("A");
    }
}
class B extends A{
    public static String str = "1";
    static{
        System.out.println("B");
    }
}
class test{
    public static void main(String[] args) {

    }


}