import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public  class A319 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
        List<Integer> list = new ArrayList<>();
        while(scan.hasNext()){
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[2*n];
            for(int i =0;i<2*n;i++){
                arr[i] = scan.nextInt();
            }
            int[] res = arr;
            for(int i = 0;i<k;i++){
                 res = method(res);
            }
            for(int i : res){
                list.add(i);
            }
        }


        for(int i = 0;i<list.size();i++){
            if(i==list.size()-1){
                System.out.println(list.get(i));
            }else{
                System.out.print(list.get(i)+" ");
            }
        }


    }

    public static int[] method(int[] arr ){
        int[] res = new int[arr.length];
        int j = 0;
        for(int i = 0;i<arr.length/2;i++){
            res[j++] = arr[i];
            res[j++] = arr[i+arr.length/2];
        }
        return res;
    }
}
