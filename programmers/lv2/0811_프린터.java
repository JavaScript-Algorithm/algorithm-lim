import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int index = location;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.add(priorities[i]);
        }
        
        while(true){
            int num = queue.poll();
            boolean check = true;
            for(int i = 0; i < priorities.length; i++){
                if(num < priorities[i]){
                    queue.add(num);
                    if(index == 0){
                        index = queue.size() - 1;
                    }else{
                        index--;
                    }
                    check = false;
                    break;
                }
            }
            
            if(check) {
                answer++;
                for(int i = 0; i < priorities.length; i++){
                    if(priorities[i] == num){
                       priorities[i] = 0;
                        break;
                    }
                }
                
                if(index == 0){
                    break;
                }else{
                    index--;
                }
            }
        }
        
        return answer;
    }
}