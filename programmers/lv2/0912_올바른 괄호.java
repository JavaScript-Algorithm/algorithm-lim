import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == ')'){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }
        
        return answer;
    }
}