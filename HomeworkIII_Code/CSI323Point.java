/**
* @author Junior Moremong (202001442)
* @author Prudence Mosimanyana (202003799)
* @version 1.0
* Description: This class creates a point that can be plotted on a plane.
*/

public class CSI323Point{
    /**
    * The points x and y.
    */
    private double x;
    private double y;

    /**
    * Creates a new point
    * @param x,y Values of x and y
    */
    public CSI323Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
    * Get the x value of a point
    * @return x in point (x,y)
    */
    public double x(){
        return x;
    }

    /**
    * Get the y value of a point
    * @return y in point (x,y)
    */
    public double y(){
        return y;
    }

    /**
    * Finds the euclidean distance between two points
    * @param otherPoint Another point
    * @return Double value of the distance
    */
    public double distTo(CSI323Point otherPoint){
        return Math.sqrt(Math.pow((this.y - otherPoint.y), 2) + Math.pow((this.x - otherPoint.x), 2));
    }

    /** 
    * Produces string of x and y values
    * @return A String value of the point
    */
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    
}