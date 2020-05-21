import java.util.*;
public class A331{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int s = n*n;
            String n1 = String.valueOf(n);
            String s1 = String.valueOf(s);
            int sum1 = 0;
            int sum2 = 0;
            for(char i : n1.toCharArray()){
                sum1 += Integer.parseInt(String.valueOf(i));
            }
            for(char i : s1.toCharArray()){
                sum2 += Integer.parseInt(String.valueOf(i));
            }
            System.out.println(sum1+" "+sum2);

        }
    }
}