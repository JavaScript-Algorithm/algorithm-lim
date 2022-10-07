import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> a = new PriorityQueue<Integer>(); 
        PriorityQueue<Integer> b = new PriorityQueue<Integer>(); 
        
        for(int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        
        while(!b.isEmpty()){
            if(a.peek() < b.peek()){
                a.poll();
                b.poll();
                answer++;
            }else{
                b.poll();
            }
        }
        
        
        return answer;
    }
}