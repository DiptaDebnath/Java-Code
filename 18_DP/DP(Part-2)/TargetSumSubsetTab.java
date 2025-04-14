import java.util.*;

public class TargetSumSubsetTab {

    public static void printArray(boolean dp[][]){
        for (boolean row[] : dp){
            for ( boolean elem : row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    // apna college method
    public static boolean TargetSumSubsetTabu2(int number[], int n, int sum){
        boolean dp[][] = new boolean[n+1][sum+1];

        // initialize 
        for(boolean row[] : dp){
            Arrays.fill(row,false);
        }

        for(int i= 0; i<dp.length ; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++ ){
            for(int j=1; j<sum+1; j++){
                if(number[i-1] <= j  && dp[i-1][j-number[i-1]] == true){  //  Checks if the current number can be included and if the remaining sum is achievable.
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){ //  Checks if the sum is achievable without including the current number.
                    dp[i][j] = true;
                }
            }
        }

        printArray(dp);
        return dp[n][sum];


    }

    // own method
    public static boolean TargetSumSubsetTabu(int number[], int n, int sum){
        boolean dp[][] = new boolean[n+1][sum+1];

        // initialize 
        for(boolean row[] : dp){
            Arrays.fill(row,false);
        }

        for(int i= 0; i<dp.length ; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++ ){
            for(int j=1; j<sum+1; j++){
                if(number[i-1] <= j){
                    // include
                    boolean ans1 = dp[i-1][j-number[i-1]];
                    // exclude 
                    boolean ans2 = dp[i-1][j];
                    dp[i][j] = ans1 || ans2;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        printArray(dp);
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int number[] = {4,2,7,1,3} ;
        int sum = 10;
        int n = number.length;


        System.out.print(TargetSumSubsetTabu2(number, n, sum));
    }
}
