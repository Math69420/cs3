//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public abstract class Drawable implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	public Drawable()
	{
		setPos(5,5);
		setWidth(5);
		setHeight(5);
	}

	public Drawable(int x, int y)
	{



	}

	public Drawable(int x, int y, int w, int h)
	{



	}

	public void setPos(int x, int y)
	{



	}
	
	public void setX( int x )
	{


	}
	
	public void setY( int y )
	{


	}

	public void setWidth(int w)
	{


	}
	
	public void setHeight(int h)
	{


	}
	
	public int getX()
	{
		return 0;
	}
	
	public int getY()
	{
		return 0;
	}	

	public int getWidth()
	{
		return 0;
	}	
	
	public int getHeight()
	{
		return 0;
	}
	
	public abstract void draw(Graphics window);
	
	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}