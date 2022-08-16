import java.util.*;

class Solution {
    List<String> candis = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        for(int i = 0; i < relation[0].length; i++){
            boolean[] visit = new boolean[relation[0].length];
            dfs(visit, 0, i + 1, 0, relation);
        }
        
        answer = candis.size();
            
        return answer;
    }
    
    public void dfs(boolean[] visit, int start, int end, int depth, String[][] relation) {
        if(end == depth){
            List<Integer> list = new ArrayList<>();
            String keys = "";
            
            for(int i = 0; i < visit.length; i++){
                if(visit[i]) { 
                    keys += i;
                    list.add(i);
                }
            }
            
            Map<String, Integer> map = new HashMap<>();
            
            //중복 확인
            for(int i = 0; i < relation.length; i++){
                String str = "";
                
                for(int j : list){
                    str += relation[i][j];
                }
                
                if(map.containsKey(str)){
                    return;
                }
                
                map.put(str, 0);
            }
            
            for(String candi : candis){
                int count = 0;
                for(int i = 0; i < keys.length(); i++){
                    String key = String.valueOf(keys.charAt(i));
                    if(candi.contains(key)) count++;
                }
                
                if(candi.length() == count) return;
                
            }
            candis.add(keys);
            
            return;
        }
        
        
        for(int i = start; i < visit.length; i++){
            if(visit[i]) continue;
            
            visit[i] = true;
            dfs(visit, i, end, depth + 1, relation);
            visit[i] = false;
        }
    }
}