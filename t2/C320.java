import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class C320 {
    public static void main(String[] args) {
        File root = new File("F:\\emulator\\nemu\\vms"); //遍历这文件夹下所有文件
        travelDepth(root);
        System.out.println("=====================================================================");
        travelBroad(root);
    }


    private static void travelDepth(File node){ // 深度优先
        System.out.println(node.getAbsolutePath());
    if(node.isDirectory()){
        File[] files = node.listFiles();
        if(files!=null){
            for(File r :files){
              travelDepth(r);
            }
        }
    }
    }

    private static void travelBroad(File node){//  广度优先
     Queue<File> queue = new LinkedList<>();
        queue.add(node);
        if(!queue.isEmpty()){
            File ff = queue.remove();
            System.out.println(ff.getAbsolutePath());
            if(ff.isDirectory()){
                File[] files = ff.listFiles();
                for(File ss : files){
                    queue.add(ss);
                }
            }
        }

    }
}
