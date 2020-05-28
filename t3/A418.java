import java.util.Scanner;

public class A418 {
    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int y = scan.nextInt();
            int m = scan.nextInt();
            int d = scan.nextInt();
            System.out.println(method(y,m,d));
        }
    }

    public static int method(int y , int m, int d){
        int res1 = 0;
        int res2 = 0;
        int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};

        for(int i = 0;i<m-1;i++){
            if(y%400!=0||(y%100==0&&y%400!=0)||y%4!=0){ //非闰年
                res1 +=arr[i];  //非
            }else{
                res2 +=arr[i];  //闰
            }
        }
        res1+=d;
        res2+=d;
        if(m>2){
            res2+=1;
        }
        return res1>res2?res1:res2;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String str2 = scan.nextLine();
            String res1 = "";
            String res2 = "";



            //加

            str = str.toLowerCase();
            for(int i = 0 ; i <str.length();i++){
                if(str.charAt(i)=='z'){
                    res1 = res1+'a';
                }else if(str.charAt(i)=='9'){
                    res1 = res1 +'0';

                }else{
                    char a =str.charAt(i);
                    res1 = res1 + (char)(a+1);
                }
            }
            res1 = res1.toUpperCase();

            //解

            for(int i = 0 ; i <str2.length();i++){
                if(str2.charAt(i)=='A'){
                    res2 = res2+'Z';
                }else if(str2.charAt(i)=='0'){
                    res2 = res2 +'9';
                }else{
                    char a =str2.charAt(i);
                    res2 = res2 + (char)(a-1);
                }

            }
            res2 = res2.toLowerCase();


            System.out.println(res1);
            System.out.println(res2);

        }
    }
}
