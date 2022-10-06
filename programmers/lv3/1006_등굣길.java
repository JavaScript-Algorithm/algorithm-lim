class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        int[][] dp = new int[m][n];
        int min = Integer.MAX_VALUE;
        int count = 0;
        
        dp[0][0] = 1;
        
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0] - 1][puddles[i][1] - 1] = -1;
        }
        
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == -1) {
                    continue;
                }
                if(i != 0 && dp[i - 1][j] > 0) { 
                    dp[i][j] += dp[i - 1][j] % mod;
                }
                if(j != 0 && dp[i][j - 1] > 0) {
                    dp[i][j] += dp[i][j - 1] % mod;
                }
                
            }
        }
        
        answer = dp[m - 1][n - 1] % mod;
        
        return answer;
    }
}