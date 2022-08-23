import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        
        int num = 0;
        int turn = 0;
        
        for(int i = 0; i < words.length; i++){
            if(list.contains(words[i]) || check(words, i)){
                num = i % n + 1;
                turn =  i / n + 1;
                break;
            }
            list.add(words[i]);
        }
        
        answer[0] = num;
        answer[1] = turn;
        return answer;
    }
    
    public boolean check(String[] words, int index){
        if(index != 0){
            char last = words[index - 1].charAt(words[index - 1].length() - 1);
            char first = words[index].charAt(0);
            if(last != first){
                return true;
            }
        }
        
        return false;
    }
}