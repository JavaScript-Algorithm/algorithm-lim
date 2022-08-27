class Solution {
    public int solution(int n) {
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        //f(n-2)*4 - f(n-4)
        for(int i = 4; i <= n; i += 2){
            dp[i] = dp[i - 2] * 3 + 2;
            for(int j = i - 4; j >= 2; j -= 2){
                dp[i] += dp[j] * 2;
            }
            dp[i] %= mod;
        }
        
        return (int)dp[n];
    }
}