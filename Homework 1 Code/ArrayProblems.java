/*
@author Junior Mormeong
description a few problems from the Algorithms textbook for CSI323 */
import java.util.Arrays;
import java.util.Random;

public class ArrayProblems{
    public static void main(String[] args){
        
        Random rand = new Random();
        
        //********************************2D Boolean array (Problem 1.1.11)***********************************************
        boolean[][] A = new boolean[rand.nextInt(9) + 1][rand.nextInt(9) + 1];

        System.out.printf("Original Array:\n");
        for (int i = 0; i<A.length;i++){
            for(int j = 0; j<A[0].length;j++){
                int flag = rand.nextInt(2);
                A[i][j] = flag == 1;
                System.out.printf("(%d, %d)\n", i, j);
                System.out.printf("%b\n", A[i][j]);
            }
        }
        System.out.printf("Output:\n");
        ArrayFun(A);

        //********************************Transpose method testing (Problem 1.1.13)***********************************************
        int[][] B  = new int[rand.nextInt(9) + 1][rand.nextInt(9) + 1];

        System.out.printf("\nOriginal Array:\n");
        for (int i = 0; i<B.length;i++){
            for(int j = 0; j<B[0].length;j++){
                B[i][j] = rand.nextInt(10);
                System.out.printf("(%d, %d)\n", i, j);
                System.out.printf("%d\n", B[i][j]);
            }
        }
        System.out.printf("Transposed Array:\n");
        Transpose(B);

    }
    public static void Transpose(int[][] A){
        int[][] B = new int [A[0].length][A.length];
        for (int i = 0;i<B.length;i++){
            for (int j = 0; j<B[0].length;j++){
                B[i][j] = A[j][i];
                System.out.printf("(%d, %d)\n", i,j); //coordinates for each point in the matrix
                System.out.printf("%d\n", B[i][j]);   //value
            }
        }    
    }
    public static void ArrayFun(boolean[][] A){
        char star = '*';
        char space = ' ';

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                //System.out.printf("(%d, %d)\n", i,j);
                if(A[i][j]){
                    System.out.printf("%c", star);
                }
                else {
                    System.out.printf("%c", space);
                }
            }
            System.out.printf("\n");
        }
    }
}