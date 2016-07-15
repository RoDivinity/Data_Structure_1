/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;
import List.*;
/**
 *
 * @author Vodka
 */
public class LinkedList implements List_Interface {
    private Node head;
    private Node tail;
    private Node curr;          //main navigator in the list
    private int listSize;
    
    //constructor
    public LinkedList() 
    {
        clear();
    }
    
    @Override
    public final void clear(){
        curr = tail = new Node(null);       //remove all link to tail node
        head = new Node(null);
        head.setNext(tail);
        listSize = 0 ;
    }
    
    @Override
    public boolean insert(Object in)
    {
        curr.setNext(new Node(curr.getElement() , curr.next())); //move the node at CURRENT POS 1 node ahead
        curr .setElement(in);                       //add in the new element in CURRENT POS
        if ( tail == curr) tail = curr.next();      //there's no Node in the list, create a new tail
        listSize ++;
        return true;
    }
    
    @Override
    public boolean append (Object in)
    {
        tail.setNext(new Node(null));   //create a new "tail"
        tail.setElement(in);            //add the new element in
        tail = tail.next();             //set current tail to new tail to reflect the appending
        listSize++;
        return true;
    }
    
    @Override
    public Object remove() //remove element at CURRENT POS
    {
        if (curr == tail)           //nothing in list to return
            return null;
        else
        {
            Object out = curr.getElement();             //Element to return (CURRENT POS)
            curr.setElement(curr.next().getElement());  //replace the CURRENT POS with next node
            if (curr.next() == tail)                    //uh-oh next in line is tail, so after remove
                tail = curr;                            //CURRENT POS will be new tail
            else
                curr.setNext(curr.next().next());       //skip 1 node because we have to move 1 node down to CURRENT POS
            listSize --;                                //CURRENT POS did not move at all!
            return out;
        }
    }
    
    @Override
    public void moveToStart() { curr = head.next(); }
    @Override
    public void moveToEnd()   { curr = tail;        }
    
    @Override
    public void prev()
    {
        if (head.next() == curr) return;        //nothing to see here, you are at the front!
        Node temp = head;                       //access point
        while(temp.next() != curr)
            temp = temp.next();                 //keep going until the next pointer point to CURRENT POS
        curr = temp;
    }
    
    @Override
    public void next()
    {
        if (curr.next()!= tail) curr = curr.next();
    }
    
    @Override
    public int length() 
    {
        return listSize;
    }

    @Override 
    public int currPos()
    {
        Node temp = head.next();            //access point
        int i;
        for (i = 0; curr!=temp ; i++)
        {
            temp = temp.next();
        }
        return i;
    }
    
    @Override
    public boolean moveToPos(int pos)
    {
        if ( (pos < 0) || (pos>listSize) )   //no such position
            return false;
        curr = head.next();                  //change our CURRENT POS to the front
        for ( int i = 0; i<pos ; i++)
            curr = curr.next();
        return true;
    }
    
    @Override
    public boolean isAtEnd()
    {
        return curr == tail;
    }
    
    @Override
    public Object getValue()
    {
        return curr.getElement();
    }
}
