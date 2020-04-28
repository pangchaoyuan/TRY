import java.util.*;

    public  class A33 {
        public static int method (int n){
            if(n==2) return 1;
            if(n<2) return 0;
             int a = n%3+n/3;
             int res = method(a);
             return res+n/3;
        }



        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

             while(scan.hasNextInt()) {
                 int a = scan.nextInt();
                 System.out.println(method(a));
             }

        }
    }

