import java.util.*;

public class A44{
    //奇偶校验 牛客
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String n =scan.nextLine();
            char[] array = n.toCharArray();
            for(char a : array){
                int b =a-'\0';
               String s = Integer.toString(b,2);
                while (s.length() < 7) {
                    s = '0'+s;
                }
                int num = 0;
                for(char a1 : s.toCharArray()){
                    if(a1=='1'){
                        num++;
                    }
                }

               if(num%2==1){
                    System.out.println("0"+s);
                }
                if(num%2==0){
                    System.out.println("1"+s);
                }

            }
        }
    }
}