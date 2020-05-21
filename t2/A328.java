import java.util.*;
public class A328{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
           int  n = scan.nextInt();
            int m = scan.nextInt();
            int[] num = new int[n];
            for(int i= 0;i<n;i++){
                num[i] = scan.nextInt();
            }
            for(int i = 0;i< m;i++){ //操作M次
               String  c = scan.next();
                int x = scan.nextInt();
                int y = scan.nextInt();
                if(c.equals("U")){
                   num[x-1] = y;
                }
                if(c.equals("Q")){
                    x = x<0?0:x-1;
                    y = y>=num.length ? num.length-1:y-1;
                    int max = getMax(num,x,y);
                    System.out.println(max);
                }
            }

        }

    }

    public static int getMax(int[] array,int s ,int e){
        int max = 0;
        for(int i = s; i<=e; i++){
            max = max>array[i]?max:array[i];
        }
        return max;
    }



//========================================================


    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int s = scan.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i =0;i<n;i++){
                list.add(scan.nextInt());
            }
            for(int i : list){
               int res = method(s,i);
               s+=res;
            }
            System.out.println(s);

        }
    }

    public static int method(int c ,int b){ //获取增长值
        int max = 0;
        if(c>=b){
            return b;
        }else{

            for(int i = 1;i<=c;i++){
                if(c%i==0&&b%i==0){
                    max = max>i?max:i;
                }
            }
        }
        return max;
    }
}