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
   public void push(int j)
   {
	  top++;
      stackArray[top] = j;
   }

   // Deletion time complexity O(1)
   public int pop()
   {
      int value = stackArray[top];
      top--;
      return value;
   }

   public int peek()
   {
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
