
public class Knapsack {
    //0-1 knapsack

    // Recursion
    public static int Knapsack(int val[],int wt[], int n,int W){
        if(n==0 || W==0){
            return 0;  // means if their is no item (n == 0) or no wt left to carry(W == 0) the profit will be 0
        }

        if( wt[n-1] <= W){
            // include item
            int ans1 = Knapsack(val, wt, n-1, W-wt[n-1]) + val[n-1];
            // exclude item
            int ans2 = Knapsack(val, wt, n-1, W);
            int profit = Math.max(ans1, ans2); 
            return profit;
        }else{
            return Knapsack(val, wt, n-1, W);
        }
    }


    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        int n = val.length;

        System.out.println(Knapsack(val, wt, n, W));
    }
}
