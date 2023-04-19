import java.util.Arrays;

public class ProblemZero{
    public static void main(String[] args){
        int[] A = {2,4,58,7,145,5,3,12,120,180,180,180,26};

        System.out.printf("%d\n", LargeIndex(A));

        int[] B = {0,1,2,3};
        int[] C = {0,1,2,3,4};

        Reverse(B);
        Reverse(C);
        System.out.printf("Expected: [3,2,1,0]\tOutput: %s\n", Arrays.toString(B));
        System.out.printf("Expected: [4,3,2,1,0]\tOutput: %s\n", Arrays.toString(C));

    }

    public static int LargeIndex(int[] A){
        double largest= Double.NEGATIVE_INFINITY;
        int largeindex = 0;

        for(int i = 0; i<A.length; i++){
            if(A[i]>=largest){
                largest = A[i];
                largeindex = i;
            }
        }

        return largeindex;
    }

    public static void Reverse(int[] A){
        int i = 0;
        int j = A.length-1;

        while(i<j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}