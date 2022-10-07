import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        
        list.sort(new Comparator<String>(){
           @Override
            public int compare(String o1, String o2){
                return map.get(o2).compareTo(map.get(o1));
            }
            
        });
        
        for(String key : list){
            List<Integer> playList = new ArrayList<>();
            for(int i = 0; i < plays.length; i++) {
                if(genres[i].equals(key)){
                    playList.add(i);
                }
            }
            
            if(playList.size() < 2){
                answerList.add(playList.get(0));
            }else{
                Integer[] playArray = playList.toArray(new Integer[0]);
            
                Arrays.sort(playArray, new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return plays[o2] - plays[o1];
                    }
                });
                
                answerList.add(playArray[0]);
                answerList.add(playArray[1]);
                
            }
        }
        
            
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}