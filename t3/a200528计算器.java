import sun.reflect.generics.tree.Tree;


import javax.xml.soap.Node;
import java.util.*;

public class a200528计算器 {

   public static List<String> list2 = new ArrayList<>();

    static class Node{
        public char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        String str = "5*4-3*4";
        build(str);


    }



    //以index位置的运算符为最低优先级建立二叉树
    private static void   build(String str){
        if(str.length() ==0){
            return ;
        }
        List<Integer> list= getIndex(str);


        for(int target : list){
            String left1 = str.substring(0,target);
            //System.out.println(left1);

            String right1 =str.substring(target+1);
            //System.out.println(right1);

            Node head = buildeMethod(str,left1,right1,target);

             list2.add(deplay(head));
             List<Integer> list1 = new ArrayList<>();
             Set<String> set = new HashSet<>();

             for(String str1 : list2){

                list1.add(getNum(str1));

            }



            for(int str1 : list1){
                System.out.println(str1);

            }




        }

    }

    private static int getNum(String str1) {
        Stack numStack = new Stack();
        for(char a : str1.toCharArray()){
            if(a>'0'&&a<'9'){
                numStack.add(a);

            }else{
                if(!numStack.isEmpty()){
                    int a1 = Integer.parseInt(numStack.pop().toString());//先出放右
                    int a2 = Integer.parseInt(numStack.pop().toString());
                    if(a=='+'){numStack.add(a2+a1);}
                    if(a=='-'){numStack.add(a2-a1);}
                    if(a=='*'){numStack.add(a2*a1);}
                    if(a=='/'){numStack.add(a2/a1);}
                }
            }
        }
        return Integer.parseInt(numStack.pop().toString());
    }

    private static String deplay(Node head) {
        String str = "";
        if(head.left!=null){
            str = str+ deplay(head.left);
        }
        if(head.right!=null){
            str = str+ deplay(head.right);
        }

        str = str +head.data;
        return str;
    }

    private static Node buildeMethod(String str,String left,String right,int index){
        Node root = new Node(str.charAt(index));

        //System.out.println(left);
       // System.out.println(right);
        if(left.length()==1){
            Node node1 = new Node(left.charAt(0));
            root.left = node1;
            //System.out.println(node1.data);
        }

        if(right.length()==1){
            Node node1 = new Node(right.charAt(0));
            root.right = node1;
           // System.out.println(node1.data);
        }



        List<Integer> listleft = new ArrayList<>();
        List<Integer> listright = new ArrayList<>();


        listleft = getIndex(left);
        listright = getIndex(right);


        for(int target : listleft){
            if(target!=0){
                String left1 = left.substring(0,target);
                String right1 =left.substring(target+1);
                root.left =  buildeMethod(left,left1,right1,target);
            }

        }
        for(int target : listright) {
            if(target!=0){
                String left1 =right.substring(0,target);
                String right1 =right.substring(target+1);
                root.right = buildeMethod(right, left1, right1, target);
            }

        }

        return root;


    }



    //获取所有符号的位置
    public static List getIndex(String str){
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for(char a :str.toCharArray()){
            if(a =='+'||a =='-'||a =='/'||a =='*'){
                list.add(index);
            }
            index++;
        }
        return list;
    }




}
