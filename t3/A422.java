import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A422 {
    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str1 = scan.next();
            String str2 = scan.next();
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            boolean right = true;
            for(char a : str1.toCharArray()){
                arr1[a-'A']++;
            }
            for(char a :str2.toCharArray()){
                arr2[a-'A']++;
            }

            for(int i = 0; i<26;i++){
                if (arr1[i] < arr2[i]) {
                    right = false;
                    break;
                }
            }

            if(right){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }

    //================================

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int x = scan.nextInt();
            String[] arr = new String[x];//当前字典
            for(int i = 0; i<x;i++){
                arr[i] = scan.next();
            }
            String str = scan.next();
            int n = scan.nextInt();

            List<String> list = new ArrayList<>();//放兄弟



            int i = 0;
            for(String a : arr){

                if(method(a,str)){
                    list.add(a);
                }
            }
            String[] res = new String[list.size()];
            for(String a : list){
                res[i++] = a;
            }
            Arrays.sort(res);//字典序排序

            System.out.println(i+" "+res[n-1]);

        }
    }

    public static boolean method(String str1,String str2){  //判断是不是兄弟 相同单词返回false
        if(str1.equals(str2)){ return  false;}

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(char a : str1.toCharArray()){
            arr1[a-'a']++;
        }
        for(char a : str2.toCharArray()){
            arr2[a-'a']++;
        }
        for(int i =0;i<26;i++){
            if(!(arr1[i]==arr2[i])){  //字母数量对不上
                return false;
            }
        }
        return true;
    }
}
