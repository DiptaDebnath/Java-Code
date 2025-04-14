/*Given a string word1 and word2 . Return the minimum number of operation required to convert word1 to word2.
I have the following operation peritted on a word
1. Insert a character
2. Delete a character 
3. Replace a character
*/
public class EditDistance {
   public static int editDistance(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        //initialization
        for(int i = 0; i<n+1; i++){
            for (int j = 0; j < m+1; j++) {
                if(i == 0){
                    dp[i][j] = j;  // If str2 is empty, converting str1 to an empty string requires deleting all i characters of str1
                }
                if(j == 0){
                    dp[i][j] = i; //If str1 is empty, converting an empty string to str2 requires inserting all j characters of str2.
                }
            }
        }

        // Tabulation
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){ //the characters at the current positions are the same, so no operation is needed. The edit distance is the same as for the substrings without these characters
                    dp[i][j] = dp[i-1][j-1]; 
                }else{
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add, Math.min(del,rep));

                }
            }
        }
        return dp[n][m];
        
   }
   public static void main(String[] args) {
        String word1 = "intention";
        String Word2 = "execution";

        System.out.println(editDistance(word1, Word2));
   } 
}
