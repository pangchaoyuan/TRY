import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Relative {
    public static void main1(String[] args) throws IOException {
        String name = "相对路径.txt";
        File file =  new File(name);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        file.createNewFile();
        System.out.println(file.exists());
    }

    public static void main(String[] args) throws IOException {
        InputStream io = new FileInputStream("读.txt");

        int b;
        while((b=io.read())!=-1){
            System.out.println(b);
        }

        byte[] a = new byte[2];
        int len;
        while((len=io.read(a))!=-1){
            System.out.println("一次");
            for(int i = 0;i<len;i++){
                System.out.println(a[i]);
            }
        }
    }
}
