public class KnapsackTab {
    public static void printArray(int arr[][]){
        for (int row[] : arr){
            for (int elem : row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static int KanpsackTabu(int val[],int wt[],int n,int W){
        int dp[][] = new int[n+1][W+1];
        
        //when weight is 0 and item is increasing
        for(int i = 0; i< dp.length; i++){
            dp[i][0] = 0;
        }

        // when item 0 but weight increasing
        for(int j = 0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }


        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                if(wt[i-1] <= j){ //valid
                    // include 
                    int ans1 = val[i-1] + dp[i-1][j-wt[i-1]];
                    // exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                    
                }else{ // invaild
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printArray(dp);
        return dp[n][W];

    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        int n = val.length;

        System.out.println(KanpsackTabu(val, wt, n, W));
    }
}
