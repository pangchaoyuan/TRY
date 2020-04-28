import java.util.*;

public class A10{


 //输出数组中最小的k个数字
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] str = s.split(" ");
        int[] array = new int[str.length-1];
        int k = Integer.parseInt(str[str.length-1]);
        for(int i =0;i<array.length;i++){
            array[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(array);
        for(int i = 0;i<k;i++){
            System.out.print(array[i]+" ");
        }
    }
}