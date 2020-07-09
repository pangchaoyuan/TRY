import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Node {
     int key;
    //平衡因子
     int bf;
     Node left;
     Node right;

    //记录父节点如果当前节点为根，则此为null
     Node parent ;

   public Node(int key, Node parent){
        this.key = key;
        this.bf = 0;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }

}


class Main{
    public static void main(String[] args) {
        Random random = new Random();
        AVL树  tree = new AVL树();
        for(int i = 0 ; i <20;i++){
            try{
                tree.insert(random.nextInt(100000));
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        verify(tree);

    }

    //验证AVL树是否正确
    public static void verify(AVL树 tree){
        List<Integer> list = new ArrayList<>();
        中序遍历(tree.root,list);
        List<Integer> list1= new ArrayList<>(list);
        Collections.sort(list1);
        //中序遍历
        if(!list1.equals(list)){
            throw new RuntimeException("该树中序遍历无序");
        }else{
            System.out.println("1.中序遍历有序");
        }

      try{
          bf(tree.root);//平衡因子
      }catch (RuntimeException e){
          System.out.println("平衡因子算错");
      }
          System.out.println("2.平衡因子正确");



    }

    public static void 中序遍历(Node root,List<Integer> list){
        if(root==null) return;
        Node cur = root;
        中序遍历(cur.left,list);
        list.add(cur.key);
        中序遍历(cur.right,list);
    }

    //
    public static void bf(Node root){
        if(root==null){return;}
        int left = height(root.left);
        int right =height(root.right);
        //平衡因子不是1 -1 0 以及平衡因子不等于左右树高度之差
        //抛出异常
        if(left-right!=root.bf||root.bf>1||root.bf<-1){
            throw new RuntimeException();
        }
        bf(root.left);
        bf(root.right);
    }


    //获得树高度
    public static int height(Node root){
        if(root==null){
            return 0;
        }
       int a = height(root.right);
       int b =  height(root.left);
       return Math.max(a,b)+1;
    }
}
