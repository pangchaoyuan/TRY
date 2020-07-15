import java.io.*;
import java.util.Scanner;

public class IO流 {
    public static void main(String[] args) {
        写入文本();
        读取文本();
        写入二进制(读取二进制());
    }


    public static void 写入文本(){
        try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("输出.txt"),"utf-8")){
            try(PrintWriter writer = new PrintWriter(osw)){
                osw.write("你好");
                osw.write("很高兴");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void 读取文本(){
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("输出.txt"),"utf-8")){
            try(Scanner scanner = new Scanner(isr)){
                System.out.println(scanner.next());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//字节流
    public static byte[] 读取二进制(){
        byte[] buffer = new byte[3810220];
        try (InputStream is = new FileInputStream("图片.png")){

            is.read(buffer);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return buffer;
        }
    }
//字节流
    public static void 写入二进制(byte[] bytes){
        try(OutputStream os = new FileOutputStream("新的图片.png");
            OutputStream os2 = new FileOutputStream("图片.txt")){
            os.write(bytes);
            os2.write(bytes);
        }catch (Exception e){}
    }
}
