import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        int index = 0;
        int now = 0;
        
        while(index < truck_weights.length || !queue.isEmpty()) {
            answer++;
            
            if(!queue.isEmpty()){
                if(answer - count.peek() == bridge_length){
                    int truck = queue.poll();
                    now -= truck;
                    count.poll();
                }
            }
            
            if(index < truck_weights.length){
                if(queue.size() < bridge_length && now + truck_weights[index] <= weight) {
                    queue.add(truck_weights[index]);
                    count.add(answer);
                    now += truck_weights[index];
                    index++;
                }
            }
        }
        
        return answer;
    }
}