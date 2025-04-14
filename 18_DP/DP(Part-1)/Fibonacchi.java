public class Fibonacchi{
    //memoization
    public static int Fibonacchi(int n, int arr[]){
        if (n == 0 || n == 1) {
            return n;
        }

        if(arr[n] != -1){
            return arr[n];
        }

        arr[n] = Fibonacchi(n-1,arr) + Fibonacchi(n-2,arr);
        return arr[n];
    }
    public static void main(String args[]){
        int n = 2;
        int arr[] = new int[n+1];
        for(int i=0; i<arr.length; i++){
            arr[i] = -1;
        }
        System.out.println(Fibonacchi(n,arr));
    }
}


