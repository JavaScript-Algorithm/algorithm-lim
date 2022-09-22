import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            queue.add((long)scoville[i]);
        }
        
        while(queue.peek() < K){
            
            if(queue.size() == 1){
                answer = -1;
                break;
            }
            
            answer++;
            long first = queue.poll();
            long second = queue.poll() * 2;
            queue.add(first + second);
        }
        
        return answer;
    }
}