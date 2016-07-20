//The virtual functions of stack implementations
//ADT of Stack class

public interface Stack_Interface
  {
      //Reinitialize
      public void clear();
      
      //Push element a into the stack
      public boolean push(Object a);
      
      //Remove and return top element of the stack
      public Object pop();
      
      //Return top element of the stack
      public Object peek();
      
      //Return number of elements in the list
      public int length();
  }    
