class Node {            // Doubly linked list node
  private Object e;     // Value for this node
  private Node next;       // Pointer to next node in list
  private Node prev;       // Pointer to previous node

  // Constructors
  Node(Object a, Node m_next, Node m_prev) 
    { 
      e = a;  
      prev = m_prev; 
      next = m_next; 
    }
    
  Node(Link inp, Link inn) 
    { 
      prev = m_prev; 
      next = m_next; 
    }

  // Get and set methods for the data members
  public Object element() 
    { return e; }                             // Return the value
  public Object setElement(Object it) 
    { return e = it; }                        // Set element value
  public Node next() 
    { return next; }                          // Return next link
  public Node setNext(Node m_next) 
    { return next = m_next; }                 // Set next link
  public Node prev() 
    { return prev; }                          // Return prev link
  public Node setPrev(Node m_prev) 
  { return prev = m_prev; }                   // Set prev link
}
