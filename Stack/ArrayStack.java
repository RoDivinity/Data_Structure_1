package Stack;

/**
 *
 * @author Vodka
 */
public final class ArrayStack implements Stack_Interface{

    private static final int DEFAULT_SIZE = 100;
    private Object[] stack;
    private int stackSize;
    //no need int to track the pointer because it's always on top
    //array starts at index 0, so stackSize starts at -1, length = stackSize + 1
    //constructors
    
    public ArrayStack(int size){
        stack = new Object[size];
        stackSize = -1;
    }
    
    public ArrayStack(){
        stack = new Object[DEFAULT_SIZE];
        stackSize = -1;
    }
    
    @Override
    public void clear() {
        stackSize = -1;
    }

    @Override
    public boolean push(Object a) {
        stack[++stackSize] = a;
        return true;
    }

    @Override
    public Object pop() {
        return stack[stackSize--];
    }

    @Override
    public Object peek() {
        return stack[stackSize];
    }

    @Override
    public int length() {
        return stackSize+1;
    }
    
}
