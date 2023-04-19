import java.util.Arrays;

public class LastIndex{
    public static void main(String[] args){
        /* int[] A = {5,2,64, -26, 8,92,5, 5,102,0,70};
        System.out.printf("Last occurance of largest int is at index %d\n", LastIndex(A));

        System.out.printf("\n\n Array before reversal: %s\n", Arrays.toString(A));
        Reverse(A);
        System.out.printf("\n\n Array after reversal: %s\n", Arrays.toString(A)); */
        int[] B = {0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,1,0,0,1};
        System.out.printf("%s\n", Arrays.toString(B));
        SortOnes(B);
        System.out.printf("%s\n", Arrays.toString(B));
        
    }
    public static int LastIndex(int[] A){
        int j = 1;
        int max = 0;
        for (int i = 0; i<A.length-2;i++){
            if (A[j]>= A[i]){
                max = j;
            }
            j++;
        }
        return max;
    }
    public static void Reverse(int[] A){
        int i = 0;
        int j = A.length-1;
        int temp = 0;

        while (i<j){
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
    public static void SortOnes(int[] A){
        int i = 0;
        int j = A.length-1;
        int temp = 0;
        while(i<j){
            if(A[i]>A[j]){
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            i++;
            j--;
        }
    }
}