import java.util.*;

public class B33 {
    public static int count(int[] A, int n) {
        int c = 0;
        for(int i =0;i<A.length;i++){
            for(int j =i;j<A.length;j++){
                if(A[j]<A[i]) c++;
            }
        }
        return c;
    }
    public static void main(String[] args) {
           Scanner scan = new Scanner(System.in);
           List<Integer> list = new ArrayList<>();
           while(scan.hasNextInt()){
               list.add(scan.nextInt());
           }
           int[] a = new int[list.size()-1];
           for(int i =0;i<a.length;i++){
               a[i] = list.get(i);
           }
        System.out.println(count(a,a.length));

    }
}
