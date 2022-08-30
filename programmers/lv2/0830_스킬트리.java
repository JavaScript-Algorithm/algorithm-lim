class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String element: skill_trees){
            String temp = element;
            for(int i = 0; i < element.length(); i++) {
                String str = String.valueOf(element.charAt(i));
                if(!skill.contains(str)) {
                    temp = temp.replace(str, "");
                }
            }
                   
            if(skill.indexOf(temp) == 0){
                answer++;
            }                   
        }
        
        return answer;
    }
}