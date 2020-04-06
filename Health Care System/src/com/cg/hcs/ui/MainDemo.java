package com.cg.hcs.ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.cg.hcs.bean.*;
import com.cg.hcs.services.*;
import com.cg.hcs.validation.*;


import com.cg.hcs.exception.*;

public class MainDemo {
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		String testName,centerName;

		String firstname,lastname,password,emailid;
		String contactNo;
		
		ArrayList<User> Customer=new ArrayList<User>();
		User usr=new User();
	
		ServiceImplementation s=new ServiceImplementation();
		
		List<Test> testArray=new ArrayList<Test>();
		
		Test t1=new Test("Blood Test");
		Test t2=new Test("X-Ray");
		Test t3=new Test("Urine Test");
		Test t4=new Test("Blood Sugar Test");
		testArray.add(t1);
		testArray.add(t2);
		testArray.add(t3);
		testArray.add(t4);
		
		List<DiagnosticCenter> centerArray=new ArrayList<DiagnosticCenter>();
		DiagnosticCenter d1=new DiagnosticCenter("Gariahat",testArray);
		DiagnosticCenter d2=new DiagnosticCenter("Kestopur",testArray);
		DiagnosticCenter d3=new DiagnosticCenter("Beleghata",testArray);
		DiagnosticCenter d4=new DiagnosticCenter("Joramandir",testArray);
		
		centerArray.add(d1);
		centerArray.add(d2);
		centerArray.add(d3);
		centerArray.add(d4);
		DiagnosticCenter dc=new DiagnosticCenter();
		dc.setListOfTests(testArray);
	
		
		//****************************Admin*************************//
		
		while(true)
		{
			System.out.println("Log in as:\n1.Admin\n2.Customer");
			int log= kb.nextInt();
			if(log==1)
			{
				List<Admin> admin=new ArrayList<Admin>();
				HashMap<Admin, String> adminHash = new HashMap<>();
				
				Admin u1=new Admin("Meghna","Admin","meghna@gmail.com",8967330644L,"m@1998",centerArray);
				Admin u2=new Admin("Neha","Admin","neha@gmail.com",8013805556L,"n@1996",centerArray);
				Admin u3=new Admin("Karishma","Admin","karishma@gmail.com",8109993685L,"k@1998",centerArray);
				Admin u4=new Admin("Nikhil","Admin","nikhil@gmail.com",9768519113L,"ni@1998",centerArray);
				
				admin.add(u1);
				adminHash.put(u1,"Megx123");
				admin.add(u2);
				adminHash.put(u2,"Neha123");
				admin.add(u3);
				adminHash.put(u3,"Kari123");
				admin.add(u4);
				adminHash.put(u4,"Niki123");
				
				while(true) {
				System.out.println("enter User Id: ");
				String id=kb.next();
				System.out.println("Enter Password: ");
				String pass=kb.next();
				
				if(adminHash.containsValue(id) && pass.equals(u1.getUserPassword()))
				{
					System.out.println("WELCOME ADMIN");
				}
				else
				{
					System.out.println("Enter Correct User Name And Password..");
					break;
				}
				
			while(true)
			{
			System.out.println("\n1.Show List of all diagnostic centers along with the tests done\n2.Add Diagnostic Center\n3.Add Test\n4.Remove Diagnostic Center\n5.Remove Test\n6.Exit");
			int option=kb.nextInt();
			
			switch(option) 
				{
							case 1:	System.out.println("Center names with Test names are: ");
							
							for(DiagnosticCenter d:centerArray) {
								System.out.println("Center Id: "+d.centerId+" Center name: "+d.centerName+"\nThe tests done here are: ");
								
								for(Test t:testArray) {
									
									System.out.println(t.testId+" "+t.testName);
									}
								System.out.println("\n");
							}
							break;
								
							case 2:System.out.println("Enter the Diagnostic center to add in the list:  ");
								centerName=kb.next();
								
								try {
									ValidateImplementation.DiagnosticCenterValidate(centerName);
									s.addCenter(centerName,testArray,centerArray);
									System.out.println("After adding the center list is: ");
									for(DiagnosticCenter d:centerArray) {
									System.out.println(d.centerId+" "+d.centerName);
									}
									break;
									}
								catch(DiagnosticCenterNameException e) {
									System.out.println(e);
								}
								break;
								
							case 3:System.out.println("Enter the Test name to add in the list: ");
								testName=kb.next();
								try {
									ValidateImplementation.TestNameValidate(testName);
									s.addTest(testName,testArray);
									for(Test t:testArray) {
										
									System.out.println(t.testId+" "+t.testName);
									}
								}
								catch(TestNameException e) {
									System.out.println(e);
								}
								break;
								
							case 4:System.out.println("Enter the Center Id to remove the test: ");
						       String centerId=kb.next();
						       s.removeCenter(centerId, centerArray);
						       System.out.println("After removing the center list is: ");
						       for(DiagnosticCenter d:centerArray) {
									System.out.println(d.centerId+" "+d.centerName);
								}
								break;
								
							case 5:System.out.println("Enter the test Id to remove the test: ");
							       String testId=kb.next();
							       s.removeTest(testId, testArray);
							       System.out.println("After removing the test list is: ");
							       for(Test t:testArray) {
										System.out.println(t.testId+" "+t.testName);
									}
								break;
								
							case 6:System.out.println("Exited...");
							       System.exit(0);
								
							default: System.out.println("Please enter correct option...");
									break;
					}
				  }
				}
			}
			
			
			//*************************Customer Details************************//
			
			else if(log==2)
			{
				while(true)
				 {
				System.out.println("Press 1 for REGISTER  "
						           +"Press 2 for LOGIN");
				int opt=kb.nextInt();
				
		if(opt==1)
		{
			while (true)
			{
			   System.out.println("enter your first name:");
			 firstname=kb.next();
			
			boolean firstnameflag=CustomerValidation.firstnameValidation(firstname);
			if(!firstnameflag)
				System.out.println("first letter should be capital!");
			else
				break;
			}
			System.out.println("enter your last name:");
			lastname=kb.next();
			while(true)
			{
			System.out.println("enter your email id:");
			emailid=kb.next();
			
			
			boolean emailFlag=CustomerValidation.validateeamilId(emailid);
			if(!emailFlag)
				System.out.println("enter a valid email account!");
			else 
				break;
			}
			while(true)
			{
				System.out.println("enter your password:");
				password=kb.next();
				
				boolean passFlag=CustomerValidation.validatepassword(password);
				if(!passFlag)
					System.out.println("password should be equal or greater than 6 must conatain uppercase and lowercase characters!");
				else
					break;
			}
			
			while(true)
			{
				System.out.println("enter your contactNo:");
				contactNo=kb.next();
			
			boolean contactNoFlag=CustomerValidation.contactNumberValidate(contactNo);
			if(!contactNoFlag)
				System.out.println("Number should be of 10 digits!");
			else
				break;
			}
			 
			String UserName=firstname.substring(0,3)+lastname.substring(0,3);
			  
				System.out.println("Welcome to health care :) !!");
				System.out.println(" your Username is"+UserName);

				String userId=usr.getUserId();
				System.out.println("your UserId is"+userId);
				usr.setUserFirstName(firstname);
				usr.setUserLastName(lastname);
				usr.setContactNumber(Long.parseLong(contactNo));
				usr.setEmailId(emailid);
				usr.setUserPassword(password);
				Customer.add(usr);
			
		}
			
		else if(opt==2)
		{
			
			System.out.println("enter your username:");
			String Id=kb.next();
			System.out.println("enter your password:");
			String pass=kb.next();
			
			s.Register(Customer, pass);
			if(Customer.contains(Id)&&pass.contentEquals(usr.getUserPassword()))
					{
				System.out.println(" Congratulations, you successfully logged in !!");
					}else {
						System.out.println("Please fill correct username and password.....");
					}
			
		}	
		}
			}
			
		}
	}
}
