//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Queue;
import java.util.LinkedList;
import static java.lang.System.*;

public class BinarySearchTree<T extends Comparable<T>>
{
	private TreeNode<T> root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void makeEmpty(){
		root = null;
	}

	public void add(T val)
	{
		root = add(val, root);
	}

	private TreeNode<T> add(T val, TreeNode<T> tree)
	{
	   if(tree == null)
			tree = new TreeNode<T>(val);
		
		T treeValue = tree.getValue();
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
		if(tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add in pre, post, level, and rev order traversals
	
	
	
	

	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
			return 1+getNumLevels(tree.getLeft());
		else
			return 1+getNumLevels(tree.getRight());
	}

	
	//add in numLeaves, width, height, numNodes, ifFull etc
	
	
	


	public String toString()
	{
		return toString(root);
	}

	private String toString(TreeNode tree)
	{
	   if(tree==null)
	      return "";
	   else return "" + toString(tree.getLeft())+ " " + tree.getValue() + " "  + toString(tree.getRight());
	}
}