public class TargetSumSubsetMemo {
    public static boolean TargetSumSubsetMemoi(int number[],int n, int sum, boolean dp[][]){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(dp[n][sum] != false){
            return dp[n][sum];
        }

        if(number[n-1] <= sum){ // valid
            // include
            boolean ans1 = TargetSumSubsetMemoi(number, n-1, sum-number[n-1], dp);
            // exclude
            boolean ans2 = TargetSumSubsetMemoi(number, n-1, sum, dp);

            dp[n][sum] = ans1 || ans2;
            return dp[n][sum];
        }else{// invalid
            dp[n][sum] = TargetSumSubsetMemoi(number, n-1, sum, dp);
            return dp[n][sum];
        }

    }
    public static void main(String[] args) {
        int number[] = {4,2,7,1,3} ;
        int sum = 10;
        int n = number.length;

        boolean dp[][] = new boolean[n+1][sum+1];

        System.out.println(TargetSumSubsetMemoi(number, n, sum, dp));
    }
}
