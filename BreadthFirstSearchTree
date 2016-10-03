package org.tree;
/*
Breadth First Search (BFS) is traversing a tree level by level 
      tree
      ----
       j         <-- level 0
     /   \
    f      k     <-- level 1
  /   \      \
 a     h      z  <-- level 2
  \
   d             <-- level 3
   
So, if we want to visit the elements level-by-level (and left-to-right, as usual), we would start at level 0 with j, 
then go to level 1 for f and k, then go to level 2 for a, h and z, and finally go to level 3 for d.
   
Step 1: Push the root node in the Queue.
Step 2: Loop until the queue is empty.
Step 3: Remove the node from the Queue.
Step 4: If the removed node has unvisited child nodes, mark them as visited and insert the unvisited children in the queue.
 */

public class BreadthFirstSearchTree 
{
	public void bfs()
	{
		//BFS uses Queue data structure
		Queue q=new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited=true;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(n))!=null)
			{
				child.visited=true;
				printNode(child);
				q.add(child);
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
}
