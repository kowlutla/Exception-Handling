package ageException;

import java.io.*;
public class AgeExceptionDemo {

	public static void main(String[] args) throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter no of voter details: ");
		int n=Integer.parseInt(br.readLine());
		Voter[]array=new Voter[n];
		
		System.out.println("Enter Voter details: ");
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Voter "+(i+1)+" Details: ");
			String name=br.readLine();
			int age=Integer.parseInt(br.readLine());
			array[i]=new Voter(name,age);
		}
		
		FileWriter fw=new FileWriter(new File("voter.txt"),true);
		BufferedWriter bw=new BufferedWriter(fw);
		
		
		for(int i=0;i<n;i++)
		{
			if(array[i].age>=18)
			{
				bw.write(array[i]+"\n");
			}
			else
			{
				try {
					throw new AgeException(array[i].name);
				} catch (AgeException e) {
					System.out.println(e);
				}
			}
		}
		bw.close();
		fw.close();
		
	}

}

class Voter
{
	String name;
	int age;
	public Voter(String name,int age)
	{
		this.age=age;
		this.name=name;
	}
	@Override
	public String toString() {
		return "Voter [name=" + name + ", age=" + age + "]";
	}
	
}

class AgeException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgeException(String msg)
	{
		super(msg+" age is lessthan 18");
	}
}
