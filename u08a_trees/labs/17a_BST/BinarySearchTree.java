//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

//You'll need to supply any missing import statements:


public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null)
			tree = new TreeNode(val);
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);
		
		
		if(dirTest < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		
		return tree;
	}
   
   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder



	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		return 0;
	}
   
   // Complete the traversals and the toString method
   // and then each of these:
   
   //clear()

	//getNumLeaves 
      
   //getHeight
   
   //getNumNodes
   
   //isFull
	
	//search
	
	//getSmallest
	
	//getLargest
		
   //getWidth

	//remove



   // Returns a String that represents 
   // an IN-ORDER traversal of the tree.
	public String toString()
	{
		return "";
	}

	private String toString(TreeNode tree)
	{
		return "";
	}

   public void levelOrder()
   {
      levelOrder(root);
      System.out.println("\n\n");
   }

   private void levelOrder(TreeNode tree)
   {
      if(tree==null)
         return;
   	  
      Queue<TreeNode> level = new LinkedList<TreeNode>();
      level.add(tree);
      while(!level.isEmpty())
      {
         TreeNode node = level.remove();
         out.print(node.getValue() + " ");
         if(node.getLeft()!=null)
         {
            level.add(node.getLeft());
         }
         if(node.getRight()!=null)
         {
            level.add(node.getRight());
         }
      }
   }
}