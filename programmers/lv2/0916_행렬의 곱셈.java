class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++){
                int count = 0;
                for(int s = 0; s < arr1[0].length; s++){
                    count += arr1[i][s] * arr2[s][j];
                }
                answer[i][j] = count;
            }
        }
        
        return answer;
    }
}