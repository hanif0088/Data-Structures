/* 
 * COMP 2270 Data Structures
 * Implementing Stack using an Array 
 */

public class MyStack
{
   private int maxSize;
   private int[] stackArray;
   private int top;

   public MyStack(int s)
   {
      maxSize = s;
      stackArray = new int[maxSize];
      top = -1;
   }

   //Insertion time complexity O(1)
   public boolean push(int dataIn)
   {
      if(top == maxSize -1 )
      {
          System.out.println("Stack overflown!");
          return false;
      }
	  
      top++;
      stackArray[top] = dataIn;
      return true;
   }

   // Deletion time complexity O(1)
   public int pop()
   {
	  if( top == -1 )
	  {
              System.out.println("Stack underflown!");
              return -999;
	  }
	  
          int dataOut = stackArray[top];
          top--;
          return dataOut;
   }

   public int stackTop()
   {
	   if( top == -1 )
	   {
               System.out.println("Stack underflown!");
	       return -999;
 	   }
	  
           return stackArray[top];
   }
   
   public boolean isEmpty()
   {
      return (top == -1);
   }
	
   public boolean isFull()
   {
      return (top == maxSize - 1);
   }

   int stackCount()
   {
      return (top+1);
   }
   
   public static void main(String[] args)
   {
      MyStack myStack = new MyStack(10);
      myStack.push(10);
      myStack.push(20);
      myStack.push(30);
      myStack.push(40);
      myStack.push(50);

	  // Access time complexity O(n) and Search time complexity O(n)
      while (!myStack.isEmpty())
      {
         int value = myStack.pop();
         System.out.print(value + " ");
      }
   }
}
