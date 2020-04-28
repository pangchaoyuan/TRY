import java.util.*;

public class B34 {   //判断括号字符串合法性
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for(char a: A.toCharArray()){
            if(a=='('){
                stack.push(a);
            }else if(a==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
