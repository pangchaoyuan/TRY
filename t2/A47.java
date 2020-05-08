
import java.util.Scanner;
public class A47 {
    private static final int[] W = {17*29,29,1};
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] p = in.next().split("\\.");
        String[] a = in.next().split("\\.");
        int[] P = {Integer.parseInt(p[0]),Integer.parseInt(p[1]),Integer.parseInt(p[2])};
        int[] A = {Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2])};
        int ta = A[0]*W[0]+A[1]*W[1]+A[2]*W[2];
        int tp = P[0]*W[0]+P[1]*W[1]+P[2]*W[2];
        int t = ta-tp;
        if(ta<tp){
            System.out.print("-");
            t = -t;
        }
        System.out.println(t/W[0]+"."+t%W[0]/W[1]+"."+t%W[0]%W[1]/W[2]);
    }


    //================================================

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(30));
    }

    public static int countNumberOf2s(int n) {
        int num = 0;
        for(int i = 1; i<=n ;i*=10){
            int a1 = n/i;
            int a2 = n%i;
  //一个10里个位有1个2，一个100里十位有10个2，一个1000里百位有100个2（但条件是，要大于2<所以需要加7筛选）
            num += (a1+7)/10*i;
  //等于2时的处理(十位等于2时，i=10,百位等于2时，i==100，用n来)
            if(a1%10==2){
                num += a2+1;
            }

        }

        return num;
    }
}