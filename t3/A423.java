import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A423 {


    public int MoreThanHalfNum_Solution(int [] array) {
        int target = 0;

        Map<Integer,Integer> map = new HashMap<>();
        for(int a : array){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int a : map.keySet()){
            if(map.get(a)>array.length/2){
                target = a;
            }
        }

        return target;



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Scanner scan = new Scanner(System.in);
            Map<String, Integer> map = new HashMap<>();

            while (scan.hasNext()) {
                String str = scan.next();
                int n = scan.nextInt();
                int p = getNum(str); //

                String str1;
                if (str.length() - p - 1 >= 16) {
                    str1 = str.substring(p + 1, p + 17);
                } else {
                    str1 = str.substring(p + 1);
                }
                String res = "";
                res = res + str1 + " " + n;
                map.put(res, map.getOrDefault(res, 0) + 1);
            }
            for (String a : map.keySet()) {
                System.out.println(a + " " + map.get(a));
            }

        }
    }

    public static int getNum(String str){ //获取最后一个\
        int num = 0;
        for(int i = str.length()-1;i>=0;i--){
            if(str.charAt(i)=='\\'){
             num = i;
             break;
            }
        }
        return num;
    }
}
