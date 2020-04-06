package Userprogram;

import java.util.Scanner;

public class mainprogram {

	public static void main(String args[])
	{
		String firstname,lastname,password,emailid;
		String contactNo;
				Scanner kb=new Scanner(System.in);
		while (true)
		{
				System.out.println("enter your first name:");
		 firstname=kb.next();
		
		boolean firstnameflag=Validation.firstnameValidation(firstname);
		if(!firstnameflag)
			System.out.println("first letter should be capital!");
		else
			break;
		}
		System.out.println("enter your last name:");
		lastname=kb.next();
		while(true)
		{
		System.out.println("enter your email id");
		emailid=kb.next();
		boolean emailFlag=Validation.validateeamilId(emailid);
		if(!emailFlag)
			System.out.println("enter a valid email account!");
		else 
			break;
		}
		while(true)
		{
			System.out.println("enter your password");
			password=kb.next();
			boolean passFlag=Validation.validatepassword(password);
			if(!passFlag)
				System.out.println("password should be equal or greater than 6 must conatain uppercase and lowercase characters!");
			else
				break;
		}
		
		while(true)
		{
			System.out.println("enter your contactNo");
			contactNo=kb.next();
		boolean contactNoFlag=Validation.contactNumberValidate(contactNo);
		if(!contactNoFlag)
			System.out.println("Number should be of 10 digits!");
		else
			break;
		}
		
		
		Userr usr=new Userr();
		System.out.println("your userId is"+usr.getUserId());
		usr.setUserFirstName(firstname);
		usr.setUserLastName(lastname);
		usr.setContactNumber(Long.parseLong(contactNo));
		usr.setEmailId(emailid);
		usr.setUserPassword(password);
		System.out.println(usr);
	}
}