public class LargestCommonSubsequence{
    // recurtion
    public static int lcs(String str1,String str2, int n, int m){
        if(n == 0 || m == 0){  //If either of the strings is empty, the LCS length is 0.
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){ //If the last characters of both strings match, the LCS length increases by 1, and we recursively find the LCS of the remaining substrings 
            return lcs(str1, str2, n-1, m-1) + 1;
        }else{
            int ans1 = lcs(str1, str2, n-1, m);  //Exclude the last character of str1 and find the LCS of str1 (excluding the last character) and str2
            int ans2 = lcs(str1, str2, n, m-1); // Exclude the last character of str2 and find the LCS of str1 and str2 (excluding the last character).
            return Math.max(ans1,ans2);
        }
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abge";

        int n = str1.length();
        int m = str2.length();

        System.out.println(lcs(str1, str2, n, m));
    }
}