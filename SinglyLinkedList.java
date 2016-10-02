/*
 *  Java Program to Implement Singly nextNodeed List
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

    public void setNextNode(Node n)
    {
        nextNode = n;
    }

    public void setData(int d)
    {
        data = d;
    }

    public Node getNextNode()
    {
        return nextNode;
    }

    public int getData()
    {
        return data;
    }
}

class LinkedList
{
    Node startNode;
    Node endNode ;
    int  listSize ;

    public LinkedList()
    {
        startNode = null;
        endNode = null;
        listSize = 0;
    }

    public boolean isEmpty()
    {
        return startNode == null;
    }

    public int getlistSize()
    {
        return listSize;
    }

    /*  Function to insert an element at the beginning  */
    public void insertAtStartNode(int value)
    {
        Node newNode = new Node(value, null);
        if(startNode == null)
        {
            startNode = newNode;
            endNode = startNode;
        }
        else
        {
            newNode.setNextNode(startNode);
            startNode = newNode;
        }
        listSize++;
    }

    /*  Function to insert an element at end Node  */
    public void insertAtEndNode(int value)
    {
        Node newNode = new Node(value,null);
        if(startNode == null)
        {
            startNode = newNode;
            endNode = startNode;
        }
        else
        {
            endNode.setNextNode(newNode);
            endNode = newNode;
        }
        listSize++;
    }

    /* Function to insert an element at position. Finding position Time complexity O(n)*/
    public void insertAtPosition(int value , int position)
    {
        Node midNode = new Node(value, null);
        Node beginNode = startNode;
        position = position - 1 ;
        for (int i = 1; i < listSize; i++)
        {
            if (i == position)
            {
                Node endNode = beginNode.getNextNode() ;
                beginNode.setNextNode(midNode);
                midNode.setNextNode(endNode);
                break;
            }
            beginNode = beginNode.getNextNode();
        }
        listSize++;
    }

    /*  Function to delete an element at position. Finding Position Time complexity O(n)  */
    public void deleteAtPosition(int position)
    {
        if (position == 1)
        {
            startNode = startNode.getNextNode();
            listSize--;
            return ;
        }
        if (position == listSize)
        {
            Node myStartNode = startNode;
            Node beforeEndNode = startNode;
            while (myStartNode != endNode)
            {
            	beforeEndNode = myStartNode;
            	myStartNode = myStartNode.getNextNode();
            }
            endNode = beforeEndNode;
            endNode.setNextNode(null);
            listSize --;
            return;
        }
        Node currentNode = startNode;
        position = position - 1 ;
        for (int i = 1; i < listSize - 1; i++)
        {
            if (i == position)
            {
                Node tempNode = currentNode.getNextNode();
                tempNode = tempNode.getNextNode();
                currentNode.setNextNode(tempNode);
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        listSize-- ;
    }
    
    public void display()
    {
        if (listSize == 0)
        {
            System.out.print("List is empty\n");
            return;
        }
        if (startNode.getNextNode() == null)
        {
            System.out.println(startNode.getData() );
            return;
        }
        Node currentNode = startNode;
        while (currentNode.getNextNode() != null)
        {
            System.out.print(currentNode.getData()+ "->");
            currentNode = currentNode.getNextNode();
        }
        System.out.print(currentNode.getData()+ "\n");
    }
}

public class SinglyLinkedList
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertAtStartNode( 1 );
        list.insertAtEndNode( 2 );
        list.insertAtPosition(99, 2); // position >= 1 and position <= list.getSize()
        list.insertAtPosition(3, 3);
        list.insertAtPosition(4, 4);
        list.deleteAtPosition(2);
        list.display();
    }
}
