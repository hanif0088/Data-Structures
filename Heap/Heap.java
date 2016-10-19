public class Heap 
{
	public static void main(String[] args) 
	{
		Heap myHeap = new Heap(10);
		myHeap.insert(15);
		myHeap.insert(10);
		myHeap.insert(9);
		myHeap.insert(18);
		myHeap.remove();
		
		for(int i=0; i<myHeap.currentSize; i++)
		{
			System.out.println(myHeap.heapArray[i]);
		}
	}
	
	int[] heapArray;
	int maxSize;
	int currentSize; //number of values in the heap
	
	public Heap(int myMaxSize)
	{
		this.maxSize = myMaxSize;
		currentSize = 0;
		heapArray = new int[maxSize];
	}
	
	public boolean isEmpty()
	{
		return currentSize == 0;
	}
	
	public boolean insert(int value)
	{
		if(currentSize == maxSize)
		{
			return false;
		}
		
		heapArray[currentSize] = value;
		reheapUp( currentSize );
		currentSize++;
		return true;
	}
	
	public void reheapUp(int index)
	{
		while(index > 0)
		{	
			int parent = (index-1) / 2;
			
			if(heapArray[parent] < heapArray[index])
			{
				int temp = heapArray[index];
				heapArray[index] = heapArray[parent];
				heapArray[parent] = temp;
				
				index = parent;
			}
			else
			{
				break;
			}
		}
	}
	
	public int remove()
	{
		int root = heapArray[0];
		currentSize--;
		heapArray[0] = heapArray[currentSize];
		reheapDown();
		return root;
	}
	  
	public void reheapDown()
	{
		int index = 0; //root index
		int largerChild;
		
		while(index < currentSize / 2)// while node has at least one child
		{
			int leftChild = 2 * index + 1;
		    int rightChild = 2 * index + 2;
		    
		    // rightChild < currentSize (rightChild exists?)
		    if (rightChild < currentSize && heapArray[leftChild] < heapArray[rightChild]) 
		    {
		    	largerChild = rightChild;
		    }
		    else 
		    {
		    	largerChild = leftChild;
		    }
		    
		    if ( heapArray[index] < heapArray[largerChild] )
		    {
		    	int temp = heapArray[index];
		    	heapArray[index] = heapArray[largerChild];
		    	heapArray[largerChild] = temp; 
		    	index = largerChild; // set the new root 
		    }
		    else //root >= largerChild
		    {
		    	break; // it's already balanced, no changes needed
		    }
		}		
	}
	
}
