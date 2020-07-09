import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class a200605http {

    public static void main(String[] args) throws IOException {
        String path = "index.html";
        String host = "www.bilibili.com/";

        try(Socket socket = new Socket("docs.oracle.com",80)){
            //发送
            String request = "GET "+ path + " Http/1.0\r\n " +
                    "Host: "+host +"\r\n" +
                    "\r\n";
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            printWriter.write(request);
            printWriter.flush();

            //接收1
/*
            byte[] buf = new byte[8192];
             socket.getInputStream().read(buf);

            String str = new String(buf,0,buf.length);
            System.out.println(str);
*/
           // 接收2
            System.out.println("================================");

            Scanner scanner = new Scanner(new InputStreamReader(socket.getInputStream()));
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }

            }


}
