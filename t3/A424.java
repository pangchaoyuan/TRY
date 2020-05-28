import java.util.Arrays;
import java.util.Scanner;

public class A424 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int k = scan.nextInt();
            int d = scan.nextInt();
            //找到前d个里最大的，然后再从这个开始到第d个里找最大的
            int p =0;//下表
            int cur = 0;//记录已经乘了几个数字
            int res = 1;//乘积
            p = target(d,arr,p);
            res *=arr[p];
            cur++;
            while(p<arr.length&&cur<k){
                p = target(d,arr,p+1);
                res *=arr[p];
                cur++;
            }

            System.out.println(res);
        }

    }
    //返回最大的数  s开，s是上一次的下标
    public static int target(int d , int[] arr , int s){
        int max = 0;
        int t =0;
        for(int j = 0; j<d;j++){
             int i = s+j;
                    if(i<arr.length){
                        max = max >arr[i] ?max:arr[i];
                        if(max==arr[i]){
                            t =i;
                    }else{
                            break;
                        }
                }
            }
        return t;
    }

}
