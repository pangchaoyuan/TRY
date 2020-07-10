import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class a200604SocketClient {

    private static final  String serverIP = "127.0.0.1";
    public static void main(String[] args) throws IOException {
         try(DatagramSocket socket = new DatagramSocket()) {


             while(true) {

                 Scanner scan = new Scanner(System.in);
                 System.out.print("请输入信息:");
                 String request = scan.next();
                 byte[] buf = request.getBytes(Server.CHARSET);

                 DatagramPacket dp;
                 dp = new DatagramPacket(buf, 0, buf.length, InetAddress.getByName(serverIP), Server.PORT);
                 socket.send(dp);

                 //接受服务器返回
                 byte[] b2 = new byte[8192];
                 DatagramPacket dp2 = new DatagramPacket(
                         b2,0,b2.length
                 );

                 socket.receive(dp2);
                 String str = new String(b2,0,dp2.getLength(),Server.CHARSET);
                 System.out.println("你：" + str);
             }

        } catch (SocketException e) {
            e.printStackTrace();
        }


    }
}
