import java.lang.reflect.Array;
import java.util.*;

public class A317{ //牛客 组个最小数
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        String a  = scan.nextLine();
        String[] a1 = a.split(" ");
        int[] array = new int[a1.length];
        for(int i = 0;i<array.length;i++){
            array[i] = Integer.parseInt(a1[i]);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for(int i = 0;i<array.length;i++){
            if(array[i]!=0){
                if(i==0){
                    break;
                }else{
                    int tmp = array[i];
                    array[i] = array[0];
                    array[0] = tmp;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        for(int b : array){
            System.out.print(b);
        }
    }


    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a  = scan.nextLine();
        String[] a1 = a.split(" ");
        int[] array1 = new int[a1.length];
        for(int i = 0;i<array1.length;i++){
            array1[i] = Integer.parseInt(a1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i< array1.length;i++){
            int n = array1[i];
            while(n>0){
                list.add(i);
                n--;
            }
        }
        int[] array = new int[list.size()];
        for(int i = 0;i<array.length;i++){
            array[i] = list.get(i);
        }
        Arrays.sort(array);
        for(int i = 0;i<array.length;i++){
            if(array[i]!=0){
                if(i==0){
                    break;
                }else{
                    int tmp = array[i];
                    array[i] = array[0];
                    array[0] = tmp;
                    break;
                }
            }
        }
        for(int b : array){
            System.out.print(b);
        }

    }
 //牛客 尼科彻斯定理
    public static void main(String[] args){
        while(true){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
            if(n==0){
                System.out.print(0);
                continue;
            }
        int m = n*n*n;
        int x = m/n;

        if(x%2==0){
            x = x-1 -((n-2)/2)*2;
        }else{
            x = x - ((n-1)/2)*2;
        }

        for(int i = 0;i< n;i++,x+=2){
            if(i==n-1){
                System.out.print(x);
            }else{
                System.out.print(x+"+");
            }

        }

    }
}


    public static String GetSequeOddNum(int n){
        if(n==0){
            return "0";
        }

        int m = n*n*n;
        int x = m/n;

        if(x%2==0){
            x = x-1 -((n-2)/2)*2;
        }else{
            x = x - ((n-1)/2)*2;
        }
        String a = "";
        for(int i = 0;i<n;i++,x+=2){
            if(i==n-1){
                a+=x;
            }else{
                a+=x;
                a+="+";
            }
        }
        return a;
    }

    public static void main3(String[] args) {
        System.out.println(GetSequeOddNum(0));
    }
}