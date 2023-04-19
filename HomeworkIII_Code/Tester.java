/**
* @author Junior Moremong (202001442)
* @author Prudence Mosimanyana (202003799)
* A tester class to test ABag, CSI323Circle, and CSI323Point
*/
import java.util.Iterator;

public class Tester{
    public static void main(String[] args){
        
        //testing the ABag class
        ABag<Integer> bag = new ABag<Integer>(); //creating new bag object
        if(bag.isEmpty()){
            System.out.printf("This bag is empty\n");
        }
        //adding to the bag from the back
        for(int i = 0; i < 10; i++){
            bag.addBack(2 * i);
        }
        System.out.printf("%s\n", bag.toString()); //testing toString()
        bag.addFront(2222222);
        System.out.printf("Size: %d\n%s\n", bag.size(), bag.toString()); //size
        System.out.printf("At index 4: %d\n", bag.get(4));
        Iterator<Integer> it = bag.iterator();
        while(it.hasNext()){
            System.out.printf("%d ", it.next());
        }

        //testing the CSI323Point class
        CSI323Point a = new CSI323Point(1,2);
        CSI323Point b = new CSI323Point(3,2);
        CSI323Point c = new CSI323Point(2,6);

        System.out.printf("Point a\nx: %.2f, y: %.2f\n", a.x(), a.y());
        System.out.printf("Point b\n%s\n", b.toString());
        
        //distance
        double d1 = a.distTo(b);
        double d2 = a.distTo(c);
        System.out.printf("Distance 1:%.2f\nDistance 2:%.2f\n",d1, d2);

        //testing the CSI323Circle class
        CSI323Circle circle1 = new CSI323Circle(new CSI323Point(0,0), 1);
        CSI323Circle circle2 = new CSI323Circle(new CSI323Point(2,0), 1);
        CSI323Circle circle3 = new CSI323Circle(new CSI323Point(5,5), 2);

        System.out.printf("Circle 1 centre=%s\nradius=%.2f\n", circle1.centre().toString(), circle1.radius());
        if(circle1.intersect(circle2)){
            System.out.printf("1: They intersect\n");
        }
        if(circle2.intersect(circle3)){
            System.out.printf("2: They intersect\n");
        }

        System.out.printf("This is a circle:%s\n", circle3.toString());
    }
}