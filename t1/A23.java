import java.util.*;
public class A23 {
    public static int method(int a){
        if(a==0||a==1){
            return a;
        }
        else{
            return method(a-1)+method(a-2);
        }

    }


    public static void main1(String args[]){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int i =0;
        while(true){
            int n1 = method(i);
            int n2 = method(i+1);
            if(n1<num&&n2>num){
                n1 = Math.abs(n2-num)>Math.abs(n1-num) ?Math.abs(n1-num):Math.abs(n2-num);
                System.out.println(n1);
                break;
            }if(n1==num||n2==num){
                System.out.println(0);
                break;
            }
            i++;
        }
    }



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] s = str.split(" ");
            for(int i = 0;i<s.length;i++){
                set.add(s[i]);
            }
        }
        Iterator<String> it = set.iterator();
        int i =0;
        while(it.hasNext()){
            it.next();
            i++;
        }

        System.out.print(i);
    }
}
