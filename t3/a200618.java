import java.util.*;

public class a200618 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            int n = scan.nextInt();
            scan.nextLine();
            for(int i = 0 ; i < n;i++){
                System.out.println(scan.nextLine().replaceAll("(.)\\1+","$1$1").replaceAll(
                        "(.)\\1(.)\\2","$1$1$2"
                ));

            }
        }

    }
}
