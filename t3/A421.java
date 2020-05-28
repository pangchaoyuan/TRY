import java.util.*;
public class A421 {

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String res = "";
            int num = Integer.MIN_VALUE;//记录下划线
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '_') {
                    num = i;
                    continue;
                }


                if (i == num + 1) {
                    res = res + String.valueOf(str.charAt(i)).toUpperCase();
                } else {
                    res = res + str.charAt(i);
                }
            }
            System.out.println(res);
        }

    }


//=======================

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] arr = str.split(" ");
            String res = "";
            boolean right = true;
            for(String a : arr){
                right = true;
                for(char b :a.toCharArray()){
                    if(!((b>='A'&&b<='Z')||(b>='a'&&b<='z'))){
                        right = false;
                    }
                }
                if(right) res = a +" "+ res ;
            }

            System.out.println(res);
        }
    }
}
