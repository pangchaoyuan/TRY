
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class C43 {
    public static void main(String[] args) throws IOException {

        String path = "/pcy/hello.txt";
        String host = "127.0.0.1";
        try (Socket socket = new Socket(host, 8080)) {
            String request =
                    "GET " + path + " HTTP/1.0\r\n" +
                            "\r\n";

            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            printWriter.print(request);
            printWriter.flush();

            // 请求发送结束
            // 读取响应

            // 这里有 BUG，假设我可以一次性把所有内容都读完
            byte[] responseBuffer = new byte[8192];
            int len = socket.getInputStream().read(responseBuffer);

            String response = new String(responseBuffer, 0, len, "UTF-8");
            System.out.println(response);
        }
    }
}
