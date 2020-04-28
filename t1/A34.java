import java.util.*;

public class A34 {
    //找出字符串中最长数字
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str2 = scan.nextLine();
        String str = "";
        for(char a : str2.toCharArray()){
            if(a>='0'&&a<='9'){
                str+=a;
            }else{
                str+='a';
            }
        }
        Map<Integer,String> map = new HashMap<>();
       String[] str3 = str.split("a");
        int max = 0;
        for(int i =0;i<str3.length;i++){
            max = max>str3[i].length()?max:str3[i].length();
            map.put(str3[i].length(),str3[i]);
        }

        System.out.println(map.get(max));
    }


    }
