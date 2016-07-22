package Queue;

/**
 *
 * @author Vodka
 */
public interface Queue_Interface {
    //Reinitialize the queue
    public void clear();
    //Add new element on rear
    public boolean enqueue(Object in);
    //Remove and return element at front
    public Object  dequeue();
    //Return front element
    public Object frontValue();
    //Return queue size
    public int length();
}
