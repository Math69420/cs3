//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

package BlackJack;

import java.io.File;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import BlackJack.Card;

public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;
	private int width;
	private int height;
	private Image image;


  	//add more constructors


 	public Card(int f, String s, int wid, int ht)
  	{
  	   //initialize the data / instance variables
  	   
  	   
  	   
  	   
  	   String name = this.toString().replaceAll(" ","");
		try
		{
			image = ImageIO.read(new File(name+".jpg")); 
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
  	}

	// modifiers





  	//accessors






	//equals method
	
	
	
  	public abstract int getValue();


  	//toString


	public void drawCard(Graphics window, int x, int y)
	{
		window.drawImage(image,x,y,width,height,null);
	}
}