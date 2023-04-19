
public class Sorting{
    public static void main(String[] args){
        int[] a = {11, 21, 3, 44, 15, 6, 78, 8, 9, 10};
        System.out.printf("Before sorting: ");
        for(int i = 0; i < a.length; i++){
            System.out.printf("%d ",a[i]);
        }
        System.out.println();
        SortTwo(a);
        System.out.printf("After sorting: ");
        for(int i = 0; i < a.length; i++){
            System.out.printf("%d ",a[i]);
        }
    }
    public static void SortOne(int[] a){
        for(int i = 0; i<a.length-1; i++){
            for(int j = 0; j<a.length-1-i; j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void SortTwo(int[] a){
        int min = 0;
        for(int i = 0; i < a.length;i++){
            min = i;
            for(int j = i+1; j < a.length; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

}