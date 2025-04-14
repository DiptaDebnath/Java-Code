import java.util.*;

public class ClimbingStairs {


    //Tabulation
    public static int climbstairsTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
       for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
       }
        return dp[n];
    }



    //Memoization
    public static int climbstairsMemo(int n,int dp[]){
        if(n==0){ 
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        int ways = climbstairsMemo(n-1,dp) + climbstairsMemo(n-2,dp);
        dp[n] = ways;
        return dp[n];
    }
    public static void main(String args[]){
        int n = 7;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Using memoization "+climbstairsMemo(n, dp));
        System.out.println("Using tabulation "+ climbstairsTab(n));
    }
}
