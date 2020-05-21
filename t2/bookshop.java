import java.io.*;
import java.util.*;

public class bookshop {
    private static Map<String,book> namelist = new HashMap<>();
    private static Map<String,book> authorlist = new HashMap<>();
    private static List<book> list = new ArrayList<>();

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        while(true) {
            File file = new File("I:\\IDEA\\hahaha.txt");
            file.createNewFile();
            Scanner scan = new Scanner(System.in);
            System.out.println("请选择您想干啥");
            System.out.println("1.d=搜索作者");
            System.out.println("2.搜索书名");
            System.out.println("3.添加书籍");
            System.out.println("4.打印书籍名单");
            int n = scan.nextInt();
            if (n == 1) {

            }
            if (n == 2) {

            }
            if (n == 3) {
                add();
            }
            if(n==4){
                deplay();
            }
        }
    }



    public static void add() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("书名");
        String name = scanner.nextLine();
        System.out.println("作者");
        String author = scanner.nextLine();
        System.out.println("价格");
        Double pay = scanner.nextDouble();
        book a = new book(name,author,pay);
        namelist.put(name,a);
        authorlist.put(author,a);
        list.add(a);

        try(OutputStream is = new FileOutputStream("I:\\IDEA\\hahaha.txt")){
            try(ObjectOutputStream oos = new ObjectOutputStream(is)){
                oos.writeObject(namelist);
                oos.writeObject(authorlist);
                oos.writeObject(list);
            }
        }
        System.out.println("添加成功");
        System.out.println("任意键返回主菜单");
        scanner.next();

    }


    public static void deplay() throws IOException,ClassNotFoundException{
            Scanner scanner = new Scanner(System.in);
            File file = new File("I:\\IDEA\\hahaha.txt");
            if(file.exists()) {
                try (InputStream is = new FileInputStream(file)) {
                    try (ObjectInputStream ois = new ObjectInputStream(is)) {
                        namelist = (Map<String, book>) ois.readObject();
                        authorlist = (Map<String, book>)ois.readObject();
                        list = (List<book>)ois.readObject();
                        System.out.println(list);
                    }
                }
            }
        scanner.next();

    }




}

 class book implements Serializable {
     private static final long serialVersionUID = 6066061351242377837L;
     String name;
    String author;
    double pay;

    public book(String name, String author, double pay) {
        this.name = name;
        this.author = author;
        this.pay = pay;
    }

     public book() {
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
         return "book{" +
                 "name='" + name + '\'' +
                 ", author='" + author + '\'' +
                 ", pay=" + pay +
                 '}'+'\n';
     }
 }
