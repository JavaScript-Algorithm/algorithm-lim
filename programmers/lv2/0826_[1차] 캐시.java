import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize < 1) {
            return cities.length * 5;
        }

        List<String> list = new LinkedList<String>();
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if(!list.isEmpty() && list.contains(city)) {
                for(int j = 0; j < list.size(); j++){
                    if(city.equals(list.get(j))) {
                        list.remove(j);
                        break;    
                    }
                }

                list.add(city);
                answer++;
            } else {
                if(list.isEmpty() || list.size() < cacheSize) {
                    list.add(city);
                } else {
                    list.remove(0);
                    list.add(city);
                }
                
                answer += 5;
            }
        }
        
        return answer;
    }
}