import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        List<String> visit = new ArrayList<>();
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < dirs.length(); i++){
            String xy = Integer.toString(x);
            xy += Integer.toString(y);
            
            char a = dirs.charAt(i);
            
            if(a == 'L' && x > -5){
                x--;
            }else if(a == 'R' && x < 5) {
                x++;
            }else if(a == 'U' && y < 5) {
                y++; 
            }else if(a == 'D' && y > -5){
                y--;
            }
            
            String chXy = Integer.toString(x);
            chXy += Integer.toString(y);
            
            String st = xy + chXy;
            String nd = chXy + xy;
            
            if(!visit.contains(st) && !visit.contains(nd) && !st.equals(nd)){
                visit.add(st);
                visit.add(nd);
            }
        }
        
        answer = visit.size() / 2;
        
        return answer;
    }
}