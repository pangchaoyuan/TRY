import java.util.*;

public class A414 {



    public String replaceSpace(String iniString, int length) {
        String str = "";
        for(int i = 0 ; i < length; i++){
            if(iniString.charAt(i)==' '){
                str = str+"%20";
            }else{
                str = str +iniString.charAt(i);
            }
        }
        return str;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String left;
            String right;
            boolean ok = true;
            String str = scan.nextLine();
            if (str.length()%2==1){
                 left = str.substring(0,str.length()/2);
                 right = str.substring(str.length()/2+1,str.length());
            }else{
                left = str.substring(0,str.length()/2);
                 right = str.substring(str.length()/2,str.length());
            }
            int i = 0;
            int num = 0;//不相同次数
            Set<Character> set = new HashSet<>();
            for(char a : str.toCharArray()){
                set.add(a);
            }

            while(i<left.length()/2){ //普通
                if(left.charAt(i)!=right.charAt(right.length()-i-1)){
                    num++;
                    if(num>1){
                        ok = false;
                        break;
                    }
                }else{
                    i++;

                }
            }

            if (str.length()%2==0&&set.size()==2){
                for(int j = 0;j<left.length();j++){
                    if(j+1<left.length()&&j-1>=0){
                        if((left.charAt(j)==right.charAt(j)||left.charAt(j)==right.charAt(j-1)||left.charAt(j)==right.charAt(j+1))){
                            ok = true;
                        }

                    }else{
                        ok = false;
                    }
                }
            }


            if(ok){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
