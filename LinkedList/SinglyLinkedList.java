/*
 *  Java Program to Implement Singly LinkedList
 */
class Node
{
    int data;
    Node nextNode;

    public Node(int d,Node n)
    {
        data = d;
        nextNode = n;
    }
}

class LinkedList
{
    Node headNode;
    Node tailNode ;
    int  listSize ;

    public LinkedList()
    {
        headNode = null;
        tailNode = null;
        listSize = 0;
    }

    public boolean isEmpty()
    {
        return headNode == null;
    }

    /*  Function to insert an element at the beginning  */
    public void insertAtStartNode(int value)
    {
        Node newNode = new Node(value, null);
        if(headNode == null) //when the list is empty 
        {
            headNode = newNode;
            tailNode = headNode;
        }
        else
        {
            newNode.nextNode = headNode;
            headNode = newNode;
        }
        listSize++;
    }

    /*  Function to insert an element at end Node  */
    public void insertAtEndNode(int value)
    {
        Node newNode = new Node(value,null);
        if(headNode == null) //when the list is empty 
        {
            headNode = newNode;
            tailNode = headNode;
        }
        else
        {
            tailNode.nextNode = newNode;
            tailNode = newNode;
        }
        listSize++;
    }

    /* Function to insert an element at position. Time complexity Insert Operation O(1). Finding the node at nth index O(n)*/
    public void insertAtPosition(int value , int position)
    {
    	if (position <= 0 || position > listSize)
    	{
    		System.out.println("Invalid position!");
    		return;
    	}
    	else if (position == 1)
    	{
    		insertAtStartNode(value);
    		return;
    	}
    	
        Node targetNode = new Node(value, null);
        Node startNode = headNode;
        position = position - 1 ;
        for (int i = 1; i < listSize; i++) // i starts from 1 to skip the start node
        {
        	//Stop at the previous node of the target node that needs to be inserted
            if (i == position)
            {
                Node endNode = startNode.nextNode ;
                startNode.nextNode = targetNode;
                targetNode.nextNode = endNode;
                listSize++;
                break;
            }
            startNode = startNode.nextNode;
        }
    }

    /* Function to delete an element at position. Time complexity delete Operation O(1). Finding the node at nth index O(n) */
    public void deleteAtPosition(int position)
    {
    	if (position <= 0 || position > listSize)
    	{
    		System.out.println("Invalid position!");
    		return;
    	}
    	
    	else if (position == 1) // delete at the start node
        {
            headNode = headNode.nextNode;
            listSize--;
            return ;
        }
       
        else if (position == listSize) // delete at the end node
        {
            Node startNode = headNode;
            Node beforeTailNode = headNode;
            while (startNode != tailNode)
            {
            	beforeTailNode = startNode;
            	startNode = startNode.nextNode;
            }
            tailNode = beforeTailNode;
            tailNode.nextNode = null;
            listSize --;
            return;
        }

        Node startNode = headNode;
        position = position - 1 ;
        for (int i = 1; i < listSize - 1; i++) // i starts from 1, skip the start node and end node
        {
        	//Stop at the previous node of the target node that needs to be deleted 
            if (i == position)
            {
                Node afterTargetNode = startNode.nextNode.nextNode; //skip the target node that needs to be deleted 
                startNode.nextNode = afterTargetNode;
                listSize-- ;
                break;
            }
            startNode = startNode.nextNode;
        } 
    }
    
    // Time complexity of display and search function O(n)
    public void display()
    {
    	Node walker = headNode;
    	while(walker != null)
    	{
    		System.out.print( walker.data);
    		if ( walker.nextNode != null)
    		{
    			System.out.print("->");
    		}
    		walker = walker.nextNode;		
    	}
    	System.out.print("\n");
    }
}

public class SinglyLinkedList
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertAtStartNode(1);
        list.insertAtStartNode(2);
        list.insertAtEndNode(15);
        list.insertAtPosition(99,2);
        list.insertAtPosition(89,2);
        list.insertAtPosition(3,3);
        list.insertAtPosition(4,1);
        list.deleteAtPosition(7);
        list.display(); 
    }
}
