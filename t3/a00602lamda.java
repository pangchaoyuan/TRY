import java.util.ArrayList;
import java.util.List;

@FunctionalInterface//无返回值
interface A{
    void fun1();
}

@FunctionalInterface//只有一个抽象方法
interface B{
    void fun1(int a);
}
@FunctionalInterface//
interface C{
    void fun1(int a,int b);
}
@FunctionalInterface//有返回值
interface D{
    int fun1();
}

@FunctionalInterface//只有一个抽象方法
interface E{
    int fun1(int a);
}

@FunctionalInterface//只有一个抽象方法
interface F{
    int fun1(int a,int b);
}
public class a00602lamda {
    public static void main(String[] args) {
        A a = ()->{
            System.out.println("无参数无返回值a");
        };
        a.fun1();
        B b = (int num1)->{
            System.out.println("一个参数无返回值b"+num1*2);
        };
        b.fun1(12);
        C c = (int num1,int num2)->{
            System.out.println(num1+num2+"多个参数无返回值c");
        };
        c.fun1(2,3);
        D d =()->{
            return 122;
        };
        System.out.println(d.fun1()+"d有返回值无参数");
        E e = num1->{
            int s = num1 +22;
            return s-21;
        };
        System.out.println(e.fun1(12)+"e有返回值有一参数");

        F f = (int num1,int num2)->{
            System.out.print("f有返回值有多个参数");
            return num1+num2;
        };
        System.out.println(f.fun1(12,312));
         for(int i1 = 0 ;i1<1;i1++){
     Thread t1 = new Thread(()->{
        for(int i = 0 ;i<3;i++){
            System.out.println(i);
        }
      });
    t1.start();
        }

        List<String> list = new ArrayList<>();
         list.add("3412");
         list.add("dswaq");
         list.add("ewdhg");
         list.add("00465df65");
         list.sort((o1,o2)->{
             return o2.length()-o1.length();
    }
         );//排序
        list.forEach(s -> System.out.print(s+" "));
               //打印
    }
}


