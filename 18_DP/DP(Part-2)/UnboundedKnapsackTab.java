public class UnboundedKnapsackTab {
    public static int UnboundedKnapsackTabu(int val[], int wt[], int n, int W){
        int dp[][] = new int[n+1][W+1];

        //initialization
        for (int i = 0; i<n+1 ; i++  ){
            for(int j = 0 ; j<W+1; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = -1;
                }
            }
        }

        // tabulation 
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<W+1; j++){
                if(wt[i-1] <= j){
                    // include
                    int ans1 = dp[i][j-wt[i-1]] + val[i-1];
                    // exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];



    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int n = val.length;

        System.out.println(UnboundedKnapsackTabu(val, wt, n, W));
    }
}
