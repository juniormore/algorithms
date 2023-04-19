/**
* @author Prudence Mosimanyana (202003799)
* @author Junior Moremong (202001442)
* @version 1.0
* description: A tester class for the Fraction.java and Farey.java classes.
*/

public class Tester{
    public static void main(String[] args){

        //testing the fraction class
        Fraction fr = new Fraction(1 ,2);
        System.out.printf("%s\n", fr.toString());

        Fraction that = new Fraction(3, 4);

        Fraction med = fr.mediant(that, 6);

        System.out.printf("%s\n", med.toString());

        //testing the Farey class

        Farey seq = new Farey();
        System.out.printf("%s\n", seq.toString());
        System.out.printf("Size: %d\n", seq.size());
        seq.increaseLevel();
        System.out.printf("%s\n", seq.toString());
        System.out.printf("Size: %d\n", seq.size());
        seq.increaseLevel();
        System.out.printf("%s\n", seq.toString());
        System.out.printf("Size: %d\n", seq.size());
        seq.increaseLevel();
        System.out.printf("%s\n", seq.toString());
        System.out.printf("Size: %d\n", seq.size());
        seq.increaseLevel();
        System.out.printf("%s\n", seq.toString());
        System.out.printf("Size: %d\n\n", seq.size());

        Farey rad = new Farey();
        rad.changeLevel(10);
        System.out.printf("%s\n", rad.toString());
        System.out.printf("Size: %d\n\n", rad.size());
    }
}