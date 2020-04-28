import java.util.*;

public class A39{

    //牛客网 求最小公倍数
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int i =1;
        boolean a = true;
        while(a){
            if((A*i)%B==0){
                a = false;
            }else{
                i++;
            }
        }
        System.out.println(A*i);
    }



    //牛客网 不要二
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        int W = scan.nextInt();
        int H = scan.nextInt();
        int n =0;
        //对于列、行都是**__**__四格一组
        for(int i =0;i<W;i++){   //列
            int j =0;
            if(((i/2)%2)!=1) {
                while (j < H) {
                    n = ((j / 2) % 2) != 1 ? n + 1 : n;
                    j++;
                }
            }
                if(((i/2)%2)==1) {
                    while (j < H) {
                        n = ((j / 2) % 2) == 1 ? n + 1 : n;
                        j++;
                    }
                }

        }
        System.out.println(n);

    }
}