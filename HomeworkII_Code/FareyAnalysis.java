/**
* @author Prudence Mosimanyana (202003799)
* @author Junior Moremong (202001442)
* @version 1.0
* description: This program helps us understand the Farey sequence.
*/


import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;

public class FareyAnalysis{
    public static void main(String[] args)
    throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int N = in.nextInt();
        System.out.print("Enter the name of the output file: ");
        String outFileName = in.next();
        PrintWriter outFile = new PrintWriter(outFileName);
            
        Farey farey = new Farey();
        double function = 0.0;
        outFile.printf("%-20s %20s %20s\n", "Level", "Number of Fractions", "(3n^2)/pi^2");
        for(int i = 1; i<=N;i++){
            function = (3.0 * (i * i))/Math.pow(Math.PI, 2);
            outFile.printf("%-20d %20d %20.3f\n", i, farey.size(), function);
            farey.increaseLevel();
        }
        outFile.close();
    }
}

