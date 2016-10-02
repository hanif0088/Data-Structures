class Node
{
	Node right;
	Node left;
	int  value;
	
	Node(int value)
	{
		this.value = value;
	}
}

public class BST 
{	
	public static void main(String[] args) 
	{
		BST myBST = new BST();
		myBST.insert(myBST.rootNode, 40);
		myBST.insert(myBST.rootNode, 20);
		myBST.insert(myBST.rootNode, 30);
		System.out.print( myBST.search(myBST.rootNode, 30) );
		myBST.printTreeInOrder(myBST.rootNode);
		myBST.printTreePreOrder(myBST.rootNode);
	}
	
	public Node rootNode = null;
	
	//insert Time complexity O(nlogn)
	public void insert(Node rootNode, int value)
	{
		if( rootNode == null)
		{
			this.rootNode = new Node(value);
		}
		else if( value > rootNode.value)
		{
			if( rootNode.right != null)
			{
				insert(rootNode.right,value);
			}
			else
			{
				rootNode.right = new Node(value);
			}
		}
		else if( value < rootNode.value)
		{
			if( rootNode.left != null)
			{
				insert(rootNode.left,value);
			}
			else
			{
				rootNode.left = new Node(value);
			}
		}
	}

	//search Time complexity O(nlogn)
	public boolean search(Node rootNode, int value)
	{
		if(rootNode == null)
		{
			return false;
		}
		else if( rootNode.value == value)
		{
			return true;
		}
		else
		{
			if( value > rootNode.value)
			{
				return search(rootNode.right,value);
			}
			else //if( value < rootNode.value)
			{
				return search(rootNode.left,value);
			}	
		}
	}
	
	public void printTreeInOrder(Node rootNode)
	{
		if( rootNode != null)
		{
			printTreeInOrder(rootNode.left);
			System.out.print( rootNode.value +" ");
			printTreeInOrder(rootNode.right);
		}
	}
	
	public void printTreePreOrder(Node rootNode)
	{
		if( rootNode != null)
		{
			System.out.print( rootNode.value +" ");
			printTreeInOrder(rootNode.left);
			printTreeInOrder(rootNode.right);
		}
	}
	
	public void printTreePostOrder(Node rootNode)
	{
		if( rootNode != null)
		{
			printTreeInOrder(rootNode.left);
			printTreeInOrder(rootNode.right);
			System.out.print( rootNode.value +" ");
		}
	}
	
}

