public class Logs{
    public static void main(String[] args){
        System.out.printf("%d\n", lg(32));
    }
    public static int lg(int N){
        int prod = 1;
        int x = 0;
        int checker = 0;
        while (prod < N){
            prod = prod * 2;
            checker = prod;
            while (checker >= 1){
                checker = checker/2;
                if(checker==1){
                x++;
            }
            } 
        }
        return x;
    }
}