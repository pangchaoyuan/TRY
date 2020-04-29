import java.util.Scanner;
import java.util.*;

public class A316{   //显示一个边长为n的由字符c构成的正方形
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] a = s.split(" ");
        int n = Integer.parseInt(a[0]);
        String c = a[1];
        String[][] str = new String[n][Math.round(((float)n)/2)];
        for(int i = 0;i<n;i++){
            if(i==0||i==n-1){
                for(int j =0;j<Math.round(((float)n)/2);j++){
                    str[i][j] = c;
                }
            }else{
                for(int j =0;j<Math.round(((float)n)/2);j++){
                    if(j==0||j==Math.round(((float)n)/2)-1){
                        str[i][j] = c;
                    }else{
                        str[i][j] = " ";
                    }
                }
            }
        }

        for(int i = 0;i<Math.round(((float)n)/2);i++){

            for(int j = 0;j< n;j++){
                System.out.print(str[j][i]);
            }
            System.out.println();
        }
    }
}
 class Main{   //大数加法
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
       // while(scan.hasNext()) { 在牛客上要加这一句
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            String res = "";
            if (str1.length() < str2.length()) {
                String tmp = str2;
                str2 = str1;
                str1 = tmp;
            }
            str1 = '0' + str1;
            int len = str2.length();
            for (int i = 0; i < str1.length() - len; i++) {
                str2 = '0' + str2;
            }
            int t = 0;
            for (int i = str1.length() - 1; i >= 0; i--) {
                t = t + Integer.parseInt(Character.toString(str1.charAt(i))) + Integer.parseInt(Character.toString(str2.charAt(i)));
                if (t >= 10) {
                    int a = t % 10;
                    res = a + res;
                    t = 1;
                } else {
                    res = t + res;
                    t = 0;
                }
            }

            if (Integer.parseInt(Character.toString(res.charAt(0))) == 0) {
                res = res.substring(1, res.length());
            }
            System.out.println(res);
        //}
    }


}