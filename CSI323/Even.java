public class Even{
    public static void main(String args[]){
        int[] A = {1 , 3, 5, 2, 9};
        System.out.printf("%b\n", EvenProduct(A, 0));
    }
    public static boolean EvenProduct(int[] A, int i){
        if(i<A.length-2){
            return EvenProduct(A, i+1);
        }
        else{
            return A[i]%2==0;
        }
    }
}