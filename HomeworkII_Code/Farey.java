/**
* @author(s) Prudence Mosimanyana (202003799) and Junior Moremong (202001442)
* @version 1.0
* description: This program calculates the Farey sequence of a given order.
 */

public class Farey{
    private Node first;
    private int level;

    //constructor
    public Farey(){
        first = new Node(new Fraction(0, 1));
        first.next = new Node(new Fraction(1, 1));
        level = 1;
    }

    //increases the level by one point
    public void increaseLevel(){
        level++; //increment level
        Node mediantNode; //variable to hold mediant
        Node tmp = first; //variable to help us iterate through the list
        Fraction med;
        while(tmp.next != null){
            med = tmp.data.mediant(tmp.next.data, level);
            //if median is valid, insert the median right after the current node
            if(med != null){
                mediantNode = new Node(med);
                mediantNode.next = tmp.next;
                tmp.next = mediantNode;
                mediantNode.prev = tmp;
                mediantNode.next.prev = mediantNode;
            }
            tmp = tmp.next;
        }
    }

    //change level to given int value
    public void changeLevel(int newLevel){
        //validate 
        if(level >= newLevel){
            return;
        }
        //step by step increase of the level until we reach the desired level
        while(level < newLevel){
            increaseLevel();
        }
    }

    //toString method
    @Override
    public String toString(){
        String s = level + ":";
        Node tmp = first;
        while(tmp != null){
            s = s + tmp.data.toString() + ", ";
            tmp = tmp.next;
        }
        return s;
    }


    //size of the sequence (number of fractions)
    public int size(){
        int size = 0;
        Node tmp = first;
        while(tmp != null){
            size++;
            tmp = tmp.next;
        }
        return size;
    }
    //Node private class
    private class Node{
        private Fraction data;
        private Node next;
        private Node prev;

        public Node(){
            data = null;
            next = null;
            prev = null;
        }

        public Node(Fraction data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
}