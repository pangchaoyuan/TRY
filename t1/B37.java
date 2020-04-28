import java.util.*;

public class B37{
    //牛客，输出一个数组中出现频率超过一半的数字
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String str = "";
        while(scan.hasNext()){
            str+=scan.nextLine();
        }
        String[] str2 = str.split(" ");
        Map<String,Integer> map= new HashMap<>();
        for(int i =0;i<str2.length;i++){
            if(map.get(str2[i]) == null) {
                map.put(str2[i],1);
            }else {
                map.put(str2[i],map.get(str2[i])+1);
            }
        }
        for(int i = 0;i<str2.length;i++){
            if(map.get(str2[i])>=str2.length/2){
                System.out.println(str2[i]);
                break;
            }
        }
    }
}
