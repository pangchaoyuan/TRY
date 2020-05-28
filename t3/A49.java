import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A49 {
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            Set<String> set = new HashSet<>();
            String s1 = scan.nextLine();
            String s2 = scan.nextLine();
            for(char a : s1.toCharArray()){

                String a1 = String.valueOf(a).toUpperCase();
                if(!s2.contains(String.valueOf(a))&&!set.contains(a1)){
                    set.add(a1);
                    System.out.print(a1);
                }
            }
            System.out.println();
        }
    }
    //==================================
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            String[] s1 = s.split(" ");
            double[] arr1= new double[3];
            double[] arr2 = new double[3];
           double r= 0;
            for(int i = 0; i<3;i++){
                arr1[i] = Integer.parseInt(s1[i]);
                arr2[i] = Integer.parseInt(s1[i+3]);
                r +=Math.abs(Math.pow(arr1[i],2)-Math.pow(arr2[i],2));
            }
            r = Math.pow(r,0.5);
            String a =  new java.text.DecimalFormat("#.000").format(r); //
            Double r2  = Double.parseDouble(a);
            Double tiji = Math.pow(r,3)*3.1415926*4/3;
            String b =  new java.text.DecimalFormat("#.000").format(tiji); //
            System.out.println(a+" "+b);


        }
    }
}
