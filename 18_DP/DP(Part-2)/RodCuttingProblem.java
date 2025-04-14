/* Given a rod of length n inches and array of prices that includes prices of
all pieces of size smaller than n . determin the maximum value obtainable by cutting up the rod and selling the pieces. */ 

public class RodCuttingProblem {

    public static void PrintArray(int dp[][]){
        for(int row[] : dp){
            for(int elem : row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }    


    public static int rodCuttingProblem(int length[],int price[],int totalLen){
        int n = price.length;
        int dp[][] = new int[n+1][totalLen+1];

        // initailize
        for(int i=0; i<n+1 ; i++){
            for(int j=0 ; j<totalLen+1 ; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        // Tabulation
        for(int i=1; i<n+1 ; i++){
            for(int j=1 ; j<totalLen+1 ; j++){
                if(length[i-1] <= j){
                    //include
                    int ans1 = dp[i][j - length[i-1]] + price[i-1];
                    // exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1,ans2);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        PrintArray(dp);
        return dp[n][totalLen];

    }

    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;

        System.out.println(rodCuttingProblem(length, price, rodLength));
    }

}
