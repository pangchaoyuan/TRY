//练习

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.CallableStatement;
import java.util.Scanner;

class FileTestAboutIO{
    public void 字节流R() throws IOException {
        InputStream is = new FileInputStream("??.txt");
        byte[] buf = new byte[9000];
        int len = 0;
        while((len = is.read(buf))!=0){
            //System.out.println();
        }
        // return buf;
    }


    public void 字符流W() throws IOException{
       try(OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(">.txt"),"UTF-8")) {
           try (PrintWriter pw = new PrintWriter(ow)) {
               pw.write("daqsfdsfgwetgrg");
           }
       }
    }

    public void 字节流W() throws IOException{
        OutputStream os = new FileOutputStream("?.jpg");
        byte[] buf = new byte[90000];

        os.write(buf);
    }

    public void 字符流R() throws IOException{
        try(InputStreamReader ir = new InputStreamReader(new FileInputStream("?.txt"),"UTF-8")){
            try(Scanner scan = new Scanner(ir)){
                while(scan.hasNext()){

                }
            }
        }
    }
}





public class a200604Socket {
}



class Server{
    static final int PORT = 11111;
    static final String CHARSET = "UTF-8";

    public static void main(String[] args)  {
        try(DatagramSocket socket = new DatagramSocket(PORT)) {


            byte[] buf = new byte[8192];

            while(true){
                //创建办数据报文对象

                DatagramPacket packetFromClient = new DatagramPacket(
                        buf,0,buf.length);//左闭右开
                socket.receive(packetFromClient);
                String request = new String(buf,0,buf.length,CHARSET);
                System.out.println("对方: " + request);


                //开始传回

                byte[] aa = request.getBytes();

                DatagramPacket dp = new DatagramPacket(
                        aa,0,aa.length,packetFromClient.getAddress(),packetFromClient.getPort()
                );

                socket.send(dp);
                System.out.println("已发送回执");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}