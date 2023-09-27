//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class GraphSort extends JPanel
{
	private Font font;
	private SortsAndSearches sortSearchTester;
	private Comparable[] list;	
	private double[] times;

	public GraphSort()
	{
		font = new Font("TAHOMA",Font.BOLD,10);
		
		sortSearchTester = new SortsAndSearches();
		times = getTimes();

		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void paintComponent( Graphics window )
	{
		super.paintComponent(window);
		
		window.setColor(Color.blue);
		window.setFont(font);
		window.drawString("Linear Search",10,100);		
		window.drawString("Binary Search",10,130);
		window.drawString("Merge Sort",10,160);
		window.drawString("Quick Sort",10,190);
		window.drawString("Insertion Sort",10,220);
		window.drawString("Selection Sort",10,250);
		window.drawString("Bubble Sort",10,280);
		
		//draw the red bars for each sort
		
		
		
		
				
	}
	
	private double[] getTimes()
	{
		double[] times = new double[7];
		try{
			writeRandomFile();
			loadFromFile();
			sortSearchTester.linearSearch(list, 75000);
			times[0] = sortSearchTester.getElapsed();

			//log the times for each sort and each search
			
			
			
			
			
			
			
			


		}
		catch(Exception e)
		{
			
		}		
		return times;
	}
	
	public void writeRandomFile() throws IOException
	{
		//Use PrintWriter to write 10,000 random #s to file lab20.dat
		PrintWriter out = new PrintWriter(new File("lab20.dat"));
		out.println(80000);
		
		
		//write out x number of items to the file
		
		
		
		out.close();
	}

	public void loadFromFile(  ) throws IOException
	{
		Scanner file = new Scanner( new File("lab20.dat"));
		int size = file.nextInt();
		list = new Comparable[size];
		System.out.println("size "+list.length);
		for( int i = 0; i < list.length; i++)
		{
			list[i] = file.nextInt();
		}
		file.close();
	}	
}