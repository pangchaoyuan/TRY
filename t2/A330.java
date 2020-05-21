import java.util.*;
public class A330{
     static String[] hanzi = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾" };
    //==========================================
    //十位是零 就零几，不是零，就几拾几
    public static void main(String[] args){
          int i=0;

         Scanner scan = new Scanner(System.in);
         while(scan.hasNext()){
            String n = scan.nextLine();
            if(n.equals("0.00")){
                System.out.println("人民币零元整");
                continue;
            }

            String[] x = n.split("\\.");//分为小数点前后


             String left =  big(x[0]);
              while(String.valueOf(left.charAt(i)).equals("零")){
                  i++;
              }
              int j=0;
             while(String.valueOf(left.charAt(left.length()-1-j)).equals("零")){
                 j++;
             }


              left = left.substring(i,left.length()-j); //小数点左搞定
               i = 0;


             String right = small(x[1]);
            if(right.equals("零")){
                right = "";
                left = left +"元整";
            }else{
                left = left +"元";
            }

             System.out.println("人民币"+left+right);

    }
    }



    public static String big(String str){ //一个str 大于0部分 123_4567

        String res=  "";
        String a = "";
        int n = str.length()%4;
        if(n!=0) {
            for (int i = 0; i < 4 - n; i++) {
                a = a + 0;
            }
        }
        a = a+str; //不够4前补0
        int x= 0;//记录循环了几次
        for(int i = a.length()-1;i>=0;i-=4) { //四位一组
            if(x==1){
                res = "万" + res;
            }
            if(x==2){
                res = "亿" +res;
            }
            if(x==3){
                res = "万" +res;
            }

           String a2 =  siwei(i,a);//从i往后推4位变成 几千几百几十几的形式
            if(a2.equals("零")){
                a2 = "";
            }
            if(x==0){
                res = res +a2;
            }else{
                res = a2 +res;
            }

            x++;//记录一次

        }
        return res;
    }

    public static String siwei(int i ,String a){
        String res="";
        boolean ling = true; //每四位最多出现一次零
        for(int j = 3;j>=0;j--){ //最高位开始

            int num = Integer.parseInt(String.valueOf(a.charAt(i - j)));//表示位置上的数字


            if(num!=0) { //非零填数字
                if(j!=1) {   //不在十位时，无限制
                    res = res + hanzi[num];
                }else if(j==1){  //在十位时
                    if(ling){ //千位百位不为0，无所谓
                       res = res +hanzi[num];
                    }else{    //千位百位为0
                        if(num!=1){ //num不为1再加
                            res = res +hanzi[num];
                        }
                    }
                }
            }

            if(num==0&&ling){ //为0并且没加过0
                res = res + hanzi[0]; //有一个零就够了
                ling = false;
            }

            if(num!=0){ //在非零情况下
                if(j==3){
                    res = res + "仟";
                }else if(j==2){
                    res = res +"佰";
                }else if(j==1){
                    res = res +"拾";
                }
            }
        }
        return res;

    }

    public static String small(String str){//小于零最多两位
        String res = "";
        for(int i = 0;i<2;i++){
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));//取得数字

            if(i==0&&num!=0){
                res = res + hanzi[num];
                res = res +"角";
            }
            if(i==1&&num!=0){   //不为零加，为零不就不加
                res = res + hanzi[num];
                res = res +"分";
            }

        }
        return res;
    }
}