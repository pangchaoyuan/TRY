import java.util.*;

public class A326{
    //牛客 每月有几个兔子
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int a = method(n);
            System.out.print(a);
        }
    }

    public static int method(int n){
        if(n==1||n==2){
            return 1;
        }
        int big = 0;  //大兔
        int m1 = 0; //一月兔
        int m2 = 1; //二月兔
        for(int i = 3;i<=n;i++){
            big = big+m2; //
            m2 = m1;
            m1 = big;
        }
        return big+m1+m2;
    }


 //牛客 密码翻译
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String res ="";
            for(char a: str.toCharArray()){
                if(a>='F'&&a<='Z'){
                    a -=5;
                    res += a;
                }else if(a>='A'&&a<'F'){
                    a += 21;
                    res += a;
                }else{
                    res +=" ";
                }

            }
            System.out.println(res);
        }
    }
}