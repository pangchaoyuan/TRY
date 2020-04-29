import java.util.*;
public class A314 {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "a" + new String("aa");
        System.out.println(a == b);
        byte c = 127;
        c++;
        System.out.println(c);
    }
}



 //递归生成 n位格雷码 0 1      00   01   11  10          000  001  011 010  110 111 101 100 //加一的要反向，加0的不用
class GrayCode {
    public String[] getGray(int n) {
        if(n==1){
            return new String[]{"0","1"};
        }
        String[] get = getGray(n-1);
        String[] res = new String[get.length*2];
        for(int i = 0;i<res.length;i++){
            if(i<get.length){
                res[i] = "0"+get[i];
            }else{
                res[i] = "1"+get[res.length-i-1];
            }
        }
        return res;
    }
}