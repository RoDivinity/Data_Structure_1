/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author Vodka
 */
public class Node {
    private Object a;
    private Node next;
    
    //constructor
    
    public Node (Object in , Node m_next){
        a = in;
        next = m_next;
    }
    
    public void setNext(Node m_next){
        next = m_next;
    }
    public Node next()
    {
        return next;
    }
    public void setElement(Object in)
    {
        a = in;
    }
    public Object getElement(){
        return a;
    }
}
