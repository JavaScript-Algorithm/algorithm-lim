import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for(int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i], " ");
            
            if(st.nextToken().equals("I")){
                int num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }else{
                if(map.size() == 0) {
                    continue;
                }
                
                int key = 0;
                
                if(st.nextToken().equals("1")){
                    key = map.lastKey();
                }else{
                    key = map.firstKey();
                }
                
                if(map.get(key) > 1) {
                    map.put(key, map.get(key) - 1);
                }else{
                    map.remove(key);
                }
                
            }
        }
        
        if(map.size() != 0){
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        
        return answer;
    }
}

// public int[] solution(String[] operations) {
//         int[] answer = new int[2];
//         Queue<Integer> min = new PriorityQueue<Integer>();
//         Queue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
//         StringTokenizer st;
//         map = new HashMap<Integer, Integer>();
        
//         for(int i = 0; i < operations.length; i++) {
//             st = new StringTokenizer(operations[i], " ");
            
//             if(st.nextToken().equals("I")){
//                 int num = Integer.parseInt(st.nextToken());
//                 min.add(num);
//                 max.add(num);
//                 map.put(num, map.getOrDefault(num, 0) + 1);
//             }else{
//                 if(map.size() == 0) {
//                     continue;
//                 }
                
//                 if(st.nextToken().equals("1")){
//                     delete(max);
//                 }else{
//                     delete(min);
//                 }
//             }
//         }
        
//         if(map.size() != 0){
//             answer[0] = delete(max);
//             answer[1] = delete(min);
//         }
        
//         return answer;
//     }
    
//     public int delete(Queue<Integer> queue) {
//         int key = 0;
//         while(true){
//             key = queue.poll();
//             int num = map.getOrDefault(key, 0);
            
//             if(num == 0) {
//                 continue;
//             }
            
//             if(num > 1) {
//                 map.put(key, num - 1);
//             }else{
//                 map.remove(key);
//             }
//             break;
//         }
        
//         return key;
//     }
// }