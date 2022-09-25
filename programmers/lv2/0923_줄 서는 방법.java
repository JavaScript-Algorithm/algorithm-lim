import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        long unit = 1;
        for(int i = 1; i <= n; i++){
            list.add(i);
            unit *= i;
        }
        
        k--;
        int index = 0;
        while(index < n) {
            unit /= n - index;
            answer[index++] = list.remove((int) (k / unit));
            k %= unit;
        }
        
        
        return answer;
    }
}