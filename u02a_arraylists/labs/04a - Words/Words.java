//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

class Words
{
	private ArrayList<Word> words;

	public Words()
	{
		setWords("");
	}

	public Words(String wordList)
	{
		setWords(wordList);
	}

	public void setWords(String wordList)
	{
		String word = "";
		words = new ArrayList<Word>();
		for (int i = 0; i < wordList.length(); i++){
			if (!wordList.substring(i, i+1).equals(" ")){
				word += wordList.substring(i, i+1);
			}
			else{
				words.add(new Word(word));
				word = "";
			}
		}
		words.add(new Word(word));




	}
	
	public int countWordsWithXChars(int size)
	{
		int count=0;
		for (Word w : words){
			if (w.getLength() == size){
				count++;
			}
		}




		return count;
	}
	
	public void removeWordsWithXChars(int size)
	{

		for (int i = 0; i < words.size(); ){
			if (words.get(i).getLength() == size){
				words.remove(i);
			}
			else{
				i++;
			}
		}




	}

	public int countWordsWithXVowels(int numVowels)
	{
		int count=0;
		for (Word w : words){
			if (w.getNumVowels() == numVowels){
				count++;
			}
		}





		return count;
	}
	
	public String toString()
	{
	   return words.toString();
	}
}