//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class SortsAndSearches
{
    private long elapsed;

    public double getElapsed(){ return elapsed/1000.0; }

	//O(N)
	public int linearSearch(Comparable[] stuff,  Comparable item)
	{
		long start = currentTimeMillis();
	   int len = stuff.length;
	   for(int i= 0; i < len; i++)
	   {
	      if (stuff[i].compareTo(item)==0)
	      {
	      	elapsed = currentTimeMillis() - start;
		   	return i;
		   }
	   }
	   elapsed = currentTimeMillis() - start;
	   return -1;   //returns -1 if not found
	}

	//O(log N)
	public int binarySearch( Comparable[] stuff,Comparable item )
	{
		long start = currentTimeMillis();
	   int bot=0, top=stuff.length-1, middle;
	   while(bot<=top)
	   {
	      middle = (bot+top)/2;
	      if (stuff[middle].compareTo(item)==0)
	      {
	         elapsed = currentTimeMillis() - start;
		      return middle;
		   }
	      else
	         if(stuff[middle].compareTo(item)>0)
	            top = middle-1;
	         else
	            bot = middle+1;
	   }

	   elapsed = currentTimeMillis() - start;
	   return -1;
	}


	//N*N - Quadratic Sort
	public void bubbleSort(Comparable[] stuff)
	{
		long start = currentTimeMillis();
		Comparable temp;

		for(int i=0; i<stuff.length-1; i++)
		{
			for(int j=0; j<stuff.length-1; j++)
			{
				if( stuff[j].compareTo(stuff[j+1]) > 0 )
				{
					temp = stuff[j];
					stuff[j] = stuff[j+1];
					stuff[j+1] = temp;
				}
			}
		}
	   elapsed = currentTimeMillis() - start;
	}

	//N*N - Quadratic Sort
	public void selSort(Comparable[] stuff)
	{
		long start = currentTimeMillis();
		for(int i=0;i<stuff.length-1;i++)
		{
			int spot=i; 
			for(int j=i;j<stuff.length;j++){
				if(stuff[j].compareTo(stuff[spot])<0)
					spot=j;
			}
			if(spot==i) continue;
			Comparable save=stuff[i];
			stuff[i]=stuff[spot];
			stuff[spot]=save;
		}  
		elapsed = currentTimeMillis() - start;	  
	}		

	//N*N - Quadratic Sort
	public void insertionSort( Comparable[] stuff)
	{
		long start = currentTimeMillis();
		for(int i=1; i< stuff.length; ++i)
		{
			int bot=0, top=i-1;
			while(bot<=top)
			{
				int mid=(bot+top)/2;
				if(stuff[mid].compareTo(stuff[i])<0)
					bot=mid+1;
				else top=mid-1;
			}
			Comparable temp= stuff[i];
			for (int j=i; j>bot; --j)
			stuff[ j]= stuff[ j-1];
			stuff[bot]=temp;
		}
		elapsed = currentTimeMillis() - start;		  
	}


	//N * Log(N)   SortsAndSearches ( Recursive)
	public void mergeSort(Comparable[] stuff )
	{
		long start = currentTimeMillis();
		mergeSort(stuff, 0, stuff.length);
		elapsed = currentTimeMillis() - start;
	}

	private void mergeSort( Comparable[] stuff, int front, int back)  //O( Log N )
	{
		int mid = (front+back)/2;
		if( mid==front) return;
		mergeSort(stuff, front, mid);
		mergeSort(stuff, mid, back);
		merge(stuff, front, back);
	}

	private void merge(Comparable[] stuff, int front, int back)  //O(N)
	{
	   Comparable[] temp = new Comparable[back-front];
	   int i = front, j = (front+back)/2, k =0;
	   int mid =j;
	   while(i<mid && j<back)
	   {
	      if(stuff[i].compareTo(stuff[j])<0)
	         temp[k++]=stuff[i++];
	      else
	         temp[k++]=stuff[j++];
	   }

	   while(i<mid)
	      temp[k++]=stuff[i++];
	   while(j<back)
	      temp[k++]=stuff[j++];
	   for(i = 0; i<back-front; ++i)
	      stuff[front+i]=temp[i];
	}


	//N * Log(N)   SortsAndSearches ( Recursive)
	public void quickSort(Comparable[] stuff )
	{
	    long start = currentTimeMillis();
	    quickSort(stuff, 0, stuff.length-1);
	    elapsed = currentTimeMillis() - start;
	}


	// Sort the elements a[low], a[low+1], .., a[high]
	private void quickSort(Comparable[] stuff, int low, int high)  //O(Log N)
	{
		if (low < high)
		{
			int p = partition(stuff, low, high);
			quickSort(stuff, low, p);
			quickSort(stuff, p+1, high);
		}
	}


	//N * Log(N)   SortsAndSearches ( Recursive)
	private int partition(Comparable[] stuff, int low, int high) // O(N)
	{
		Comparable pivot = stuff[low];   //left pivot
		int bot = low-1;
		int top = high+1;

		while(bot<top)
		{
			while(stuff[--top].compareTo(pivot) > 0);
			while(stuff[++bot].compareTo(pivot) < 0);
			if(bot>=top)
				return top;
			Comparable temp = stuff[bot];
			stuff[bot] = stuff[top];
			stuff[top] = temp;
		}
		return 0;
	}
}