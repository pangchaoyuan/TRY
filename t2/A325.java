import java.util.*;

public class A325 {
    //牛客 到底买不买
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String a = scan.nextLine();
            String b = scan.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            for(char a1 : b.toCharArray()){
                map.put(a1,map.getOrDefault(a1,0)+1);
            }
            for(char a1 : a.toCharArray()){
                map.put(a1,map.getOrDefault(a1,0)-1);//有的减，没有的加进来减成负数
            }
            int sum = 0;//记录少几个字符
            for(int a1 :map.values()){
                if(a1>0){
                    sum += a1;
                }
            }
            if(sum>0){
                System.out.println("NO " + sum);
            }else{
                System.out.println("Yes " + (a.length() - b.length()));
            }
        }
    }
}
