import java.util.Arrays;

public class QuizOne{
    public static void main(String[] args){
        //create an array of unsorted integers
        int[] A = {5,7,19,3,14,6,9};
        System.out.printf("midSum: %d\n", midSum(A));

        int[] B = {5,1,6,8,1,3,6,4,8,9,9,9,9,9,9,4,6,1,2,5,4,8,25};
        System.out.printf("secondLargest: %d\n", secondLargest(B));

        int[] C = {5,7,19,3,14,6,9, 2, 10, 1, 35, 11};
        oddEven(C);
        System.out.printf("oddEven: %s\n", Arrays.toString(C));

        int[] D = {-4,5,6,-7,-23,2,7,-10,3,-9};
        System.out.printf("negatives: %d\n", negatives(D, 0, D.length-1));
    }
    public static int midSum(int[] A){
        mergeSort(A, 0, A.length-1);
        int i = 1;
        int j = A.length-1;
        int sum = 0;

        while(i<j){
            sum = sum + A[i];
            i++;
        }
        return sum;
    }

    public static int secondLargest(int[] A){
        mergeSort(A, 0, A.length-1);
        int i = 0;
        int j = A.length-2;
        
        while (j == j-1 && i<j){
            j--;
        }
        return A[j];
    }

    public static void oddEven(int[] A){
        int i = 0;
        int j = A.length-1;
        while(i<j){
            while(A[i]%2==1){
                i++;
            }
            while(A[j]%2==0){
                j--;
            }
            if(i<j){
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
    }

    public static int negatives(int[] A, int p, int r){
        if(p>r){
            return 0;
        }
        if(A[p]<0){
            return 1 + negatives(A,p+1,r);
        }
        else{
            return negatives(A,p+1,r);
        }
    }

    public static void mergeSort(int[] A, int p, int r){
        //merge sort algorithm
        if(p < r){
            int q = (p + r)/2;
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }
    //merge method
    public static void merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++){
            L[i] = A[p + i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = A[q + j + 1];
        }
        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++){
            if(i < n1 && j < n2){
                if(L[i] <= R[j]){
                    A[k] = L[i];
                    i++;
                }
                else{
                    A[k] = R[j];
                    j++;
                }
            }
            else if(i < n1){
                A[k] = L[i];
                i++;
            }
            else if(j < n2){
                A[k] = R[j];
                j++;
            }
        }
    }
}