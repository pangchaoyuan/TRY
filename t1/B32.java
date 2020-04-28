import java.util.*;

public class B32 {

    public static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    //用非递归
    public static int getTarget(int[] a,int left,int right){
        int tmp = a[left];
        int i = left;
        int j = right;
        while(i<j){
            while(i<j&&a[j]<=tmp){
                j--;
            }
            while(i<j&&a[i]>=tmp){
                i++;
            }
            swap(a,i,j);
        }
        swap(a,i,left);
        return i;
    }
    public static void quickSort(int[] a){
        Stack<Integer> stack = new Stack<>();
        stack.push(a.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int i = stack.pop();
            int j = stack.pop();
            if(i>=j){
                continue;
            }
            int mid =  getTarget(a,i,j);

            stack.push(j);
            stack.push(mid+1);
            stack.push(mid-1);
            stack.push(i);
        }
    }


    public static int findKth(int[] a, int n, int K) {
        quickSort(a);   //从大到小非递归快速排序
 /*
       Set<Integer> set = new HashSet<>();   //按数字第k大
       int cur = 0;
       int j =0;
       for(int i =0;i<a.length;i++){
           if(set.size()==K){
               cur = i-1;
           }
           set.add(a[i]);
           if(i==a.length-1){
               cur = i;
           }
       }
        return a[cur];

*/



    return a[K-1]; //按下标第k大

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int n = scan.nextInt();
        int K = scan.nextInt();

        String[] str2 = str.split(" ");

        int[] a =new int[str2.length];
        for(int i = 0;i<a.length;i++){
            a[i] = Integer.parseInt(str2[i]);
        }
        quickSort(a);
        System.out.println(findKth(a,n,K));
    }


}