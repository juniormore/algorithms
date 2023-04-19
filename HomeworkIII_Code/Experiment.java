/**
* @author(s) Junior Moremong (202001442) and Prudence Mosimanyana (202003799)
* @version 1.0
* description: An experiment using the classes in this folder
* how to compile: javac -cp .;algs4.jar Experiment.java
* how to run: java -cp .;algs4.jar Experiment
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class Experiment{
    public static void main(String[] args)
    throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter filename:");
        String outFile = in.next();
        PrintWriter out = new PrintWriter(outFile);

        int max = 0; //max number of lines
        String s = ""; //for point set
        //repeat experiment 2000 times
        for(int r = 0; r < 2000; r++){

            ABag<CSI323Point> points = new ABag<CSI323Point>(); //create a new object for set of points

            //add random point values and store them in the list
            for(int i = 0; i < 50; i++){
                CSI323Point p = new CSI323Point(150 + Math.random() * 700, 150 + Math.random() * 700);
                points.addBack(p);
            }

            ABag<CSI323Circle> circles = CSig.circles(points); //create circles from the points above
        
            int count = 0; //for number of lines that would be drawn. Similar to drawLines method in CSig.java.
            for(int i = 0; i < circles.size(); i++){
                for(int j = 0; j < circles.size(); j++){
                    if(i!=j){
                        if(circles.get(i).intersect(circles.get(j))){
                            count++;
                        }
                    } 
                }
            }
            //find the highest number of lines
            if(count > max){
                max = count;
                s = points.toString();
            }
        }
        out.printf("%s\n", s); //print point set with the highest number of lines
        out.printf("number of lines = %d\n", max);
        out.close();
    }
}