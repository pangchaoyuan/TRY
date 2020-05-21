import java.io.*;
import java.util.*;

public class B322通讯录 {
    private static Map<String,people> namemap = new HashMap<>();
    private static Map<String,people> phonemap = new HashMap<>();
    private static List<people> list = new ArrayList<>();



    public static void add() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("输入名字");
        String name = scan.nextLine();
        System.out.println("输入电话");
        String phone = scan.nextLine();
        System.out.println("输入地址");
        String address =scan.nextLine();
        System.out.println("输入备注");
        String mark= scan.nextLine();
        people p =new people(name,phone,address,mark);
        list.add(p);
        namemap.put(name,p);
        phonemap.put(phone,p);


        try(OutputStream os = new FileOutputStream("通讯录.txt")){

           try(ObjectOutputStream ss = new ObjectOutputStream(os)){
               ss.writeObject(list);
               ss.writeObject(namemap);
               ss.writeObject(phonemap);
           }
        }
    }

    public static void findName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名> ");
        String name = scanner.nextLine();

        people p = namemap.get(name);
        if (p == null) {
            System.out.println("查无此人");
        } else {
            System.out.println(p);
        }
    }
    public static void findPhone(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入电话> ");
        String phone = scanner.nextLine();

        people p = phonemap.get(phone);
        if (p == null) {
            System.out.println("查无此人");
        } else {
            System.out.println(p);
        }
    }


    public static void read() throws IOException,ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        File file = new File("通讯录.txt");
        if(file.exists()) {
            try (InputStream is = new FileInputStream(file)) {
                try (ObjectInputStream ois = new ObjectInputStream(is)) {
                    list = (List<people>) ois.readObject();
                    namemap = (Map<String, people>) ois.readObject();
                    phonemap = (Map<String, people>) ois.readObject();
                    System.out.println(list);

                }
            }
        }
        scan.nextLine();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        File file = new File("通讯录.txt");
        if(!file.exists()){
            file.createNewFile();
        }

       /* if(file.exists()){
            try(InputStream is = new FileInputStream(file)){
                try(ObjectInputStream ois = new ObjectInputStream(is)){
                    list = (List<people>) ois.readObject();
                    namemap = (Map<String, people>) ois.readObject();
                    phonemap = (Map<String, people>) ois.readObject();
                }
            }
        }*/

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("选择你想要的功能");
            System.out.println("1.添加");
            System.out.println("2.名字找人");
            System.out.println("3.电话找人");
            System.out.println("4.显示当前所有人的名单");
            System.out.println("5.清空通讯录");
            int n = scan.nextInt();
            if(n==1){
                add();
            }
            if(n==2){
                findName();
            }if(n==3){
                findPhone();
            }if(n==4){
                read();
            }if(n==5){
                list.clear();//当顺序表清除后。如果要继续调用4方法，仍然会打印，这表示数据被记录在了文件中。
            }
            scan.nextLine();
        }
    }


}


//=============================================================
 class people implements Serializable {

    String name;

    String number;

    String address;

    String mark;

     public people(String name, String number, String address, String mark) {
         this.name = name;
         this.number = number;
         this.address = address;
         this.mark = mark;
     }

     public people() {
         super();
     }

     @Override
     public int hashCode() {
         return super.hashCode();
     }

     @Override
     public boolean equals(Object obj) {
         return super.equals(obj);
     }

     @Override
     protected Object clone() throws CloneNotSupportedException {
         return super.clone();
     }

     @Override
     protected void finalize() throws Throwable {
         super.finalize();
     }

     @Override
     public String toString() {
         return "people{" +
                 "name='" + name + '\'' +
                 ", number='" + number + '\'' +
                 ", address='" + address + '\'' +
                 ", mark='" + mark + '\'' +
                 '}'+'\n';
     }
  }

