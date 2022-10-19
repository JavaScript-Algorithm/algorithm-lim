import java.util.*;

class Solution {
    public static StringBuilder sb =  new StringBuilder();
    String str = "Z";
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] check = new boolean[tickets.length];
        
        sb.append("ICN ");
        dfs(tickets, check, "ICN", 0);
        
        return answer = str.split(" ");
    }
    
    public void dfs(String[][] tickets, boolean[] check, String next, int n){
        if(n == tickets.length){
            str = (str.compareTo(sb.toString()) > 0) ? sb.toString() : str;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!check[i] && next.equals(tickets[i][0])){
                check[i] = true;
                sb.append(tickets[i][1]).append(" ");
                dfs(tickets, check, tickets[i][1], n + 1);
                sb.delete(sb.length() - 4, sb.length());
                check[i] = false;
            }
        }
    }
}