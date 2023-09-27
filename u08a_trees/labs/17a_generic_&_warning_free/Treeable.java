//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

public interface Treeable<T extends Comparable<T>>
{
	public Object getValue();
	public Treeable<T> getLeft();
	public Treeable<T> getRight();
	public void setValue(T value);
	public void setLeft(Treeable<T> left);
	public void setRight(Treeable<T> right);
}