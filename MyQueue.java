/*
 * Java Program to Implement Queue
 * front<=========<=rear<=
 */

class ArrayQueue
{
    int[] queue ;
    int front, rear, maxSize, length;

    public ArrayQueue(int size)
    {
        maxSize = size;
        length = 0;
        queue = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty()
    {
        return front == -1;
    }

    public boolean isFull()
    {
        return front==0 && rear == maxSize -1 ;
    }

    public int getSize()
    {
        return length ;
    }

    /*  Function to check the front element of the queue */
    public int peek()
    {
        if (isEmpty())
        {
        	System.out.println("Queue underflown");
        	return -999;
        }
        else
        {
        	return queue[front];
        }
    }

    public void enqueue(int i)
    {
        if (rear == -1)
        {
            front = 0;
            rear = 0;
            queue[rear] = i;
        }
        else if (rear + 1 >= maxSize)
        {
        	System.out.println("Queue overflown");
        }
        else if ( rear + 1 < maxSize)
        {
        	rear++;
            queue[rear] = i;
        }
        length++ ;
    }
    
    /*  Function to remove front element from the queue. Time complexity O(1) */
    public int dequeue()
    {
        if (isEmpty())
        {
        	System.out.println("Queue underflown");
        	return -999;
        }
        else
        {
            length-- ;
            int value = queue[front];
            if ( front == rear)
            {
                front = -1;
                rear = -1;
            }
            else
            {
                front++;
            }
            return value;
        }
    }

    public void display()
    {
        if (length == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = front; i <= rear; i++)
        {
            System.out.print(queue[i]+" ");
        }
    }
}

public class MyQueue
{
    public static void main(String[] args)
    {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue( 1);
        queue.enqueue( 2);
        queue.enqueue( 3);
        queue.enqueue( 4);
        queue.enqueue( 5);
        queue.dequeue();
        queue.display();
    }
}
