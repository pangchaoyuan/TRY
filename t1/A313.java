import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class A313 {
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        String t = scan.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(char a : t.toCharArray()){
            set.add(a);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        Iterator<Character> it = set.iterator();
        char[] a = new char[set.size()];
        int i = 0;
        while(it.hasNext()){
            a[i++] = it.next();
        }
        Arrays.sort(a);
        for(char j : a){
            System.out.println(j+":"+map.get(j));
        }
    }


    public static int[] multiply(int[] A) {
        int[] b = new int[A.length];
        int tmp = 1;
        b[0] = 1;
        for(int i = 1 ;i<b.length;i++){
            b[i] = b[i-1]*A[i-1];
            System.out.println(b[i]);
        }
        for(int i = b.length-2 ; i>=0;i--){
            tmp*=A[i+1];
            b[i]*=tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(Arrays.toString(multiply(a)));
    }
}
