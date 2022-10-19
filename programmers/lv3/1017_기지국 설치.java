class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;
        
        for(int i = 1; i <= n; i++) {
            if(index < stations.length){
                if(stations[index] - w <= i && stations[index] + w >= i) {
                    i = stations[index] + w;
                    index++;
                    continue;
                }
            }
            answer++;
            i += (w * 2);
        }

        return answer;
    }
}