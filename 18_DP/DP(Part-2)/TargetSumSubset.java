public class TargetSumSubset {

    public static boolean TargetSum(int number[],int n, int sum){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(number[n-1] <= sum){ // invalid 
            // include 
            boolean ans1 = TargetSum(number, n-1, sum-number[n-1]);
            // exclude
            boolean ans2 = TargetSum(number, n-1, sum);
            return ans1 || ans2;
        }else{ //valid
            return TargetSum(number, n-1, sum);
        }

    }
    public static void main(String[] args) {
        int number[] = {4,2,7,1,3} ;
        int sum = 10;
        int n = number.length;
        System.out.println(TargetSum(number, n, sum));
    }
}
