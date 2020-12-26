package emailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String companySuffix = "cummins.com";
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 128;
	
	//********************************************Constructor**********************************************
	public Email(String firstName, String lastName) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		System.out.println("Email Created: " 
				+ this.firstName 
				+ " " 
				+ this.lastName);
		
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: " + this.password);
		email = firstName.toLowerCase() 
				+ "." 
				+ lastName.toLowerCase() 
				+ "@" +department 
				+ "."
				+ companySuffix;
		
		System.out.println("Your Email is: " + this.email);
	}
	
	//*******************************************set department******************************************
	//method that allows user to select department
	private String setDepartment() {
		// ask user to select their department
		System.out.print("Departnemt Codes: \n" 
				+ "1 for Sales\n" 
				+ "2 for Development \n" 
				+ "3 for Accounting \n"
				+ "0 for None \n"
				+ "Enter Code: ");
		Scanner in = new Scanner(System.in);
		// store user choice in variable
		int depChoice = in.nextInt();
		
		if (depChoice == 1) 
		{
			return "sales";
		} else if (depChoice == 2) 
		{
			return "dev";
		} else if (depChoice == 3) 
		{
			return "acct";
		} else {
			return "";
		}
	}//end setDepartment
	
	//****************************************random password ********************************************
	private String randomPassword(int length)
	{
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		char[] password = new char[length];
		for(int i = 0; i < length; i++)
		{
			//generate a random number within the length of the password set
			int rand = (int) (Math.random()*passwordSet.length());
			//store that random character into the password array
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}//end random Password
	//************************************Setters******************************
	public void setMailboxCapacity(int capacity)
	{
		this.mailboxCapacity = capacity;
	}
	public void setAlternateEmail(String email)
	{
		this.alternateEmail = email;
	}
	public void changePassword(String pass)
	{
		this.password = pass;
	}
	//************************************Getters******************************
	public int getMailboxCapacity()
	{
		return this.mailboxCapacity;
	}
	public String getAlternateEmail()
	{
		return this.alternateEmail;
	}
	public String getPassword()
	{
		return this.password;
	}
}