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
    }private static Node freelist = null;        //add in free list 
                                                //freelist works like a Linked Stack
    private static int count = 0;
    //free list support extensions
    static Node get(Object in, Node m_next){
        if (freelist == null)              //no free Node available, create a new Node
            return new Node(in , m_next);
        else
        {
        Node temp = freelist;               //return the first node in free list as container 
        freelist = freelist.next();
        temp.setElement(in);
        temp.setNext(m_next);
        count --;
        return temp;
        }
    }
    
    public void release()
    {
        a = null;           //dereference of the object in the Node
        next = freelist;    //add it to the front of free list
        freelist = this;    //make freelist accesssible!, otherwise freelist always == null as 
        count ++;           //initially freelist = null;
    }
    
    public int freelistCount() {return count;}
}
