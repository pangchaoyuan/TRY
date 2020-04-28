import java.util.*;
//牛客 计算糖果
public class A37{
    public static int[] method(int[] array){
        int[] res = new int[3];
        int A = array[2] + array[0];
        int B = array[1] + array[3];
        int C = array[3] - array[1];
        if(A%2==1||B%2==1||C%2==1||A<0||B<0||C<0) {
            res[0] = -100;
            return res;
        }else{
            res[0] = A/2;
            res[1] = B/2;
            res[2] = C/2;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] array = new int[4];
        for(int i =0;i<4;i++){
            array[i] = scan.nextInt();
        }
        int[] a =  method(array);
        if(a[0]==-100){
            System.out.println("No");
        }else{
            for(int i =0;i<a.length;i++){
                System.out.print(a[i]);
                if(i!=a.length-1){
                    System.out.print(" ");
                }
            }
        }

    }
}
