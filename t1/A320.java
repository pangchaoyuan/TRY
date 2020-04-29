import javax.swing.tree.TreeNode;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.X;
import java.util.*;
public class A320 {
 //牛客 火车入站
   public static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr =new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt(); //保存入栈顺序
        }
        Stack<Integer> stack = new Stack<Integer>();//火车站

        method(0, arr, 0, stack, "");//当前入栈次数,当前火车站，当前出栈次数，当前出栈序列

        Collections.sort(list);
        for(String str:list){
            System.out.println(str);
        }

    }

    public static void method( int j,int[] arr,int i , Stack<Integer> stack,String str){ //入次j，arr，出次i，站，记录
         if(i==arr.length){//全出
             list.add(str);
             return;
         }
         if(!stack.isEmpty()){ //第一种，出栈上一个火车
             int tmp = stack.pop();
             method(j,arr,i+1,stack,str+tmp+" "); //写入序列递归
             stack.push(tmp);//恢复车站，接受其他情况
         }
         if(j<arr.length){ //未全入栈
             stack.push(arr[j]);//当前火车入栈
             method(j+1,arr,i,stack,str);
             stack.pop();
         }
    }

/*  牛客 二叉树镜像

    public void Mirror(TreeNode root) {
        TreeNode tmp = null;
        if(root!=null){
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if(root.left!=null){
                Mirror(root.left);
            }
            if(root.right!=null){
                Mirror(root.right);
            }
        }
    }
*/


}
