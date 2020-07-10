import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

public enum a200529枚举 {
    RED("RED","REDN",1),GREEN("GREEN","GREEN",2),YELLO("ELLO","ELLO",3);

   public String str1;
   private String  str2;
   public int num;


    a200529枚举(String str1, String str2, int num) {
        this.str1 = str1;
        this.str2 = str2;
        this.num = num;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //System.out.println(getEnum(2).str2);

        Class<?> c1 = a200529枚举.class;

        Field[] fields =c1.getDeclaredFields();

       // Constructor constructor = c1.getDeclaredConstructor(String.class,String.class,int.class);

       // constructor.setAccessible(true);

      //  a200529枚举 PURPLE = (a200529枚举) constructor.newInstance("哈哈哈","PURPLE",888);

        for(Field f : fields){
            System.out.println(f);
        }

    }

    public static a200529枚举 getEnum(int val){
        for(a200529枚举 a : a200529枚举.values()){
           if(a.num==val){
               return a;
           }
       }
       return null;
    }
}
