public class MaxSubArray{
    
    public static void main(String[] args){
        int[] arr = {-1, 2, 0, 3, -4, 6};
        int sum = max(arr);
        System.out.printf("Max sum = %d\n", sum);
    }
    public static int max(int[] arr){
        int maxarray_sum = (int)Double.NEGATIVE_INFINITY;
        System.out.printf("%d\n",maxarray_sum); 
        int n = arr.length - 1;
        for (int i = 0; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum = sum + arr[j];
                if (sum > maxarray_sum){
                    maxarray_sum = sum;
                }
            }
        }
        return maxarray_sum;
    }     
    
}