import java.util.*;

public class A46{
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            String str = "";
            for(String a : s.split(" ")){
                str =" " + a + str;
            }
            String res = str.substring(1);
            System.out.println(res);
        }
    }

    //====================================================
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();//文件行号，次数
        Map<Integer,String> shunxumap1 = new HashMap<>();//
        Map<String,Integer> shunxumap = new HashMap<>();

        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){

            String s = scan.next();
            int num = scan.nextInt();


            int shunxu = 0;
            String[] str = s.split("\\\\");
            String a = "";
            if(str[str.length-1].length()>16){

                a = str[str.length-1].substring(str[str.length-1].length()-16);
            }else{
                a = str[str.length-1];
            }
            map.put(
                    a+" "+num,
                    map.getOrDefault(a+" "+num,0)+1
            );
            if(!shunxumap.containsKey(a+" "+num)){
                shunxumap.put(a+" "+num,shunxu++); //根据名字查顺序
                shunxumap1.put(shunxu-1,a+" "+num); //根据顺序查名字
            }
            Set<String> set = map.keySet(); //记录所有文件名字
            int[] array = new int[map.size()];
            int i = 0;
            for(int num1 : map.values()){
                array[i++] = num1; //记录所有出现次数
            }
            Arrays.sort(array);

            Iterator it = set.iterator();
            String[] b = new String[set.size()];
            i=0;
            while(it.hasNext()){
                b[i++] = (String) it.next();//名字数组
            }



            int num2 = 0;
            int s2 = 0;
            for(i = array.length-1;i>=0;i-=num2){
                for(int m : array){
                    if(array[i]==m){
                        num2++; //次数相同几个
                    }
                }

                List<String> list = new ArrayList<>();
                for(String ab : b){
                    if(map.get(ab)==array[i]){
                        list.add(ab);//次数相同放进顺序表
                    }
                }

                int[] a1 = new int[num2];
                int j =0;
                for(String ab : list){
                    a1[j++] = shunxumap.get(ab);//记录次序
                }
                Arrays.sort(a1);//将次序号排序
                for(j =0;j<a1.length;j++){
                    if(s2<8) {
                        String res = shunxumap1.get(j);
                        System.out.println(res + " " + map.get(res));
                        s2++;
                    }
                }



            }


        }
    }
}