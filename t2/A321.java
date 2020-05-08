import java.util.*;

public class A321{//牛客 百万富翁
    public static void main1(String[] args){

        System.out.println((int)(Math.pow(2,30)-1)/1000000 +" "+ 10000000*30);
    }
  //牛客  DNA序列
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

            String a = scan.nextLine();
            int n = scan.nextInt();
            int max = 0;
            int begin = 0;
            for (int i = 0; i < a.length() - n; i++) {
                int cur = 0;
                for (int j = i; j < i + n; j++) {
                    if (a.charAt(j) == 'C' || a.charAt(j) == 'G') {
                        cur++;//有CG就加
                    }
                }
                begin = max >= cur ? begin : i;
                max = max >= cur ? max : cur;

            }
            for (int i = begin; i < begin + n; i++) {
                System.out.print(a.charAt(i));
            }

    }
}