public class Search{
    public static void main(String[] args){
        int[] A = {1,2,3,4,5,6,78,9};
        int x = 3;
        int n = A.length;
        System.out.printf("Search 1: %d\n", Search(A,x,n));
        System.out.printf("Search 2: %d\n", Search(A,0,n-1,x));
    }
    public static int Search(int[] A, int x, int n){
        if (n==0){
            if (A[n]==x){
                return n;
            }
            else {
                return -1;
            }
        }
        else{
            n = n-1;
            if (A[n]==x){
                return n;
            }
            else {
                return Search(A, x, n);
            }
        }
    }

    public static int Search(int[] A, int p, int r, int x){
        if(p>r){
            return -1;
        }
        if (p==r){
            if(A[p]== x){
                return p;
            }
            else{
                return -1;
            }
        }
        else {
            int mid = p + (r-p)/2;
            if(A[mid]==x){
                return mid;
            }
            int i = Search(A, p, mid-1,x);
            int j = Search(A, mid+1,r,x);
            if (i>-1){
                return i;
            }
            else if(j>-1) {
                return j;
            }
            return -1;
        }
    }
}