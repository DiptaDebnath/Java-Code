
public class LargestCommonSubsequenceMemo {
    public static int lcs(String str1,String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m]; // If the result for dp[n][m] is already calculated, return it directly
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = lcs(str1, str2, n-1, m-1, dp) + 1; //If the last characters of both strings match, the LCS length increases by 1, and we recursively find the LCS of the remaining substrings 
            return dp[n][m];
        }else{
            int ans1 = lcs(str1, str2, n-1, m, dp);//Exclude the last character of str1 and find the LCS of str1 (excluding the last character) and str2
            int ans2 = lcs(str1, str2, n, m-1, dp);// Exclude the last character of str2 and find the LCS of str1 and str2 (excluding the last character).

            dp[n][m] = Math.max(ans1,ans2);
            return dp[n][m];
        }
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abcge";

        int n = str1.length();
        int m = str2.length();
        int dp[][] =  new int[n+1][m+1];

        // initialize 
        for(int i = 1; i<n+1; i++){
            for (int j = 1; j <m+1; j++) {
               dp[i][j] = -1; 
            }
        }

        System.out.println(lcs(str1, str2, n, m, dp));
    }
}
