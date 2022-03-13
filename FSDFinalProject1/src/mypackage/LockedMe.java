package mypackage;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe 
{	
	static final String projectFilePath="C:\\KIRAN\\FinalProject_Phase1";
	public static void displayMenu()
	{
		System.out.println("==============================================");
		System.out.println("\tWelcome To LockedMe.com Secure App");
		System.out.println("\tDeveloped By: KIRAN SHIRAGUMPI");
		System.out.println("==============================================");
		System.out.println("\t1.Display All Files");
		System.out.println("\t2.Add New File");
		System.out.println("\t3.Delete File");
		System.out.println("\t4.Search File");
		System.out.println("\t5.Exit");
		System.out.println("==============================================");
	}

	public static void getAllFiles() 
	{
		File folder=new File(projectFilePath);
		File[] listOfFiles=folder.listFiles();
		if(listOfFiles.length>0)
		{
			System.out.println("Files List Is Below:\n");
			for(var l:listOfFiles)
			{
			System.out.println(l.getName());
			}
		}
		
		else
		{
			System.out.println("Folder Is Empty");
		}
	}

	public static void createFiles() 
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			String fileName;
			System.out.println("Enter File Name:");
			fileName=sc.nextLine();
			int linesCount;
			System.out.println("Enter How Many Lines In The File:");
			linesCount=Integer.parseInt(sc.nextLine());
			FileWriter fw=new FileWriter(projectFilePath+"\\"+fileName);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter File Line:");
				fw.write(sc.nextLine()+"\n");
			}
			System.out.println("File Created Successfully");
			fw.close();
		}
		catch(Exception Ex)
		{
			
		}
		
	}

	public static boolean checkFilesExists(String fileName)
	{
		ArrayList<String> allFilesNames=new ArrayList<String>();
		File folder = new File(projectFilePath);
		File[] listOfFiles=folder.listFiles();
		if(listOfFiles.length>0)
		{
			for(var l:listOfFiles)
			{
			allFilesNames.add(l.getName());
			}
		
		}
	
		return allFilesNames.contains(fileName);
		
	}
	public static void deleteFiles() 
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		String fileName;
		System.out.println("Enter File Name To Be Deleted:");
		fileName=sc.nextLine();
		File f=new File(projectFilePath+"\\"+fileName);
		if(checkFilesExists(fileName))
		{
			f.delete();
			System.out.println("File Deleted Successfully");
		}
		else 
			{
			System.out.println("File Does not Exist");
		
			}
			
		}
		catch(Exception Ex)
			{
			System.out.println("Unable To Delete File.Please contact Admin");
			}
	}	
			
	
	public static void searchFiles() 
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			String fileName;
			System.out.println("Enter File Name To Be Searched:");
			fileName=sc.nextLine();
			
			if(checkFilesExists(fileName))
			{
				System.out.println("File Is Available");
			}
			else
			{
				System.out.println("File Is Not Available");
			}
		}
		catch(Exception Ex)
			{
			
			}
	}
	
}
