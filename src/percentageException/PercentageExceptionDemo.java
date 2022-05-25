/**
Create an user defined exception called PercentageException with necessary
implementation. You have to create a Student class with name, age and
percentage with necessary methods. If student percentage is below 50, then
you have to raise an exception (PercentageException). If no exception found,
then you have to write student name, age, percentage into file 
 */
package percentageException;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author apiiit-rkv
 *
 */
public class PercentageExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try 
		{
			
			BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter no of student: ");
			int n=Integer.parseInt(sc.readLine());
			Student []array=new Student[n];
			System.out.println("Enter Student Details: ");
			for(int i=0;i<n;i++)
			{
				System.out.println("Person "+(i+1)+" details: ");
				String name=sc.readLine();
				int age=Integer.parseInt(sc.readLine());
				double percentage=Double.parseDouble(sc.readLine());
				
				array[i]=new Student(name,age,percentage);
			}
			
			File file=new File("data.txt");
			FileWriter fw=new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			
			for(int i=0;i<n;i++)
			{
				if(array[i].percentage<50)
				{
					try {
						throw new PercentageException(array[i].name);
					} catch (PercentageException e) {
						// TODO Auto-generated catch block
						//System.out.println(e);
					}
				}
				else
				{
					bw.write(array[i]+"\n");
				}
			}
			
			bw.close();
			fw.close();
			
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		catch(IOException e)
		{
			System.out.println("Io Exception ");
		}

	}

}

class Student
{
	 String name;
	 int age;
	 double percentage;
	
	public Student(String name,int age,double percentage)
	{
		this.age=age;
		this.name=name;
		this.percentage=percentage;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", percentage=" + percentage + "]";
	}
	
}

class PercentageException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PercentageException(String d)
	{
		System.out.println(d+" is LessThan cutoff ");
	}

	
	

	
}


