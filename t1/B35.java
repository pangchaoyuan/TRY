import java.util.*;

public class B35 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        Set<Character> set = new HashSet<>();
        String str = "";
        for(char a: str2.toCharArray()){
            set.add(a);
        }
        for(int i =0;i<str1.length();i++){
            if(set.contains(str1.charAt(i))){
                continue;
            }else{
                  str+=str1.charAt(i);
            }

        }
        System.out.println(str);

    }
}
