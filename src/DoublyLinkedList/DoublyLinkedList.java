package DoublyLinkedList;
import List.*;
/**
 *
 * @author Vodka
 */
public final class DoublyLinkedList implements List_Interface{

    private Node head;
    private Node tail;
    private Node curr;          //main navigator in the list
    private int listSize;
    
    //constructor
    public DoublyLinkedList()
    {
        clear();
    }
    
    @Override
    public void clear() {
        listSize = 0;
        head = tail = new Node(null , null , null);     //Initialize head and tail Node
        head.setNext(tail);                             //set pointers to be corrected
        tail.setPrev(head);
        curr = tail;                                    //set CURRRENT POS = tail i.e. top of the empty list
    }

    @Override
    public boolean insert(Object a) {
        curr = new Node ( a , curr.prev() , curr );     //insert a new Node with value a
        curr.prev().setNext(curr);                      //set pointer of previous Node to point to new Node
        curr.next().setPrev(curr);                      //set pointer of next Node to point to new Node
        listSize++;
        return true;
    }

    @Override
    public boolean append(Object a) {
        tail.setPrev(new Node(a , tail.prev() , tail)); //create a new Node behind tail, set prev pointer
                                                        //of this new Node to point to Node tail.prev()
                                                        //and next pointer to point to tail itself
        tail.prev().prev().setNext(tail.prev());        //set the pointer of the Node in front of new Node
        if (curr == tail)                               //to point to new Node itself
            curr = tail.prev();                         //change curr back to the new Node added if this is 1st element                                                
        listSize++;
        return true;
    }
    
    @Override
    public Object remove() {
    if (curr == tail) return null;
    Object out = curr.getElement();
    curr.prev().setNext(curr.next());       //change pointers around prev and next Nodes of CURRENT POS
    curr.next().setPrev(curr.prev());       //CURRENT POS no longer accessible
    listSize --;
    return out;
    }

    @Override
    public void moveToStart() {
    curr = head.next();
    }

    @Override
    public void moveToEnd() {
    if (curr != tail)   //no element in list => alr in the end
        curr = tail.prev();
    }

    @Override
    public void prev() {
    if (curr.prev()!=head)     //if not at the front, move to previous node
        curr = curr.prev();
    }

    @Override
    public void next() {
    if (curr != tail)           //if not at the end, move to next node
        curr = curr.next();
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        Node temp = head.next();            //access point
        int i;
        for (i = 0; curr!=temp ; i++)
        {
            temp = temp.next();
        }
        return i;    
    }

    @Override
    public boolean moveToPos(int pos) {
        if ( (pos < 0) || (pos>listSize) )   //no such position, smallest is 0 and largest is listSize - 1
            return false;
        curr = head.next();                  //change our CURRENT POS to the front
        for ( int i = 0; i<pos ; i++)
            curr = curr.next();
        return true;
    }

    @Override
    public boolean isAtEnd() {
        return curr == tail;
                }

    @Override
    public Object getValue() {
    return curr.getElement();    
    }
    
}
