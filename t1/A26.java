import java.util.*;

public class A26 {

    public class ListNode {
    int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }



    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int j =0,i=0;j<s.length();j++){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            max = max>set.size()?max:set.size();
        }
        return set.size();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode cur = res;
        int val = 0;
        int rush = 0;
        while(l1!=null||l2!=null){
            int n1 = l1==null?0:l1.val;
            int n2 = l2==null?0:l2.val;

            int n =n1+n2+rush;
            rush = n/10;

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            cur.next = new ListNode(n%10);
            cur = cur.next;
        }
        if(rush!=0) cur.next = new ListNode(1);
        return res.next;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];//用行矩阵的第n行第num列表示是否有num
        boolean[][] col = new boolean[9][9];
        boolean[][] nine = new boolean[9][9];

        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j]-'1';
                    int index = i/3*3+j/3; //用该矩阵的行来表示第index个3*3；
                    if(row[i][num]||col[num][j]||nine[index][num]){
                        return false;
                    }else{
                        row[i][num]=true;
                        col[num][j]=true;
                        nine[index][num]=true;
                    }
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {
        String a = "abaaa";
        System.out.println(lengthOfLongestSubstring(a));
        System.out.println(10%10);
        Set<Integer> set = new HashSet<>();
        set.clear();
    }
}
