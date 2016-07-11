/*
 * Basic functions of Abstract Data Type (ADT) - List -
 * 
 * + Work as a sequence: Elements are defined by value + pos in the List
 * + ADT does not depend on data type of elements
 * + Able to insert and remove elements in list
 * + Able to know if list is empty, numbers of elements in list
 * + First element is head, pos 0, and last element is tail, pos length - 1
 * CONCEPT OF CURRENT POSITION ( Pointer )
 */
package List;

/**
 * @title List Interface (Container of all kinds of List e.g. Linked List, Doubly Linked List)
 * @author Vodka
 */
public interface List_Interface {  //List ADT
    
    public void clear();                // remove all elements
    
    public boolean insert(Object a);    // add the element a to the current pos in the List
                                        // boolean to check if succesfully add (i.e. not exceed
                                        // the maximum List capacity)
    
    public boolean append(Object a);    // add the element a to the end of the List
                                        // boolean to check if succesfully add (i.e. not exceed
                                        // the maximum List capacity)
    
    public Object remove();             // remove and return the current element in List
                            
    public void moveToStart();          // set the current position to the start of the List
    
    public void moveToEnd();            // set the current position to the end of the List
    
    public void prev();                 // move the current position to the left by 1 element
                                        // if the List is 1 way, return if alr at beginning
    
    public void next();                 // move the current position to the right by 1 element
                                        // if the List is 1 way, return if alr at end
    
    public int length();                // return number of elements in the list
    
    public int currPos();               // return current position ( pointer )
    
    public boolean moveToPos(int pos);  // set the current position to designated pos
    
    public Object getValue();           // return the current element
}
