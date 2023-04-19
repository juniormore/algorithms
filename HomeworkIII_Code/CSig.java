/**
* @author Junior Moremong (202001442)
* @author Prudence Mosimanyana (202003799)
* @version 1.0
* Description: This program is a solution to the CSig problem.
* how to compile: javac -cp .;algs4.jar CSig.java
* how to run: java -cp .;algs4.jar CSig <filename>
*/
import edu.princeton.cs.algs4.StdDraw;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class CSig{
    public static void main(String[] args)
    throws IOException
    {
        //check if the filename was provided before execution
        if(args.length != 1){
            System.out.println("You're doing it wrong!\nUsage: java CSig <filename>");
            System.exit(1);
        }

        Scanner in = new Scanner(new FileReader(args[0])); //read the file name
        double x = 0;
        double y = 0;
        ABag<CSI323Point> points = new ABag<CSI323Point>(); //create new bag for points
        //read points from file and store them in the bag
        while(in.hasNext()){
            x = in.nextDouble();
            y = in.nextDouble();
            CSI323Point point = new CSI323Point(x, y);
            points.addBack(point);
        }

        //Draw grid of 1000x1000 size
        drawGrid(1000, 20);

        //Plot the points
        plotPoints(points);

        //draw the circles from the plotted points
        ABag<CSI323Circle> circles = circles(points); //creating the circles
        drawCircles(circles);

        //draw the lines between intersecting circles
        int numOfLines = drawLines(circles);


        /************************************************************************************** 
            Testing the methods
        ***************************************************************************************/
        /*  //Testing closestPoint
        //creating new points to put in the bag
        CSI323Point a = new CSI323Point(1,2);
        CSI323Point b = new CSI323Point(3,2);
        CSI323Point c = new CSI323Point(2,6);

        ABag<CSI323Point> points = new ABag<>();//create new bag
        points.addBack(a);
        points.addBack(b);
        points.addBack(c);

        System.out.printf("%s\n", points.toString());

        //closest point
        System.out.printf("The closest point to a is at index %d\n", closestPoint(points, 1));

        //making circles out of the points up there.
        ABag<CSI323Circle> newCircles = circles(points);
        System.out.printf("Circles:\n%s\n", newCircles.toString());
        //drawing a small grid for testing.
        drawGrid(10,1);
        plotPoints(points);
        drawCircles(newCircles);//drawing circles we just made

        //lines
        drawLines(newCircles); */
    }

    /**
    * Find the closest point to the one at the given position
    * @param points,pos A CSI323Point bag containing points, and the position of a point
    * @return Index of the closest point to the point at pos.
    */
    public static int closestPoint(ABag<CSI323Point> points, int pos){
        int size = points.size();// size of the points bag
        // validate position index
        if(size == 0 || pos > size){
            throw new IndexOutOfBoundsException();
        }
        int closest = 0;//store index of the closest point
        double d = 0; //variable to store the distance between points
        double minDist = Double.POSITIVE_INFINITY; //assign minimum distance to an arbitrarily large number
        //go through each point, find the distance, and compare it to the current minimum distance
        for(int i = 0; i < size; i++){
            if(i != pos){
                d = points.get(pos).distTo(points.get(i));
                if(d < minDist){
                    minDist = d;
                    closest = i;
                }
            }
        }
        return closest;
    }

    /**
    * Creates circles out of points
    * @param points A CSI323Point bag containing points
    * @return ABag object of circles. For each
        point p in the given points, find its closest
        point q amongst other points, then create a
        circle with centre p and radius equal to the
        distance between p and q, its closest point.
    */
    public static ABag<CSI323Circle> circles(ABag<CSI323Point> points){
        ABag<CSI323Circle> circles = new ABag<CSI323Circle>();//create the circles object
        int size = points.size(); //points bag size
        int closest = 0; //index of the closest point
        //go through each point, find the closest point to it, and create a circle equal to the distance of the two
        for(int i = 0; i < size; i++){
            closest = closestPoint(points, i);
            circles.addBack(new CSI323Circle(points.get(i), points.get(i).distTo(points.get(closest))));
        }
        return circles;
    }

    /**
    * Draws grid
    * @param N,step Grid will  be NxN, and will have interval steps.
    */
    public static void drawGrid(int N, int step){
        StdDraw.setScale(0, +N); // size of grid
	    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE); // color of the drawing pen
        
        //draw the grid
        for(int r = step; r < N; r+=step){
            StdDraw.line(r, 0, r, N-1);
        }
	    for(int r = step; r < N; r+=step){
            StdDraw.line(0, r, N-1, r);
        }
    }

    /**
    * Plots points on the grid
    * @param points To be plotted
    */
    public static void plotPoints(ABag<CSI323Point> points){
        StdDraw.setPenRadius(0.012);  // set pen radius thickness
	    StdDraw.setPenColor(StdDraw.BLACK); // set pen color

        //iterate through the list of points and plot them
        Iterator<CSI323Point> it = points.iterator();
        while(it.hasNext()){
            CSI323Point p = it.next();
            StdDraw.point(p.x(), p.y());
        }
    }

    /**
    * Draws the circles on the grid
    * @param circles A bag of circles
    */
    public static void drawCircles(ABag<CSI323Circle> circles){
        StdDraw.setPenRadius(0.002);  // set pen radius thickness
        StdDraw.setPenColor(StdDraw.RED); // set pen color
        //iterate through the list of circles and draw
        Iterator<CSI323Circle> it = circles.iterator();
        while(it.hasNext()){
            CSI323Circle c = it.next();
            StdDraw.circle(c.centre().x(), c.centre().y(), c.radius());
        }
    }

    /**
    * Draws a line between centres of every two circles that intersect 
    * @param circles A bag of circles
    * @return The number of lines drawn
    */
    public static int drawLines(ABag<CSI323Circle> circles){
        int count = 0; //variable for the number of lines
        int size = circles.size(); //size of bag of circles
        StdDraw.setPenRadius(0.0025); //set pen point
	    StdDraw.setPenColor(StdDraw.BLUE); //set point color

        //go through each circle, and check if it intersects with every other circle. Draw a line between centres of those that intersect
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i != j){
                    if(circles.get(i).intersect(circles.get(j))){
                        CSI323Point c1 = circles.get(i).centre();
                        CSI323Point c2 = circles.get(j).centre();
                        StdDraw.line(c1.x(), c1.y(), c2.x(), c2.y());
                        count++;
                    }
                }
            }
        }
        return count;
    }
}