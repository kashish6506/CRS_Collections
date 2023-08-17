package registrationSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {
	Scanner sc = new Scanner(System.in);
	
	static ArrayList<Course> courses = new ArrayList<>();
	
	static ArrayList<Professor> professors = new ArrayList<Professor>();
	
	static ArrayList<Student> students = new ArrayList<Student>();
	
	static HashMap<Integer,Course> mappingCoursesId = new HashMap<>();
	
	static HashMap<Integer,Professor> mappingProfessor = new HashMap<>();
	
	static HashMap<String,String> mappingStudentsLog = new HashMap<>();
	
	static String user_name = "admin";
	static String password = "admin";

	//register admin
	public boolean admin(String user_name,String pass) {
			if(user_name.equals(user_name) && pass.equals(password)) {
				
				return true;
			}
			else {
				System.err.println("Invalid Credentials...");
			}
			return false;
		
	}
	
	//adding the courses 
	public void addCourse() {
		System.out.println("How many course You want to Register ?");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			sc.nextLine();
			System.out.println("Course No - "+(i+1));
			System.out.println("Enter the Course Name : ");
			String name = sc.nextLine();
			System.out.println("Enter the course ID : ");
			int id = sc.nextInt();
			System.out.println("Enter the course Duration : ");
			float duration = sc.nextFloat();
			// creating a course
			Course c = new Course(name,id,duration);
			
			//adding course in course list
			courses.add(c);
			
			//mapping each course with there id
			mappingCoursesId.put(id, c);
			System.out.println("\n Course registered successfully...\n");
		}
	}

	// adding professors
	public void addProfessor() {
//		System.out.println("We are Hiring "+courses.size()+" Professors for "+courses.size()+" Courses. ");
		ArrayList<Course> arr = new ArrayList<Course>(courses);
		
		
		sc.nextLine();
		for(int i=0;i<courses.size();i++) {
			System.out.println("Professor No:"+(i+1)+"\n");
			System.out.println("Enter The Professor Name : " );
			String name = sc.nextLine();
			
			
			System.out.println("\nCourses : \n");
			System.out.println("Id : Name");
			
			for(int j=0;j<arr.size();j++) {
				
				System.out.println(arr.get(j).course_id+":"+arr.get(j).name);
			}
			
			System.out.println("Enter the Course Id You want to assign Professor: ");
			int num = sc.nextInt();
			
			// removing the course which is allocated to professor .
			for(int j=0;j<arr.size();j++) {
				if(arr.get(j).course_id == num) {
					
					arr.remove(j);
					
				}
				
			}
			
			
			Professor p = new Professor(name,num);
			professors.add(p);
			
			mappingProfessor.put(num, p);
			
			System.out.println("\n Professor Assigned Successfully...\n");
			sc.nextLine();
			
		}
		
	}

	//adding the students 
	public void addStudent() {
		System.out.println("How many Students are there for Registration? ");
		int num = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<num;i++) {
			System.out.println("\nStudent No: "+(i+1));
			System.out.println("Enter The User Name of the Student : ");
			String name  = sc.nextLine();
			System.out.println("Enter the Password for the Student :");
			String pass = sc.next();
			
			// storing the students id and password 
			mappingStudentsLog.put(name, pass);
			
			System.out.println("\n In Which course the Student will enroll into : ");
			System.out.println("Courses Avialable : ");
			System.out.println("ID : Name");
			
			for(int j=0;j<courses.size();j++) {
				
				System.out.println(courses.get(j).course_id+":"+courses.get(j).name);
			}
			System.out.println("\nEnter The Course Id : ");
			int id = sc.nextInt();
			
			Student s = new Student(name,pass,id);
			//adding each student in student list
			students.add(s);
			sc.nextLine();
		}
		
	}
	
	//  professor will grade the students 
	public void grade() {	
		for(int i=0;i<students.size();i++) {
			System.out.println("Grades for student No - "+(i+1));
			Professor p = mappingProfessor.get(students.get(i).course_id);
			
			
			
			System.out.println("Enter the Quizzes Marks out of 100 :");
			int quizz = sc.nextInt();
			System.out.println("Enter the Assignments Marks out of 100 :");
			int assign = sc.nextInt();
			
			System.out.println("Enter the Mid Term Exam Marks out of 100 :");
			int mid = sc.nextInt();
			
			System.out.println("Enter the Final Exam Marks out of 100 :");
			int finl = sc.nextInt();
			
//			System.out.println("\n Professor- '"+p.name+"' is Now Grading the student- '"+students.get(i).user_name+"' From The '"+ 
//			mappingCoursesId.get(students.get(i).course_id).name+"' Batch. \n");
			
			
				Main.sleep(2000);
				
				
				students.get(i).Quizzes = quizz;
				students.get(i).Assignments = assign;
				
				students.get(i).Midterm_Exam = mid;
				students.get(i).Final_Exam = finl;
				
				// Calculating Grade
				if(students.get(i).Final_Exam >= 85) {
					students.get(i).grade = "O";
				}
				else if(students.get(i).Final_Exam >= 75) {
					students.get(i).grade = "E";
				}
				else if(students.get(i).Final_Exam >= 65) {
					students.get(i).grade = "A";
				}
				else if(students.get(i).Final_Exam >=55) {
					students.get(i).grade = "B";
				}
				else if(students.get(i).Final_Exam >=45) {
					students.get(i).grade = "C";
				}
				else if(students.get(i).Final_Exam >=35) {
					students.get(i).grade = "D";
				}
				else {
					students.get(i).grade = "F";
				}
				
				
			
			System.out.println("Marks given for : "+ students.get(i).user_name+"\n");
		}
	}
	
	// checking the mark by providing the user name and password of the student 
	public  void checkMark(String user_name,String pass) {
		

		Main.sleep(3000);;
		
		for(int i=0;i<students.size();i++) {
		
			if(user_name.equals(students.get(i).user_name) && pass.equals(students.get(i).password)){
			System.out.println("Overall Grade of '"+ students.get(i).user_name+"' is : '"+students.get(i).grade+"'");
			
			System.out.println("\n You want your Mark Card(Y/N) ");
			String ans = sc.next();
			if(ans.toLowerCase().equals("y")) {
				System.out.println(					"Mark Card"                
						
						+ "Student Name: "+students.get(i).user_name+"\n"
						+ "Student ID: "+students.get(i).course_id+" \n"
						+ "Course: "+mappingCoursesId.get(students.get(i).course_id).name+"\n"
						+ "Academic Period: January 2023 - June 2023\n"
						+ "\n"
						+ "Quizzes :"+students.get(i).Quizzes+"/100\n"
						+ "Assignments :"+students.get(i).Assignments+"/100\n"
						+ "Midterm Exam :"+students.get(i).Midterm_Exam+"/100\n"
						+ "Final Exam :"+students.get(i).Final_Exam+"/100\n"
						+ "\n"
						+ "Overall Grade: "+students.get(i).grade+"\n"
						+ "\n");
			}
			
				return;
			
		}
		}
		
		System.err.println("\nInvalid....");
	}
	
	

	

}


