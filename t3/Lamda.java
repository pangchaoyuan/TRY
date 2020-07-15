import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface MyThread {
    void start(String str1,String str2,int num3);
}

@FunctionalInterface
interface A{
    int Fun(String a,int b );
}



public class Lamda {
    private static String str;
    static int num = 0;
    static int num1 = 0;

    public static void main(String[] args){
     //threadTest();
        //interfaceTest();
        Test();
    }

    //==============================================
    public static void Test(){
        A a = (String a2,int b)->{
            System.out.println(a2);
            return b;
        };
        System.out.println(a.Fun("dqwd",100));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.sort((o1,o2)->{
            return o2-o1;
        });
        //当只有一个参数，只有一句，(){}可省略
        list.forEach(s-> System.out.println(s));
        list.forEach((s)->{
            System.out.println(s);
        });

    }
    //==============================================




//===========FAILED======接口交替打印8行===============
    public static void interfaceTest(){
        MyThread mr =(String str1,String str2,int num3)->{
            synchronized (Lamda.class){
                for(;num3<str1.length();){
                    num3 = num1;
                    System.out.println(str1.charAt(num3)+" "+str2);
                    num1++;
                    Lamda.class.notifyAll();
                    try{
                        Thread.sleep(100);
                        Lamda.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

          mr.start("eqw","ewqe",2);
    }
//======================FAILED================================


//==================Lamda与多线程打印==========================
    public static void threadTest(){
        System.out.println("请输入:");
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        Thread t1 = new Thread(()->{
            synchronized (Lamda.class){
                System.out.println("线程启动");
                for(;num<str.length();){
                    System.out.println(str.charAt(num));
                    num++;
                    Lamda.class.notifyAll();
                    try{
                        Thread.sleep(100);
                        Lamda.class.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }
}
