import java.io.File;
import java.io.IOException;

public class B320 {


    public static void main(String[] args) throws IOException {
        String path = "F:\\emulator\\nemu\\vms";
        File file = new File(path);
        System.out.println(file);


        String parent="F:\\emulator\\nemu";
        String path2 = "烤全羊啊恩.xml\\sssssss";
        File file1 = new File(parent,path2);
        System.out.println(file1);
        System.out.println(file.isDirectory()); //是否绝对路径
        System.out.println(file.isAbsolute());//是否可执行
        System.out.println(file.canWrite());//是否可写
        System.out.println(file.getParent());
        System.out.println(file1.exists()); //是否存在

        boolean  sucess = false;//file1.createNewFile();
        if(sucess){
            System.out.println("xml文件创建成功");
        }else{
            System.out.println("xml文件创建失败");
        }
        System.out.println(file1.exists());
        file1.delete();

        boolean sss = file1.mkdirs();//mkdir在当前目录创建文件夹(若上级文件夹不存在会失败),mkdirs会补全不存在的路径
        System.out.println(file1.exists());
        if(sss){
            System.out.println("文件夹创建成功");
        }else{
            System.out.println("文件夹创建失败");
        }
        file1.delete();

        File[] files =  file1.listFiles(); //遍历当前文件夹下文件
        if(files!=null){
            for(File die:files){
                System.out.println(die.getName());
            }
        }
    }
}
