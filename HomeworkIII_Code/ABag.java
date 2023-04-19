/**
* @author Junior Moremong (202001442) 
* @author Prudence Mosimanyana (202003799)
* @version 1.0
* Description: An implementation of a bag using a linked list.
*/
import java.util.Iterator;

public class ABag<E> implements Iterable<E>
{
    /**
    * The first and last nodes in the bag
    */
    private Node first;
    private Node last;

    /**
    * Create a new, empty ABag object.
    */
    public ABag(){
       first = null;
       last = null;
    }
    /**
    * Adds an item to the front of the list
    * @param item This is item of generic type.
    */
    public void addFront(E item){
        Node tmp = new Node(item);
        //if the bag is empty then the new node becomes first and last
        if(first == null){
            first = tmp;
            last = tmp;
        }
        else{
            tmp.next = first; //point the new node's next to the first node
            first.prev = tmp; //the old first node points back to the new node
            first = tmp; //the new node becomes first
        }
    }

    /**
    * Adds an item to the back of the list
    * @param item This is item of generic type.
    */
    public void addBack(E item){
        Node tmp = new Node(item);
        //if the bag is empty then the new node becomes first and last
        if(first == null){
            first = tmp;
            last = tmp;
        }
        else{
            last.next = tmp; //point the last node to the new node
            tmp.prev = last; //the new node points back to the current last
            last = tmp; //assign the new node as the last item
        }
    }

    /**
    * Checks if the bag is empty
    * @return true if it there is nothing in the bag, false if there is at least one item.
    */
    public boolean isEmpty(){
       return first == null;
    }

    /** 
    * Gives the number of items in the ABag object.
    * @return int value of the size of the bag.
    */
    public int size(){
        Node tmp = first;
        int count = 0;
        //traverse through the list to count
        while(tmp != null){
          tmp = tmp.next;
          count++;
        }
        return count;
    }
    /** 
    * Shows the value of the item at the given index in the list
    * @param i The desired index.
    * @return The item at i in the list.
    */
    public E get(int i){
        //check validity of the index parameter
        if(i < 0 || i >= size()){
            throw new IndexOutOfBoundsException();
        }

        //go through the list until the desired index
        Node tmp = first;
        for(int j = 0; j < i; j++){
            tmp = tmp.next;
        }
        return tmp.data;
    }

    /** 
    * Converts values of ABag items to string
    * @return A String of all the items in the bag
    */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Node tmp = this.first; tmp != null; tmp = tmp.next) {
            builder.append(String.format("%s, ", tmp.data == null ? "null" : tmp.data.toString()));
        }
        builder.append("]\n");

        return builder.toString();
    }

    /**
    * Refer to Java usage of the Iterator class.
    */
    public Iterator<E> iterator()
    {
        return new ABagIterator();
    }
    
    //BagIterator
    private class ABagIterator implements Iterator<E>
    {
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public E next(){
            E item = current.data;
            current = current.next;
            return item;
        }

    }

    //private Node class
    private class Node
    {
        private E data;
        private Node next;
        private Node prev;
        
        private Node(E data)
        {
            this.data = data;
            next = null;
            prev = null;
        }
       
        private Node()
        {
            data = null;
            next = null;
            prev = null;
        }
    }
}