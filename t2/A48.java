import java.util.*;

public class A48 {

    //锤子，剪刀，布  牛客
    private static int[] A ={0,0,0,0};//J赢，C赢，B赢，平,字母顺序不能改
    private static int[] B ={0,0,0,0};

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < n; i++) {
                String str = scan.nextLine();
                String[] s1 = str.split(" ");
                method(s1[0], s1[1]);
            }

            int winA = 0;
            int winB = 0;
            int eqA = 0;
            int eqB = 0;
            String wA = "";
            String wB = "";
            int maxA = 0;
            int maxB = 0;

            for(int i = 0; i<5;i++){
                if(i<=2){
                    if(A[i]>=maxA){   //等号确保字母序小的能替换大的
                        maxA = A[i];
                        if(i==0) wA = "J";
                        if(i==1) wA = "C";
                        if(i==2) wA = "B";
                    }
                    if(B[i]>=maxB){
                        maxB = B[i];
                        if(i==0) wB = "J";
                        if(i==1) wB = "C";
                        if(i==2) wB = "B";
                    }
                    winA+=A[i];
                    winB+=B[i];
                }
                if(i==3){
                    eqA = A[i];
                    eqB = B[i];
                }
            }

            System.out.println(winA+" "+eqA+" "+winB);
            System.out.println(winB+" "+eqB+" "+winA);
            System.out.println(wA+" "+wB);

        }
    }

    public static void method(String a ,String b){
        if(a.equals("J")&&b.equals("B")){
            A[0]++;
        }else if(a.equals("B")&&b.equals("J")){
            B[0]++;
        }else if(a.equals("B")&&b.equals("C")){
            A[2]++;
        }else if(a.equals("C")&&b.equals("B")){
            B[2]++;
        }else if(a.equals("J")&&b.equals("C")){
            B[1]++;
        }else if(a.equals("C")&&b.equals("J")){
            A[1]++;
        }else{
            A[3]++;
            B[3]++;
        }
    }
//==============================

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }

    public static int  countWays(int n) {

        long[] arr = new long[100001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4 ;i<=n;i++){
            arr[i] = (arr[i-1]+arr[i-2]+arr[i-3])%1000000007;
        }
        return (int)arr[n];
    }
}