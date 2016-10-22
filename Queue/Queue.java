/*
 * COMP 2270 Data Structure
 * Java Program to Implement Queue
 * front<=========<=rear<=
 */

class Queue
{
    int[] queue ;
    int front, rear, maxSize, count;

    public Queue(int size)
    {
        maxSize = size;
        count = 0;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty()
    {
        return (count == 0);
    }

    public boolean isFull()
    {
        return (count == maxSize);
    }

    public int getSize()
    {
        return count ;
    }

    /*  Function to check the front element of the queue */
    public int queueFront()
    {
        if (count == 0)
        {
        	System.out.println("Queue is empty!");
        	return -999;
        }
        else
        {
        	return queue[front];
        }
    }

    /*  Function to check the rear element of the queue */
    public int queueRear()
    {
        if (count == 0)
        {
        	System.out.println("Queue is empty!");
        	return -999;
        }
        else
        {
        	return queue[rear];
        }
    }

    public boolean enqueue(int dataIn)
    {
    	if(count == maxSize)
    	{
        	System.out.println("Queue is full!");
    		return false;
    	}
    	
    	rear = (rear + 1) % maxSize;
    	queue[rear] = dataIn;
        count++ ;
        return true;
    }
    
    /*  Function to remove front element from the queue. Time complexity O(1) */
    public int dequeue()
    {
    	if(count == 0)
    	{
        	System.out.println("Queue is empty!");
    		return -999;
    	}
    	
    	int dataOut = queue[front];
    	front = (front + 1) % maxSize;
    	count --;
    	return dataOut;
    }
    
    public static void main(String[] args)
    {
        Queue queue = new Queue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        while ( !queue.isEmpty() )
        {
        	System.out.print( queue.dequeue() +" ");
        }
    }
}
