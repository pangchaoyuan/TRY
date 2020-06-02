import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class a200528反射 {

    public static void main(String[] args) {

        try{
            Class<?> a = 儿子.class;


            Constructor constructor =a.getDeclaredConstructor(String.class,int.class);//单个方法

            constructor.setAccessible(true);

            儿子 s1 = (儿子) constructor.newInstance("张飞",18);

            //System.out.println(s1); //1

            Field file = a.getDeclaredField("age");//单个属性

            file.setAccessible(true);

            file.setInt(s1,90);

            //System.out.println(s1); //2

            //System.out.println(file); //3

            Field[] fields= a.getDeclaredFields();

            for (Field f:
                 fields) {
                System.out.println(f);
            }

            System.out.println("==================================");

            Field[] fields1= a.getFields();

            for (Field f:
                    fields1) {
                System.out.println(f);
            }


            Constructor[] constructors = a.getDeclaredConstructors();
            for(Constructor constructor1 : constructors){
                //System.out.println(constructor1);
            }

            Method[] methods = a.getDeclaredMethods();

            for(Method method : methods){
                //System.out.println(method);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}




class 爸爸{
    public double height = 80.80;
    private String 老婆;

    public void 跑步(){}
    private void 午饭吃的啥(){}
}


class 儿子 extends 爸爸{
   public String name;
   private int age = 18;
   private String 妈妈;


    private 儿子(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void 上课(){}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


