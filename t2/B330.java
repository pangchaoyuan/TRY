import java.util.Scanner;

public class B330 {
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            double[] array = new double[n];
            for(int i = 0;i<n;i++){
                array[i] = scan.nextInt();
            }
            double[] a = new double[n];
            System.arraycopy(array,0,a,0,array.length);
            for(int i = 0;i < n ;i++){
                int x =scan.nextInt();
                if(x>=90&&x<=100){
                    array[i] *= 4.0;
                }else if(x>=85&&x<=89){
                    array[i] *= 3.7;
                }else if(x>=82&&x<=84){
                    array[i] *= 3.3;
                }else if(x>=78&&x<=81){
                    array[i] *= 3.0;
                }else if(x>=75&&x<=77){
                    array[i] *= 2.7;
                }else if(x>=72&&x<=74){
                    array[i] *= 2.3;
                }else if(x>=68&&x<=71){
                    array[i] *= 2.0;
                }else if(x>=64&&x<=67){
                    array[i] *= 1.5;
                }else if(x>=60&&x<=63){
                    array[i] *= 1.0;
                }else{
                    array[i] *= 0;
                }
            }
            double sum1 = 0;//绩点和
            double sum2 = 0;//总学分

            for(int i = 0;i<n;i++){
                sum1 += array[i];
                sum2 += a[i];
            }
            sum1 = Double.valueOf(String.format("%.2f",sum1));
            sum2 =  Double.valueOf(String.format("%.2f",sum2));
            System.out.printf( "%.2f",(sum1/sum2));

        }
    }
}
