import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int index = 0;
        int end = 0;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);
        
        Arrays.sort(jobs, (int[] a, int[] b) -> (a[0] - b[0]));
        
        while(jobs.length > count){
            
            while (index < jobs.length && jobs[index][0] <= end) {
				queue.add(jobs[index++]);
			}
            
            if(queue.isEmpty()){
                end = jobs[index][0];
            }else {
                int[] temp = queue.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
            
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
}