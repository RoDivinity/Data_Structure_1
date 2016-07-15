/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *  Class node of the linked list
 * It contains element and a reference pointer to next node itself
 * @author Vodka
 */
public class Node {
    private Object a;       //Value of element
    private Node next;      //Pointer of next node
    
    //constructor for a node
    public Node (Object in, Node link )
    {
        a = in;
        next = link;
    }
     //default constructor
    public Node( Node link)
    {
        a    = null;
        next = link;
    }
    public Node (Object in)
    {
        a = in;
        next = null;
    }
    
    public Object getElement()
    {
        return a;
    }
    
    public void setElement(Object in)
    {
        a = in;
    }
    
    public Node next()
    {
        return next;
    }
    
    public void setNext(Node link)
    {
        next = link;
    }
}
