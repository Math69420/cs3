//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Lab17a
{
   public static void main( String args[] )
   {
      //Create a BST and add the nodes from the directions in 
      //the correct order to form the tree shown in the directions!!!
      BinarySearchTree tree;
   
   
      out.println("LEVEL ORDER");
      tree.levelOrder();
        
      out.println("IN ORDER");
      tree.inOrder();
   
      out.println("PRE ORDER");
      tree.preOrder();
   
      out.println("POST ORDER");
      tree.postOrder();
   
      out.println("REVERSE ORDER");
      tree.revOrder();
   
      out.println("\nTree as a string  " + tree.toString());
   
      out.println(tree.isFull()?"\nThe tree is full.":"\nThe tree is not full.");
      out.println(tree.search(100)?"The tree contains 100!":"The does not contain 100!"); 
      out.println(tree.search(114)?"The tree contains 114!":"The does not contain 114!");
      
      out.println("\nNumber of nodes is " + tree.getNumNodes());
      out.println("\nNumber of leaves is " + tree.getNumLeaves());
      out.println("\nNumber of levels is " + tree.getNumLevels());
      out.println("\nTree height is " + tree.getHeight());
      out.println("The smallest tree node " + tree.getSmallest());   
      out.println("The largest tree node " + tree.getLargest());
      out.println("\nTree width / diameter is " + tree.getWidth());
      
      
      out.println("\n\n\nLevel order traversal is extra credit, but removal is not:");
                  
      out.println("\n\n\nTree before removing any nodes - using level order traversal.");
      tree.levelOrder();
      
      tree.remove(90);
      out.println("\nTree after removing 90.");
      tree.levelOrder();
      
      tree.remove(70);
      out.println("\nTree after removing 70.");
      tree.levelOrder();
            
      tree.remove(85);
      out.println("\nTree after removing 85.");
      tree.levelOrder();
      
      tree.remove(98);
      out.println("\nTree after removing 98.");
      tree.levelOrder();
      
      tree.remove(80);
      out.println("\nTree after removing 80.");
      tree.levelOrder();
            
      tree.remove(120); 
      out.println("\nTree after removing 120.");
      tree.levelOrder();
            
      tree.remove(100);                
      out.println("\nTree after removing 100.");
      tree.levelOrder();   
      
      tree.clear();
      tree.levelOrder();
      
   }
}