public class UnboundedKnapsack {
    // recursion
    public static int UnboundedKnapsackRec(int val[], int wt[], int n, int W ){
        if(n == 0 || W == 0){
            return 0;
        }

        if(wt[n-1] <= W){ // valid
            // include
            int ans1 = UnboundedKnapsackRec(val, wt, n, W-wt[n-1]) + val[n-1];
            // exclude
            int ans2 = UnboundedKnapsackRec(val, wt, n-1, W);

            return Math.max(ans1,ans2);
        }else{ // invalid
            return UnboundedKnapsackRec(val, wt, n-1, W);
        }

    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int n = val.length;

        System.out.println(UnboundedKnapsackRec(val, wt, n, W));
    }
}
