import javax.swing.tree.TreeNode;
import java.util.*;

public class das {
    public static int n = 0;

    public static int numBusesToDestination(int[][] routes, int S, int T) {

        List<Integer> list = findBus(routes,S);

        return method(routes,T,list);

    }

    public static int method(int[][] routes,int T,List<Integer> list){
        n++;
        if(list==null||list.size()==0) return 0; //没有车符合条件返回 0
        if(!go(n)) return  -1;
        int min =0;

            for(int i : list){
                for(int j =0;j< routes[i].length;j++){             //找T
                    if(routes[i][j]==T){
                        return min+1;               //若相同，返回min+1
                    }if(routes[i][j]!=T){
                        List<Integer> list1 = findBus( routes,j); //不同，递归
                        int tmp = method(routes,T,list1);
                        if(tmp>0){
                            min =  min < tmp? min+1: tmp+1;
                        }
                        if(tmp==-1) min = -1; //返回-1
                    }
                }
            }
            return min;
    }

    public static boolean go(int n ){
        return n<100000;
    }



    //找S的车
    public static List<Integer> findBus(int[][] routes,int station){
        List<Integer> list = new ArrayList<>();
        for(int i  = 0;i < routes.length;i++){
            for(int j = 0 ;j< routes[i].length;j++){
                if(routes[i][j]==station) list.add(i);
            }
        }
        return list;
    }





//=========================================================================












    public static void main(String[] args) {
        int[][] a = {{1,2,7},{7,6,5}};
        int b = numBusesToDestination(a,1,6);
        System.out.println(b);
        List<Integer> a3 = new ArrayList<>();
    }






    public static String compress(char[] chars) {
        StringBuilder str =  new StringBuilder();
        int i =0;

        for( int j =i;j<chars.length;j++){
            if(chars[i]!=chars[j]&&j!=chars.length-1){
                str.append(chars[i]);
                if(j-i!=1) str.append(j-i);
                i=j;
            }

            if(j==chars.length-1){
                if(chars[i]==chars[j]){
                    str.append(chars[i]);
                    if(j-i+1!=1) str.append(j-i+1);
                }else{
                    str.append(chars[i]);
                    if(j-i!=1)str.append(j-i);
                    str.append(chars[j]);
                }
            }


        }
        if(chars.length<=1)return chars.toString();
        for(int j =0;j<str.length();j++){
            chars[j]=str.charAt(j);
        }


        return str.toString();
    }











    public  static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(i<j&&method(s.charAt(i))==-1) i++;
            while(i<j&&method(s.charAt(j))==-1) j--;
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }


    public static int method(char a){
        if(a>='a'&&a<='z'||a>='0'&&a<='9') return (int)a;
        else if(a>='A'&&a<='A') return (int)a+32;
        return -1;
    }




















    public static long myAtoi(String str) {
        boolean tpi = true;
        str = str.trim();
        char[] str1 = str.toCharArray();
        StringBuilder res = new StringBuilder();
        int b=0;
        if(str.length()==0||str==null) return 0;
        for(char a : str1){
            if(a=='+'||a=='-'){
                if(b!=0) return 0;
                if(a=='-') tpi =false;
                b++;
            }else if(a>='0'&&a<='9') res.append(a);
            else if(a==' ') continue;
            else break;
        }
        String l1 = res.toString();
        if(l1==null||l1.length()==0) return 0;
        long l = Long.parseLong(l1);
        if(l>=2147483647&&tpi) return 2147483647;
        if(l<=-2147483648&&!tpi) return -2147483648;
        return tpi?l:-l;

    }
}




