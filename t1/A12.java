import java.util.Scanner;

public class A12 {
//==============获得给定数字和最近的斐波那契数的差的绝对值
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int tmp = scan.nextInt();
        int x = 0;
        int i = 1;
        while(true){
            int b = method(i);
            int c = method(i+1);
            if(tmp>=b&&tmp<=c){
                x =(tmp-b)>(c-tmp)?(c-tmp):(tmp-b);
                break;
            }else{
                i++;
            }
        }
        System.out.println(x);
    }
    //获得第n个斐波那契数
    public static int method(int n ){
        int a1 = 0;
        int a2 = 1;
        int a3 = 1;
        if(n==1) return a1;
        if(n==2) return a2;
        if(n==3) return a3;
        for(int i = 3;i<n;i++){
            a1 = a2;
            a2 = a3;
            a3 = a1+ a2;
        }
        return a3;
    }

}

//=================从x乘y的网格的左上角走到右下角的方法有几种=============================
 class Robot {
    static int num = 0;
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();
        System.out.println(countWays(x,y));

    }

    public static int countWays(int x, int y) {
        method(0,0);
       return num;

    }

    public  static void method(int row ,int col) {
       if(row>x||col>y) return;
       if(row==x&&col==y){
           num++;
           return;
       }
       method(row,col+1);
       method(row+1,col);

    }
}

class aest{
    public static void main(String[] args) {

        System.out.println( Math.round(-12.5));
    }
}