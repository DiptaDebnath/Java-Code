public class KnapsackMemo {
        // print 2d array
        public static void PrintArray(int arr[][]){
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[i].length; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    
        //print 2d array
        public static void printArray(int arr[][]){
            for (int row[] : arr){
                for (int elem : row){
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
        }
            //memoization
    public static int KnapsackMemoi(int val[],int wt[], int n,int W, int dp[][]){
        if(n==0 || W==0){
            return 0;  // means if their is no item (n == 0) or no wt left to carry(W == 0) the profit will be 0
        }
        
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W ){
            // include item
            int ans1 = val[n-1] + KnapsackMemoi(val, wt, n-1, W-wt[n-1],dp);
            // exclude item
            int ans2 = KnapsackMemoi(val, wt, n-1, W,dp);
            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        }else{
            dp[n][W] = KnapsackMemoi(val, wt, n-1, W, dp);
           return dp[n][W];
        }
    }



    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        int n = val.length;

        // memoization
        // initialization
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0) 
                    dp[i][j] = 0;  // Base case initialization
                else 
                    dp[i][j] = -1; // Uncomputed states
            }
        }
        System.out.println(KnapsackMemoi(val, wt, n, W, dp));
        printArray(dp);
    }
}
