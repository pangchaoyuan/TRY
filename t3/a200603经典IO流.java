import java.io.*;
import java.util.Scanner;

public class a200603经典IO流 {


    //============
    public static void main(String[] args) throws IOException {
        写入文本();
        读取文本();
      byte[] b=  读取二进制(); //此处复制了一张图片
        写入二进制(b);
    }
    //==============================================
//写入字符流
public static void 写入文本() throws IOException {
        try(OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream("输出.txt"),"UTF-8")){
            try(PrintWriter pw = new PrintWriter(os)){
                pw.write("大蛇丸");
                pw.write("eqwewq");
            }
        }
        }
//读取字符流
public static void 读取文本() throws IOException{
        try(InputStreamReader is = new InputStreamReader(new FileInputStream("输出.txt"),"UTF-8")){
            try(Scanner scan = new Scanner(is)){
                while (scan.hasNext()){
                    System.out.println(scan.next());
                }
            }
        }
}


//写入字节流

    public static void 写入二进制(byte[] buffer) throws IOException{
        try(OutputStream os = new FileOutputStream("错图片.jpg")){

            byte[]    buf = new byte[]{'1','0','0','0','0','0','1','0','1'};
            os.write(buffer);
        }
    }

    //读取字节流

    public static byte[] 读取二进制() throws IOException{
        try(InputStream is = new FileInputStream("图片.jpg")){
            byte[] buf = new byte[1500000];
            int len;

            while((len = is.read(buf))!=-1){


            }
            return buf;
        }
    }


}
