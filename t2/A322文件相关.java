import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;

public class A322文件相关 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String name =  creatFile();
        String n1 = "";
        System.out.println("请选择编码方式");
        System.out.println("1.UTF-8");
        System.out.println("2.GB18030");
        int n = scan.nextInt();
        if(n==1){
            n1 ="UTF-8";
        }else{
            n1 ="GB18030";
        }
        System.out.println();
        writeFile(name,n1);
        readFile(name,n1);
    }



    public static String creatFile() throws IOException{
        System.out.println("请输入新建文件名");
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine()+".txt";
        File file = new File(a);
        file.createNewFile();
        return a;
    }

    public static void writeFile(String path,String charSet) throws IOException{

        try(OutputStream st = new FileOutputStream(path)) {
            try(OutputStreamWriter aa = new OutputStreamWriter(st,charSet)) {
                System.out.println("请输入文字");
                Scanner scan = new Scanner(System.in);
                    String s = scan.nextLine();
                    aa.write(s, 0, s.length());
                    aa.flush();
                System.out.println("写入成功");
            }

        }
    }



    public static void readFile(String path,String charSet) throws IOException{
        try (InputStream st = new FileInputStream(path)){
           try(InputStreamReader aa = new InputStreamReader(st,charSet)){
               Scanner scanner = new Scanner(aa);
               while(scanner.hasNext()){
                   System.out.println(scanner.nextLine());
               }
           }
            System.out.println("读取成功");
        }
    }


}
