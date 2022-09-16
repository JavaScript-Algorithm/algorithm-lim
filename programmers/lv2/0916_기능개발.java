import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int index = 0; 
        Queue<Integer> days = new LinkedList<>();
        
        while(true){
            if(index == progresses.length){
                break;
            }
            int count = 0;
            
            for(int i = index; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            for(int i = index; i < progresses.length; i++) {
                if(progresses[i] < 100){
                    break;
                }
                
                count++;
            }
            
            
            if(count > 0) {
                index += count;
                days.add(count);
            }
        }
        
        answer = new int[days.size()];
        int size = days.size();
        
        for(int i = 0; i < size; i++){
            answer[i] = days.poll();
        }
        
        return answer;
    }
}