import javax.security.sasl.SaslClient;
import java.util.*;

public class A411 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for(char a = 'A';a<='Z';a++){
                map.put(a,0);
            }
            for(char a : str.toCharArray()){
                map.put(a,map.getOrDefault(a,0)+1);
            }

            for(char a = 'A';a<='Z';a++){
                System.out.println(a+":"+ map.get(a));
            }


        }
    }
    //============================================
  //牛客 进制转换
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){

            System.out.println(Integer.decode(scan.nextLine()));
        }
    }
}
