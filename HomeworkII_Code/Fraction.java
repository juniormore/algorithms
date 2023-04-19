/**
* @author Prudence Mosimanyana (202003799)
* @author Junior Moremong (202001442)
* @version 1.0
* description: A class that works with fractions.
*/

public class Fraction implements Comparable<Fraction>{
    //instance variables
    private int num;//numerator
    private int den; //denominator

    //initializing instance variables
    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
    }

    //returning the denominator
    public int den(){
        return den;
    }

    //returning the denominator
    public int num(){
        return num;
    }

    //return mediant fraction
    public Fraction mediant(Fraction that, int n){
        int a = this.num;
        int b = this.den;
        int c = that.num;
        int d = that.den;
        
        if(b + d <= n){
            return new Fraction(a + c, b + d);
        }
        else{
            return null;
        }
    }
    //overriding the compareTo method
    @Override
    public int compareTo(Fraction that){
        if(this.num * that.den > that.num * this.den){
            return 1;
        }
        else if(this.num * that.den < that.num * this.den){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    //override equals method
    @Override
    public boolean equals(Object that){
        if(that == null){
            return false;
        }
        if(that.getClass() != this.getClass()){
            return false;
        }
        Fraction thatFraction = (Fraction) that;
        return this.num == thatFraction.num && this.den == thatFraction.den;
    }

    //returning the string representation of the fraction
    @Override
    public String toString(){
        return num + "/" + den;
    }
}