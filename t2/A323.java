
import java.util.Arrays;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class A323 {
    //牛客 子串判断
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] res = new boolean[p.length];
        for(int i = 0;i<n;i++){
            res[i] = s.contains(p[i]);
        }
        return res;
    }
//===============================================================
    //牛客 成绩排序
   static class people {
        String name;
        int num;


        public people(String name, int num) {
            this.name = name;
            this.num = num;
        }

    @Override
    public String toString() {
        return this.name+" "+this.num;
    }
}

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Map<LinkedList<people>,Integer> map = new HashMap<>();
        int n = scan.nextInt();
        MyComparator.x = scan.nextInt();
        Set<Integer> set = new HashSet<>();
        while(scan.hasNext()){


            people p =new people(scan.next(),scan.nextInt());
            set.add(p.num);
            if(map.containsValue(p.num)){ //若有
                for(LinkedList<people> a : map.keySet()){ //链地址法解决冲突
                     if(a.getFirst().num==p.num){
                         a.add(p);   //尾插法确保顺序
                     }
                }
            }else{
                LinkedList<people> a = new LinkedList<>();
                a.add(p);
                map.put(a,p.num);
            }

        }
        Iterator<Integer> it = set.iterator();
        Integer[] array = new Integer[set.size()];
        int i =0;
        while(it.hasNext()){
            array[i++] = it.next();
        }
        Comparator cmp = new MyComparator();

        Arrays.sort(array,cmp);
        int[] array1 =new int[array.length];
        for(int j = 0;j<array.length;j++){
            array1[j] = array[j].intValue();
        }

        deplay(array1,map);


    }

  static class MyComparator implements Comparator<Integer>{
        public static int x;
       @Override
       public int compare(Integer o1, Integer o2) {
           if(x==0){
               return o2-o1;
           }else {
               return 0;
           }
       }
   }


    public static void deplay(int[] array,Map<LinkedList<people>,Integer> map){
        for(int i = 0;i<array.length;i++){
            for(LinkedList<people> a : map.keySet()){
                if(a.getFirst().num==array[i]){
                    if(i==array.length-1){
                        people[] res = a.toArray(new people[a.size()]);
                        for(int j = 0;j<res.length;j++){
                            if(j==res.length-1){
                                System.out.print(res[j]);
                            }else{
                                System.out.println(res[j]);
                            }
                        }
                    }else {
                        people[] res = a.toArray(new people[a.size()]);
                        for (people p : res) {
                            System.out.println(p);
                        }
                    }
                }
            }
        }

    }

}
