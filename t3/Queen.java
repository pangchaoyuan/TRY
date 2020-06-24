import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen {

}

//发现用顺序表存储boolean类型二维数组时 在其他地方遍历会初始化为false

class Solution {




    public static void main(String[] args) {
        solveNQueens(4);
    }

   static List<boolean[][]> bools = new ArrayList<>();


    public static List<List<String>> solveNQueens(int n) {
        boolean[][] bool = new boolean[n][n];

        method(0,n,bool);

        for(boolean[][] b : bools){
            System.out.println("============加入顺序表后===============");
            for(boolean[] a : b){
                for(boolean c :a){
                    System.out.print(c+" ");
                }
                System.out.println();
            }
        }

       return change(n,bools);
    }

    public static List<List<String>> change(int n,List<boolean[][]> bools) {

        List<List<String>> res = new ArrayList<>();
        //拿到方案
        for(boolean[][] bool : bools){
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i <bool.length;i++){
                    String str = "";
                for(int j = 0 ; j<bool[i].length;j++){
                     if(bool[i][j])
                         str+="Q";
                     str+=".";
                }
                list.add(str);
            }
            res.add(list);
        }
        return res;
    }

    public  static  void method(int row,int n,boolean[][] bool){

        if(row==n){
            boolean[][] bol = bool;
            bools.add(bol);
           // System.out.println("=========bol的内容================");
//            for(boolean[] a :  bol){
//                for(boolean c :a){
//                    System.out.print(c+" ");
//                }
//                System.out.println();
//            }
            return;
        }

        for(int i = 0 ; i < n ;i++){
            if(isVailed(row,i,bool)){
                bool[row][i] = true;
                method(row+1,n,bool);
                bool[row][i] = false;
            }

        }
    }



   public  static boolean isVailed(int row, int col, boolean[][] bool) {
       for(int i = 0 ; i <bool.length;i++){
            for(int j = 0 ; j<bool[i].length;j++){
                if(bool[i][j]&&(
                        j==col||
                        i+j==col+row||
                        j-i==col-row)){
                    return false;
                }
            }
        }

        return true;
    }


}