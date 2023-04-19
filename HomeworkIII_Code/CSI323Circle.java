/**
* @author Junior Moremong (202001442)
* @author Prudence Mosimanyana (202003799)
* @version 1.0
* Description: This class creates a circle.
*/
 
public class CSI323Circle{
    /**
    * The centre of the circle (CSI323Point object) and the circle's radius
    */
    private CSI323Point centre;
    private double radius;

    /**
    * Create a new circle.
    * @param centre,radius This the the centre of the circle and its radius.
    */
    public CSI323Circle(CSI323Point centre, double radius){
        this.centre = centre;
        this.radius = radius;
    }

    /**
    * Get the centre of the circle
    * @return A CSI323Point value of the circle's centre
    */
    public CSI323Point centre(){
        return centre;
    }

    /**
    * Get the radius of the circle
    * @return A Double value of the radius
    */
    public double radius(){
        return radius;
    }

    /**
    * Checks if two circles intersect
    * @param otherCircle Another circle object
    * @return True if the intersect, falst otherwise
    */
    public boolean intersect(CSI323Circle otherCircle){
        double d = this.centre.distTo(otherCircle.centre); //distance between the centres of the circle
        double r1 = this.radius; //radius of the first circle
        double r2 = otherCircle.radius; //radius of the second circle
        return d <= r1 - r2 || d <= r2 - r1 || d <= r1 + r2; //Checking if they intersect based on values in the method
    }

    /** 
    * Produces string of circle centre and radius values
    * @return A String value of the circle
    */
    public String toString(){
        return "[" + centre.toString() + "]" +  radius;
    }
}