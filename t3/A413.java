import java.util.*;

public class A413{
    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n;i++){
                int x = scan.nextInt();
                int len = scan.nextInt();
                if(x==1){
                    arr[i] = len;
                }
                if(method2(x,arr,len)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }

    public static boolean method2(int x ,int[] arr,int len){
        if(arr.length<=2){
            return false;
        }

        if(x==2){
            for(int i = arr.length-1; i>=0;i--){
                if(arr[i]==len){
                    arr[i]=0;
                    break;
                }
            }
        }

        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0;i<arr.length-1;i++){
            sum +=arr[i];
        }
        return sum>arr[arr.length-1];
    }



    //========================
    public static int min = 0;
    public static String res = "";
    public static boolean[][] arr ; //记录能走的格子  纵横坐标
    public static int n = 0;
    public static int m = 0;
    public static boolean a =false;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
             n = scan.nextInt();
             m = scan.nextInt();
            int p = scan.nextInt();
            boolean[][] run = new boolean[n][m];//记录走过的格子
            arr = new boolean[n][m];
            for(int i = 0;i<n*m;i++){
                int s = scan.nextInt();
                if(s==1){
                    arr[(i-1)/n][i%n] = true;
                }
            }
            min = n*m;
            method(run,p,0,0,"",0);
            if(!a){
                System.out.println("Can not escape!");
            }else{
                System.out.println(res);
            }

        }
    }

    public static  void method(boolean[][] run,int p,int heng,int zong,String str,int num){
        if(heng==0&&zong==m-1){
            min = min<num?min:num;
            if(num<min){
                str = str+"["+0+","+n+"]";
                res = str;
                a = true;
                return;
            }
        }
        if(p<=0){
            a = false;
            return;
        }

        if(heng<m&&zong<n){//保证不越界才递归
            run[zong][heng] = true;
            str = str+"["+zong+","+heng+"]"+",";
            if(zong+1<=n-1&&arr[zong+1][heng]&&!run[zong+1][heng]){
                method(run,p,heng,zong+1,str,num+1);
            }
            if(zong-1>=0&&arr[zong-1][heng]&&!run[zong-1][heng]){
                method(run,p-3,heng,zong-1,str,num+1);
            }
            if(heng-1>=0&&arr[zong][heng-1]&&!run[zong][heng-1]){
                method(run,p-1,heng-1,zong,str,num+1);
            }
            if(heng+1<=m-1&&arr[zong][heng+1]&&!run[zong][heng+1]){
                method(run,p-3,heng+1,zong,str,num+1);
            }
        }

    }

}