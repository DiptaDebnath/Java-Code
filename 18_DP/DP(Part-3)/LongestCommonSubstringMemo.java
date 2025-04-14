public class LongestCommonSubstringMemo {
    public static void printArray(int arr[][]){
        for (int row[] : arr){
            for (int elem : row){
                System.out.print(elem +" ");
            }
            System.out.println();
        }
    }
    public static int LongestCommonSubstringMemoi(String str1,String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = LongestCommonSubstringMemoi(str1, str2, n-1, m-1, dp) + 1;
            return dp[n][m];
        }else{
            return dp[n][m] = 0;
        }
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abcdge";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        
        //initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = -1;
                }
            }
        }
        
        int ans = 0;
               // Fill the DP array correctly
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                LongestCommonSubstringMemoi(str1, str2, i, j, dp);
            }
        }
       

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        printArray(dp);
        System.out.println(ans);
    }

}
