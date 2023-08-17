package registrationSystem;

import java.util.Scanner;

public class Main {

	// waiting time
	public static void sleep(int val) {
		try {
			System.out.println("Please Wait....\n");
			Thread.sleep(val);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void adminDuty() {
		Admin ad = new Admin();
		System.out.println("\nRegister Course :\n");
		
		ad.addCourse();
		
		
		System.out.println("\nRegister Professors:\n");
		
		ad.addProfessor();
		
		
		System.out.println("\ntRegister Students: \n");
		
		ad.addStudent();
		System.out.println("\nStudents Registered Succesfully");
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nWelcome To GoDigit\n");
		
		
		// Setting up the admin window
		Admin ad = new Admin();
		System.out.println("Please Login to Continue....\n");
		while(true) {
		System.out.println("Enter UserName: ");
		String user = sc.next();
		System.out.println("Enter Password: ");
		String pass = sc.next();
		
		sleep(3000);
		
		if((ad.admin(user, pass))){
			System.out.println("Login Successfully...\n");
			
			adminDuty();
			break;
		}
		else {
			System.out.println("Invalid Id and Password...");
		}
		
		
	
	}
		
		System.out.println("\n ProfessorG Please Grade The Students\n");
		ad.grade();
		System.out.println("\nGrading Done");
		
		
		while(true) {
		System.out.println("\n What You want to do :\n");
		System.out.println("1. Check Marks Of students \n"
				+ 			"\n2.Exit"
							);
		System.out.println("\nEnter Your Option - ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Enter User Name of the Student you want to check marks : ");
			String us = sc.next();
			System.out.println("Enter Password of the Student you want to check marks: ");
			String pass = sc.next();
			ad.checkMark(us, pass);
			break;
		case 2:
			System.exit(0);
			break;
			
		default:
			System.out.println("\t\tThank You....");
			break;
		}
		}
		
		
	}

	

	

}
