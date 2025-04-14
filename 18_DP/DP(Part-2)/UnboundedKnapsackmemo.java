public class UnboundedKnapsackmemo {
        // Memoization
        public static int UnboundedKnapsackMemo(int val[], int wt[], int n, int W, int dp[][] ){
            if(n == 0 || W == 0){
                return 0;
            }
            
            if(dp[n][W] != -1){
                return dp[n][W];
            }
            if(wt[n-1] <= W){ // valid
                // include
                int ans1 = UnboundedKnapsackMemo(val, wt, n, W-wt[n-1], dp) + val[n-1];
                // exclude
                int ans2 = UnboundedKnapsackMemo(val, wt, n-1, W, dp);
                dp[n][W] = Math.max(ans1,ans2);
                return dp[n][W];
            }else{ // invalid
                dp[n][W] = UnboundedKnapsackMemo(val, wt, n-1, W, dp);
                return dp[n][W];
            }
    
        }
        public static void main(String[] args) {
            int val[] = {15,14,10,45,30};
            int wt[] = {2,5,1,3,4};
            int W = 7;
            int n = val.length;
            int dp[][] = new int[n+1][W+1];
            for (int i = 0; i<n+1 ; i++  ){
                for(int j = 0 ; j<W+1; j++){
                    if (i == 0 || j == 0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = -1;
                    }
                }
            }

            System.out.println(UnboundedKnapsackMemo(val, wt, n, W,dp));
        }
}
