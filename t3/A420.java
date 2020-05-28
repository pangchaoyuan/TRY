import java.util.*;

public class A420 {
    public static int sb = 0;

    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            sb++;
            int n = scan.nextInt();
            String[] arr = new String[n];
            for(int i = 0 ;i<n;i++){
                arr[i] = scan.next();
            }
            List<String> list = new ArrayList<>();
            for(int i = 0;i<arr.length;i++){
                arr[i] = arr[i].replaceAll("-","");
                String res = method2(arr[i]);
                if(!list.contains(res)){
                    list.add(res);
                }
            }
            String[] as = new String[list.size()];
            int i = 0;
            for(String str : list){
                as[i++] = str;
            }
            Arrays.sort(as);
            for(int j = 0;j<as.length ;j++){
                    System.out.println(as[j]);
            }
            if(sb%2==1){
                System.out.println();

            }



        }
    }

    public static String method2(String a ){
        String res = "";
        char[] a2 = a.toCharArray();

        for(int i = 0 ;i<a2.length;i++){
            if(a2[i]>='A'&&a2[i]<='C'){
                res = res+'2';
            }else if(a2[i]>='D'&&a2[i]<='F'){
                res = res+'3';
            }else if(a2[i]>='G'&&a2[i]<='I'){
                res = res+'4';
            }else if(a2[i]>='J'&&a2[i]<='L'){
                res = res+'5';
            }else if(a2[i]>='M'&&a2[i]<='O'){
                res = res+'6';
            }else if(a2[i]>='P'&&a2[i]<='S'){
                res = res+'7';
            }else if(a2[i]>='T'&&a2[i]<='V'){
                res = res+'8';
            }else if(a2[i]>='W'&&a2[i]<='Z'){
                res = res+'9';
            }else if(a2[i]>='0'&&a2[i]<='9'){
                res = res+a2[i];
            }

            if(i==2){
                res = res+'-';
            }
        }
        return res;
    }




    //=====================================\
    public static List<String> list = new ArrayList<>();
    public static int num = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
             num  = scan.nextInt();

            int m = scan.nextInt();
            method(1,m,0,"");
            if(num==m&&!list.contains(num)){
                list.add(String.valueOf(num));
            }
            String[] str = new String[list.size()];
            int i = 0;
            for (String a :list){
                str[i++] =  a;
            }
            Arrays.sort(str);
            for(String a : str){
                System.out.println(a);
            }

        }
    }

    public static void method(int n,int m,int sum,String str){
        if(n>num) return;

        if(sum == m){
            list.add(str);
            return;
        }
        String str1;
        if(str!=""){
             str1 = str +" "+n;
        }else{
             str1 = str+n;
        }

        int sum1= sum+n;
        int n1 = n+1;
        method(n1,m,sum1,str1);

        method(n1,m,sum,str);


    }
}
