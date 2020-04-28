import java.util.*;
public class A32 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine(); int res = 0;
        int len = str1.length();
        for(int i = 0;i<len+1;i++){
            StringBuilder s1 = new StringBuilder(str1);
            s1.insert(i,str2);
            System.out.println(s1);
            int j = 0;
            boolean tim = false;
            while(2*j<s1.length()){
                if(s1.charAt(j)==s1.charAt(s1.length()-j-1)){
                    tim = true;
                    j++;
                }else{
                    tim = false;
                    j++;
                    break;
                }
            }
            if(tim){
                res++;
            }
        }

        System.out.println(res);

    }
}
