public class SearchArray{
    public static void main(String[] args){
        int[][] A  = new int[4][4];
        int x = 0;
        System.out.printf("\nOriginal Array:\n");
        for (int i = 0; i<A.length;i++){
            for(int j = 0; j<A.length;j++){
                A[i][j] = x;
                x++;
                System.out.printf("(%d, %d)\n", i, j);
                System.out.printf("%d\n", A[i][j]);
            }
        }
        System.out.printf("%d\n", Search(A,0,A.length-1,4));
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
    public static int Search(int[][] A, int p, int r, int x){
        int result = -1;
        for(int i = 0; i<A.length && result == -1;i++){
            result = Search(A[i],p,r,x);
        }
        return result;
    }
}