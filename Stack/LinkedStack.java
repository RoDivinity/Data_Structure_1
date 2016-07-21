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
public class LinkedStack implements Stack_Interface{
    private Node top;
    private int size;
    
    //constructor
    public LinkedStack()
    {
        clear();
    }
    
    @Override
    public void clear(){
        top = null;
        size = 0;
    }
    
    @Override
    public boolean push(Object a){
        top = new Node ( a , top);      //Create a new Node, top, and set pointer point to previous top Node
        size ++;
        return true;
    }
    
    @Override
    public Object pop(){
        if (top == null)
            return null;
        Object out = top.getElement();
        top = top.next();
        size --;
        return out;
    }
    
    @Override
    public Object peek(){
        if (top == null)
            return null;
        return top.getElement();  
    }
    
    @Override
    public int length(){
        return size;
    }
}
