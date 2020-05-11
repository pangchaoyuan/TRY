import java.util.*;

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class A324 {

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1,1,1,11,23};
        System.out.println(getValue(a,a.length));
    }
//牛客 微信红包
    public static int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(gifts[i],map.getOrDefault(gifts[i],0)+1);
        }
        for(int a :map.keySet()){
            if(map.get(a)>n/2){
                return a;
            }
        }
        return 0;
    }
       //牛客 链表分割
    public ListNode partition(ListNode pHead, int x) {
        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode cur = pHead;
        ListNode bcur = big;
        ListNode scur = small;

        while(cur!=null){
            if(cur.val<x){
                scur.next = new ListNode(cur.val);
                scur = scur.next;
            }else{
                bcur.next = new ListNode(cur.val);
                bcur = bcur.next;
            }
            cur = cur.next;
        }
        scur.next = big.next;
        return small.next;

    }
}
