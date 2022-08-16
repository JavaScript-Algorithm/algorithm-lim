import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            queue.add(s.charAt(i));
        }
        
        for(int i = 0; i < s.length(); i++){
            Queue<Character> tempQueue = new LinkedList<>(queue);
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            
            stack.push(tempQueue.poll());
            
            if(stack.peek() == '(' || stack.peek() == '{' || stack.peek() == '['){
                while(!tempQueue.isEmpty()){
                    char temp = tempQueue.poll();
                    if(!stack.empty()) {
                        if(stack.peek() == '(' && temp == ')'){
                            stack.pop();
                            continue;
                        }else if(stack.peek() == '[' && temp == ']'){
                            stack.pop();
                            continue;
                        }else if(stack.peek() == '{' && temp == '}'){
                            stack.pop();
                            continue;
                        }
                    }
                    
                    stack.push(temp);
                }
                if(stack.empty()){
                    answer++;
                }
            }
        
            queue.add(queue.poll());
        }
        
        
        return answer;
    }
}