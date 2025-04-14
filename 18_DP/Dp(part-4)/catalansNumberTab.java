public class catalansNumberTab {
    // Tabulation
    //My code
    public static int catalanNumber(int n){
        int dp[] =  new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // bottom up
        int ans = 0;
        for(int i = 2 ; i<n+1 ; i++){
            for (int j = 0; j < i; j++) {
                ans += dp[j] * dp[i-1-j];
            } 
            dp[i] = ans;
            ans = 0; 
        }
        return dp[n];
    }
    // apna college
    public static int catalanNumber2(int n){
        int dp[] =  new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // bottom up
        int ans = 0;
        for(int i = 2 ; i<n+1 ; i++){
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-1-j];       // all dp position ar 0 except 0 and 1 position.
            } 
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalanNumber2(n));
    }
}
