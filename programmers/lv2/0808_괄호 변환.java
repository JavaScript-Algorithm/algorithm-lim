import java.util.*;

class Solution {
    public String solution(String p) {
        if(check(p)){
            return p;
        }
        return dfs(p);
    }
    
    public boolean check(String s) {
         Stack<Character> stack = new Stack<>();
	        for(int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            if(c =='(')
	                stack.add(c);
	            else{
	                if(stack.isEmpty())
	                    return false;
	                else
	                    stack.pop();
	            }
	        }
	        if(!stack.isEmpty())
	            return false;
	        return true;
    }
    
    public String dfs(String s) {
        if(s.length() == 0) {
            return "";
        }

        int cnt=0, idx=0, len = s.length();
        
        while(idx < len){
            char c = s.charAt(idx++);
            if(c=='(') cnt++;
            else cnt--;
            if(cnt==0) break;
        }
        
        String u = s.substring(0, idx);
        String v = s.substring(idx, len);
        
        if(!check(u)){
            String temp = "(" + dfs(v);
            temp += ")";
            u = u.substring(1, u.length()-1);
	        u = u.replace("(", ".");
	        u = u.replace(")", "(");
	        u = u.replace(".", ")");
	        temp += u;
	        
            return temp;
        }else{
            return u + dfs(v);
        }
        
    }
}