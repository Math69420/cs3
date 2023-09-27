//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class Lab20aGraph extends JFrame
{
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;

	public Lab20aGraph()
	{
		super("Graphical Sort");
		setSize(WIDTH,HEIGHT);
		
		getContentPane().add(new GraphSort());
						
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Lab20aGraph run = new Lab20aGraph();
	}
}