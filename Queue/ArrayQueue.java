package Queue;

/**
 *
 * @author Vodka
 */
public class ArrayQueue implements Queue_Interface{
    
    private static int DEFAULT_SIZE = 100;
    private Object[] queue;
    private int front;
    private int rear;
    private int maxSize;
    
   //constructor
    public ArrayQueue(int size)
    {
        maxSize = size + 1;         //add 1 extra space for front
        queue = new Object[maxSize];
        front = 1 ; rear = 0;
    }
    
    public ArrayQueue(){
        this(DEFAULT_SIZE);
    }
    
    @Override
    public void clear()
    {
        rear = 0; front = 1;
    }
    @Override
    public boolean enqueue(Object in){
        if((rear + 2) % maxSize == front)         //the queue is full
            return false;
        rear = (rear + 1) % maxSize;               //circular increment
        queue[rear] = in;
        return true;
    }
    
    @Override
    public Object dequeue(){
        if (length() == 0)              //the queue is empty
            return null;
        Object out = queue[front];
        front = (front + 1) % maxSize;          //circular increment
        return out;
    }
    
    @Override
    public int length()
    {
        return (( rear + maxSize ) - front + 1) % maxSize;
    }

    @Override
    public Object frontValue() {
        if (length() == 0)
            return null;
        return queue[front];
    }
}
