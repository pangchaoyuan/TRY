import java.util.ArrayList;
import java.util.List;

public class Queen2 {
    static class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<String>> s = QueenN(n);
        System.out.println("在 "+n+" 个皇后的情况下"+"总共有 "+s.size()+" 种解法");
        for(List<String> s1 : s){
            System.out.println("=============================");
            for(String a : s1){
                System.out.println(a);
            }

        }
    }

    //获取N皇后方案
    public static List<List<String>> QueenN(int n) {
        List<point> list = new ArrayList<>();
        List<List<point>> lists = new ArrayList<>();
        method(0, n, list, lists);

        return change(n, lists);
    }

    //搜索和回溯
    public static void method(int row, int n, List<point> list, List<List<point>> lists) {
        //复制加入方案集合
        if (row == n) {
            List<point> l = new ArrayList<>();
            for (point p : list) {
                l.add(p);
            }
            lists.add(l);
            return;
        }
        for (int i = 0; i < n; i++) {
            //如果不冲突
            if (isVaild(row, i, list)) {

                list.add(new point(row, i));
                method(row + 1, n, list, lists);
                list.remove(list.size() - 1);

            }
        }
    }

    //判断是否与已确定皇后冲突 没有返回true
    public static boolean isVaild(int row, int col, List<point> list) {
        for (point p : list) {
            if ((p.y == col&&Math.abs(p.y-col)<=7) ||
                    (p.x + p.y == col + row&&Math.abs(p.x-row)<=7) ||
                    (p.x - p.y == row - col&&Math.abs(p.x-row)<=7)) {
                return false;
            }

        }
        return true;
    }


    public static List<List<String>> change(int n, List<List<point>> lists) {
        List<List<String>> res = new ArrayList<>();
        //获得方案

        for (List<point> list : lists) {
            StringBuilder[] strings = new StringBuilder[n];
            //新建顺序表保存String
            List<String> list1 = new ArrayList<>();

            //全部都初始化为点
            for(int i = 0 ; i <strings.length;i++){
                String s1 = "";
                for(int j = 0 ; j <n;j++){
                    s1 = s1+".";
                }

                strings[i] = new StringBuilder().append(s1);
            }

            for (point p : list) {
                //在此处替换对应坐标的点为Q
                for (int i = 0; i < n; i++) {
                       if(p.x==i){
                           strings[i].replace(p.y,p.y+1,"Q");
                       }
                }
            }

            for(StringBuilder s : strings){
                list1.add(s.toString());
            }
            //结束后将list1加入方案集合
            res.add(list1);
        }
        //遍历完所有方案后返回
        return res;
    }
}
