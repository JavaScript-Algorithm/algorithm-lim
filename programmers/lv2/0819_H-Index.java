import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++){
            int h = citations.length - i; //현재 인용된 논몬 포함 인용 수가 많은 논몬
 
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}