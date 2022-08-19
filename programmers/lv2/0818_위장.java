import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
                continue;
            }
            map.put(clothes[i][1], 1);
        }
        
        Iterator<Integer> it = map.values().iterator();
        
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }
        
        
        return answer - 1;
    }
}