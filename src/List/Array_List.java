
package List;

/**
 *
 * @author Vodka
 */
public class Array_List implements List_Interface {
    private static final int DEFAULT_SIZE = 100;
    private Object[] listArray;
    private int maxSize;                            // max size of the array
    private int listSize;                           // current no of the list's elements
    private int currPos;                            // position of pointer, CURRENT POSITION
    
    //constructor of the Array List
    
    public Array_List(int size )
    {
        maxSize     = size;
        listSize    = 0;
        currPos     = 0;
        listArray   = new Object[size];
    }
    
    //default constructor
    
    public Array_List()
    {
        maxSize     = DEFAULT_SIZE;
        listSize    = 0;
        currPos     = 0;
        listArray   = new Object[DEFAULT_SIZE];
    }
    
    @Override
    public void clear()
    {
        listSize = currPos = 0;         //reinitialize the list by set the current position to 0; 
    }                                   //hence with no way to modified position, it is resetted
    
    @Override
    public boolean insert(Object a)
    {
        if (listSize >= maxSize)        //check if the current pos is not out of the list max size
            return false;
        for (int i = listSize ; i > currPos ; i --) //move the elements after CURRENT POSITION
                                                    //up by 1 to make room for a
        {
            listArray[i] = listArray[i-1];
        }                                           
        listArray[currPos] = a ;                    //done moving, add a into CURRENT POSITION
        listSize++;                                 //increase the size of the array
        return true;
    }
    
    @Override
    public boolean append(Object a)
    {
        if (listSize >= maxSize)
            return false;
        else 
            listArray[listSize++] = a;              //listSize++ because needs to add to last position
        return true;                                //which is = listSize, then increase size of the list by 1
    }                                               // => listSize++
    
    @Override 
    public Object remove()
    {
        if(listSize == 0)                           //empty List, there is no element to remove
        return null;
        Object a = listArray[currPos];              // return Object a at CURRENT POSITION
        for (int i = listSize ; i > currPos ; i --) // now shift all elements before the CURRENT POSITION
        {                                           // down by 1
            listArray[i] = listArray[i+1];
        }
        listSize --;                                 // decrease the list size
        return a;
    }
    /*
     * Manipulation of CURRENT POSITION i.e. currPos
     */
    @Override
    public void moveToStart() 
    {
        currPos = 0;
    }
    
    @Override
    public void moveToEnd()
    {
        currPos = listSize;
    }
    
    @Override
    public void prev()
    {
        if(currPos != 0)
            currPos -- ;
    }
    
    @Override
    public void next()
    {
        if( currPos < listSize)
            currPos ++ ;
    }
    
    @Override
    public int length() 
    {
        return listSize;
    }
    
    @Override
    public int currPos()
    {
        return currPos;
    }
    
    @Override
    public boolean isAtEnd()
    {
        return currPos == listSize;
    }
    
    @Override
    public boolean moveToPos(int pos)
    {
        if (pos < 0 || pos >listSize)       //can't access out of list position
            return false;
        currPos = pos;
        return true;
    }
    
    @Override
    public Object getValue()
    {
        if(currPos < 0 || currPos > listSize)   //No current element as CURRENT POSITION is out of the list
            return null;
        return listArray[currPos];
    }

    
}
