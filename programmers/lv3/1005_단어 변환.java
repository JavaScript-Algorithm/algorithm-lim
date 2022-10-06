import java.util.*;

class Solution {
    public static boolean[] check;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        check = new boolean[words.length];
        answer = bfs(begin, target, words);
        return answer;
    }
    
    
    public int bfs(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            String str = node.str;
            
            if(node.str.equals(target)) {
                return node.cost;
            }
            
            for(int i = 0; i < words.length; i++) {
                int euq = 0;
                
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == words[i].charAt(j)) {
                        euq++;
                    }
                }
                
                if(euq == str.length() - 1 && !check[i]) {
                    queue.add(new Node(words[i], node.cost + 1));
                    check[i] = true;
                }
            }
        }
        
        return 0;
    }
}

class Node {
    String str;
    int cost;
    
    public Node(String str, int cost) {
        this.str = str;
        this.cost = cost;
    }
}