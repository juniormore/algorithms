import java.util.Random;
public class Tester{
    public static void main(String[] args){
        System.out.printf("%d\n", log(2, 32));
        int[] arr = {10, 22, 13, 4, 58, 46, 7, 8, 9, 10};
        QuickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();

        int[] A = new int[15];
        Random rand = new Random(12345L);

        for(int i = 0; i < A.length; i++){
            A[i] = rand.nextInt(10);
        }
        MergeSort(A, 0, A.length - 1);
        for(int i = 0; i < A.length; i++){
            System.out.printf("%d ", A[i]);
        }


    }
    public static int log(int base, int num){
        return (int)(Math.log(num)/Math.log(base));
    }
    public static void QuickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            QuickSort(arr, low, pivot-1);
            QuickSort(arr, pivot+1, high);
        }
    }
    //partition for quicksort
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static void MergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            MergeSort(arr, low, mid);
            MergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++){
            L[i] = arr[low + i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}