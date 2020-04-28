import java.util.*;

public class A35 {

    public static void main(String[] args) {  //6x+8y=n,x+y的最小值
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int n =scan.nextInt();
            System.out.println(method(n));
        }
    }

    public static int method(int n){

           if(n%8==0){
            return n/8;
            }
            int a = n%8;


            for(int i = 0;(8*i+a)<=n;i++){
                if((8*i+a)%6==0){
                    return  (8*i+a)/6+(n-(8*i+a))/8;
                }
            }
            return -1;

    }
}
