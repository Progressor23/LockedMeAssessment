package com.Assessment;
import java.io.File; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList; 
import java.util.Scanner;

public class Assessment {
	static String Path = "D:\\Java Project"; 
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int choice;
		System.out.println("\n\t**LockedMe.com-Assessment**\n");
		System.out.println("Author:Pranav M L");
		System.out.println("For issues please contact pranavml4202@gmail.com,Ph.no:7996611459");
	
		do
		{
			Menu();
			System.out.println("\n Please Enter your choice:"); 
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:displayFiles();
			break;
			case 2:Scanner sc1=new Scanner(System.in);
			int option;
			System.out.println("\tPress 1 for adding files to root directory");
			System.out.println("\tPress 2 for deleting files from root directory");
			System.out.println("\tPress 3 for searching the files\n");
			System.out.println("\tPress 4 for to go back to Main Menu\n");
			System.out.println("Enter the option:");
			option=sc1.nextInt();
			switch(option)
			{
			case 1:addFiles();
			break;
			case 2:deleteFiles();
			break;
			case 3:searchFiles();
			break;
			case 4: Menu();
			break;
			}
			break;
			case 3: ExitMenu();
			break;
			default:System.out.println("Error.Please choose the correct choice");
			}
			}
			while(choice>0 && choice <4);
			
	}
	
	public static void Menu()
	{
	System.out.println("\n\t*** Menu***\n\t");
	System.out.println("\t1=Display all the files in ascending order");
	System.out.println("\t2=File Operations Menu");
	System.out.println("\t3=Exit");
	} 
	
	
	public static void displayFiles()
	{
	try {
	File fileFolder = new File(Path);
	File[] FileList = fileFolder.listFiles();
	if(FileList.length==0)
	{
	System.out.println("No Files exist");
	}
	else
	{
	for(File l:FileList)
	{
	System.out.println(l.getName());
	}
	 }
	 }
	catch(Exception Ex)
	{
	System.out.println("Some Error has occured.");
	}
	}
	
	
	public static void addFiles() 
	{
	try
	{
	Scanner sc = new Scanner(System.in);
	String fileName = null;
	System.out.println("Enter the filename: ");
	fileName = sc.nextLine();
	File f1 = new File (Path+"\\"+fileName);// adding a file to directory
	int linesCount;
	PrintWriter pw=new PrintWriter(f1);
	System.out.println("Enter how many lines in the file");
	linesCount = Integer.parseInt(sc.nextLine());
	
	for(int i=1;i<=linesCount;i++)
	{
	System.out.println("Enter the file line : ");
	pw.write(sc.nextLine()+"\n");
	}
	System.out.println("File created successfully.");
	pw.close(); 
	//obj.close();
	}
	catch(Exception t)
	{
	System.out.println("Some error has occcured.");
	}
	} 
	
	
	/*This method will delete the file based on the user input if it exists*/
	public static void deleteFiles()
	{
	Scanner sc = new Scanner(System.in);
	try
	{
	String fileName;
	System.out.println("Enter the file name to be deleted");
	fileName = sc.nextLine();
	File file = new File(Path+"\\"+fileName);
	if(file.exists())
	{
	file.delete();
	System.out.println("File deleted SuccessFully : "+fileName);
	}
	else
	System.out.println("FNF (File not found)");
	}
	catch(Exception ex)
	{
	System.out.println("Some Error has occured.");
	}
	}
	public static void searchFiles()
	{
	Scanner sc = new Scanner(System.in);
	try
	{
	String requiredFile;
	System.out.println("Enter the file name to be Searched");
	requiredFile = sc.nextLine();
	File folder = new File(Path);
	File[] FileList = folder.listFiles();
	LinkedList<String> filenames = new LinkedList<String>();
	for(File l:FileList)
	filenames.add(l.getName());
	if(filenames.contains(requiredFile))
	System.out.println("File present in "+Path);
	else
	System.out.println("FNF (File not found)");
	}
	catch(Exception et)
	{
	System.out.println("Some Error has occured.");
	}
	}
	public static void ExitMenu() {
		System.out.println("Exiting LockedMe");
		System.exit(0);
		
	}
	
	 
}

