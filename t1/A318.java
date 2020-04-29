import java.util.*;
public class A318 {
    //牛客 另类加法
    public int addAB(int A, int B) {
        int tmp=1;
        while(B!=0){
            tmp = (A&B)<<1; //进位情况
            A = A^B;//加法
            B = tmp;//将进位放到下一轮算
        }
        return A;
    }
    //牛客 饥饿的小易
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n  = scan.nextInt();
        int sum = 0;
        int x =n;
        while(x!=0&&sum<=300000){
            x=(2*x+1)%1000000007;
            sum++;
        }
        int res = (sum+2)/3;
        System.out.println(res>100000?-1:res);

    }

}
