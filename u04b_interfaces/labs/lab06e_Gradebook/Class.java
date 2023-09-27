//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class()
	{
		name="";
		studentList=new Student[0];
	}
	
	public Class(String name, int stuCount)
	{

	
	}
	
	public void addStudent(int stuNum, Student s)
	{


	}
	
	public void sort()
	{
		
	}
	
	public String getClassName()
	{
	   return "";	
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;



		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return 0.0;
	}

	public double getStudentAverage(String stuName)
	{



		return 0.0;
	}
	
	public String getStudentName(int stuNum)
	{
		return "";
	}

	public String getStudentWithHighestAverage()
	{
		return "";
	}

	public String getStudentWithLowestAverage()
	{
		return "";
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";





		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";




		return output;
	}  	
}