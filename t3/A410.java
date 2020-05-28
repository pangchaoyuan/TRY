import java.util.List;
import java.util.Stack;

public class A410 {//牛客 股市
    static Stack<Integer> stack = new Stack<>();
    static int   max = 0;

    public static void main(String[] args) {
        int[] a = {3,8,5,1,7,8};
        calculateMax(a);
    }


    public static int calculateMax(int[] prices) {
        method(prices,0,0,0,0,stack);
        System.out.println(max);
        return max;

    }

    public static void method(int[] prices,int i,int buy,int sell,int money,Stack stack){
        if(i>prices.length-1||sell==2){
            max = max>money?max:money;
            max = max>0?max:0; //纯跌
            return;
        }
        if(buy<2&&stack.isEmpty()){ //没买够两次 今天买
            stack.push(prices[i]);//当前股价
            method(prices,i+1,buy+1,sell,money-prices[i],stack);
            stack.pop();

            method(prices, i + 1, buy, sell, money, stack); //今天不买
        }


        if(sell<2&&!stack.isEmpty()){//没卖够两次，今天卖
            int a = (int)stack.pop();
            method(prices, i + 1, buy, sell + 1, money + prices[i], stack);
            stack.push(a);

            method(prices, i + 1, buy, sell, money, stack); //今天不卖
        }

    }
}
