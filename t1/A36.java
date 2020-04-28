import java.util.*;

public class A36{

    private static int[] array;
    private static int num = 0;
    private static   int n =0;

 //大小为N的数组，从中找出相加等于40的组合有几种
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
         n = scan.nextInt();
         array = new int[n];
        for(int i =0;i<n;i++){
            array[i] = scan.nextInt();
        }
        method(0,0);
        System.out.println(num);
    }

    public  static void method(int i ,int weight){
        if(i==n) return;
        if(weight+array[i]==40){
            num++;
        }
        method(i+1,weight);  //遍历到下一个物品，并且不加当前物品重量
        method(i+1,weight+array[i]); //遍历到下一个物品，并且加上当前物品重量
    }
}