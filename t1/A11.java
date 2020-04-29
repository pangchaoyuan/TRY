import java.util.Scanner;

public class A11{
    //逆序输出
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println(new StringBuilder(scan.nextLine()).reverse());

    }


    //n的阶乘最后有几个零
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num = 0;
        //首先拆分成1*5,2*5,3*5....x*5 。然后再看从1到x里还有几个带5的 比如 x = a *5 的情况，直到所有5的另一个乘数到达5以下为止。
        while(n>0){
            num+=n/5;
            n/=5;
        }

        System.out.println(num);
    }

}


