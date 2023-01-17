package Database;

import java.sql.SQLException;
import java.util.Scanner;
public class UIInterface extends DatabaseInterface {
	static Scanner sc = new Scanner(System.in);
//	/
	     
	   /*
	     while(i!=2) {
		System.out.print("Enter Username : ");
		s1=sc.nextLine();
		System.out.print("Enter Password : ");
		s2=sc.nextLine();
		
		if(s1.equalsIgnoreCase(LoginInfo.login_one()) && s2.equalsIgnoreCase(LoginInfo.login_1()) || s1.equalsIgnoreCase(LoginInfo.login_two()) && s2.equalsIgnoreCase(LoginInfo.login_2())) {
			System.out.println();
			System.out.println();
			System.out.println("$%$%$%$%$%$%$%$%$ WELCOME $ TO $ COLLEGE $ MANAGEMENT $ SYSTEM $%$%$%$%$%$%$%$%$%");
			System.out.println();
			startApp();
			i++;
		}
		
		else {
		System.out.println("Login Failed");
		System.out.println();
		System.out.println("***** Please try Once Again *****");
		}
	     }*/
		
//}

static void startApp() throws SQLException {
		    while(true) {
			System.out.println();
			System.out.println();
			System.out.println("Select the following college Area in this given chart:");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.College Student Information:");
			System.out.println("2.College Faculties Information:");
			System.out.println("3.College Branch Information:");
			System.out.println("4.College Librery Information:");
			System.out.println("5.College Login Information:");
			System.out.println("6.Exit:");
			System.out.println("--------------------------------------------------------------------");
			System.out.print("Enter Your above Choice: ");
			int choice = sc.nextInt();
			if(choice ==6) {
				System.out.println("************ Thank You ************");
				break;
			}
			else
			{
				switch(choice)
				{
				case 1:
					System.out.println("***************1.College Student Information:*******************");
					System.out.println();
					System.out.println();
					System.out.println("Select the operation to perform:");
					System.out.println("1. Show All Student Details");
					System.out.println("2. Find the Student By ID");
					System.out.println("3. Add new Student Faculty");
					System.out.println("4. Update Student Details");
					System.out.println("5. Delete Student Details");
					System.out.println("6. Find the Student By Name");
					System.out.println("0. Quit");
					System.out.print("Enter Your Choice1:");
					int choice1=sc.nextInt();
					int Id;
					String Name,Email;
					int Phoneno;
					String dob;
					switch(choice1)
					{
					case 1: System.out.println(DatabaseInterface.getAll1());
							break;
					case 2: System.out.print("Provide the ID of the Student: ");
							Id = sc.nextInt();
							System.out.println(DatabaseInterface.getById(Id));
							break;
					case 3: System.out.print("Enter ID: ");
							Id = sc.nextInt();
							System.out.print("Enter Name: ");
							Name = sc.next();
//							System.out.print("Enter salary: ");
//							salary = sc.nextDouble();
							System.out.print("Enter Phoneno: ");
							Phoneno = sc.nextInt();
                            System.out.print("Enter EmailId: ");
							Email = sc.next();
							System.out.print("Enter Date of Birth: ");
							dob = sc.next();
							System.out.println(DatabaseInterface.add(Id, Name,Phoneno,Email,dob));
							break;
					case 4: System.out.print("Provide the ID of the Student to be updated: ");
					Id = sc.nextInt();
					System.out.println("Choose the detail to be updated:");
					System.out.println("1.Student Name");
					//System.out.println("2. Student Salary");
					System.out.println("2. Student Phoneno");
					System.out.println("3. Student Email");
					System.out.println("4. Student Date of Birth");
					System.out.print("Enter Your Choice: ");
					int upChoice = sc.nextInt();
					switch(upChoice) {
						case 1: System.out.print("Enter New Name: ");
								Name = sc.next();
								System.out.println(DatabaseInterface.updateName(Id, Name));
								System.out.println();
								break;
//						case 2: System.out.print("Enter New Salary: ");
//								salary = sc.nextDouble();
//								System.out.println(DatabaseInterface.updateSalary(id, salary));
//								System.out.println();
//								break;
						case 2: System.out.print("Enter New Phone Number: ");
						        Phoneno = sc.nextInt();
						        System.out.println(DatabaseInterface.updatePhoneno(Id, Phoneno));
						        System.out.println();
						        break;
						case 3: System.out.print("Enter New Email Id: ");
						        Email = sc.next();
						        System.out.println(DatabaseInterface.updateEmail(Id, Email));
						        System.out.println();
						        break;
						case 5: System.out.print("Enter New Date of birth: ");
						        dob = sc.next();
						        System.out.println(DatabaseInterface.updateDob(Id,dob));
						        System.out.println();
						        break;
						default: System.out.println("\n\n *** WRONG CHOICE *** \n\n");
								
					}
					case 5: System.out.print("Provide the ID of the College student to be deleted: ");
					        Id = sc.nextInt();
					        System.out.println(DatabaseInterface.delete(Id));
					        System.out.println();
					        break;
					case 6:System.out.print("Provide the ID of the student: ");
					       Name = sc.next();
					       System.out.println(DatabaseInterface.getByName(Name));
					       break;
					default: System.out.println("\n\nEnter the correct choice\n\n"); 
				}
				break;	
				case 2:
					System.out.println("----------------2.College Faculty Information----------------------");
					System.out.println();
					System.out.println();
					System.out.println("Select the operation to perform:");
					System.out.println("1. Show All Faculty Details");
					System.out.println("2. Find the Faculty By ID");
					System.out.println("3. Add More Faculty");
					System.out.println("4. Update Faculty Details");
					System.out.println("5. Delete Faculty Details");
					System.out.println("6. Find the Faculty By Name");
					System.out.println("0. Quit");
					System.out.print("Enter Your Choice: ");
					int choice2 = sc.nextInt();
//					if(choice1 == 0) {
//						System.out.println("************ Thank You ************");
//						break;
//					}
//					else {
						int id;
						String name,contact,email,Department;
					    double salary;
						switch(choice2) {
							case 1: System.out.println(DatabaseInterface.getAll());
									break;
							case 2: System.out.print("Provide the ID of the Faculty: ");
									id = sc.nextInt();
									System.out.println(DatabaseInterface.getById(id));
									break;
							case 3: System.out.print("Enter ID: ");
									id = sc.nextInt();
									System.out.print("Enter Name: ");
									name = sc.next();
									System.out.print("Enter salary: ");
									salary = sc.nextDouble();
									System.out.print("Enter Contact: ");
									contact = sc.next();
		                            System.out.print("Enter EmailId: ");
									email = sc.next();
									System.out.print("Enter Department: ");
									Department = sc.next();
									System.out.println(DatabaseInterface.add(id, name, salary, contact,email,Department));
									break;
							case 4: System.out.print("Provide the ID of the Faculty to be updated: ");
							id = sc.nextInt();
							System.out.println("Choose the detail to be updated:");
							System.out.println("1.Faculty Name");
							System.out.println("2. Faculty Salary");
							System.out.println("3. Faculty Contact");
							System.out.println("4. Faculty Email");
							System.out.println("5. Faculty Department");
							System.out.print("Enter Your Choice: ");
							int upChoice = sc.nextInt();
							switch(upChoice) {
								case 1: System.out.print("Enter New Name: ");
										name = sc.next();
										System.out.println(DatabaseInterface.updateName(id, name));
										System.out.println();
										break;
								case 2: System.out.print("Enter New Salary: ");
										salary = sc.nextDouble();
										System.out.println(DatabaseInterface.updateSalary(id, salary));
										System.out.println();
										break;
								case 3: System.out.print("Enter New Contact: ");
								        contact = sc.next();
								        System.out.println(DatabaseInterface.updateContact(id, contact));
								        System.out.println();
								        break;
								case 4: System.out.print("Enter New EmailId: ");
								        email = sc.next();
								        System.out.println(DatabaseInterface.updateEmail(id, email));
								        System.out.println();
								        break;
								case 5: System.out.print("Enter New Department: ");
								        Department = sc.next();
								        System.out.println(DatabaseInterface.updateDepartment(id,Department));
								        System.out.println();
								        break;
								default: System.out.println("\n\n *** WRONG CHOICE *** \n\n");
										
							}
							 break;
							case 5: System.out.print("Provide the ID of the College Faculty to be deleted: ");
							        id = sc.nextInt();
							        System.out.println(DatabaseInterface.delete(id));
							        System.out.println();
							        break;
							case 6:System.out.print("Provide the ID of the Faculty: ");
							       name = sc.next();
							       System.out.println(DatabaseInterface.getByName(name));
							       break;
							default: System.out.println("\n\nEnter the correct choice\n\n"); 
						}
				case 3:
					System.out.println("***************1.College Branch Information:*******************");
					System.out.println();
					System.out.println();
					System.out.println("Select the operation to perform:");
					System.out.println("1. Show All Branch Details");
					System.out.println("2. Find the Branch By ID");
					System.out.println("3. Add new Branch:");
					System.out.println("4. Update Branch Details");
					System.out.println("5. Delete Branch Details");
					System.out.println("6. Find the Branch By Name");
					System.out.println("0. Quit");
					System.out.print("Enter Your Choice2:");
					int choice3=sc.nextInt();
					int brc_Id;
					String brc_Name;
					String brc_Catogary;
					//int Phoneno;
					//String dob;
					switch(choice3)
					{
					case 1: System.out.println(DatabaseInterface.getAll2());
							break;
					case 2: System.out.print("Provide the ID of the branch: ");
							brc_Id = sc.nextInt();
							System.out.println(DatabaseInterface.getById(brc_Id));
							break;
					case 3: System.out.print("Enter Branch ID: ");
							brc_Id = sc.nextInt();
							System.out.print("Enter Branch Name: ");
							brc_Name = sc.next();
							System.out.print("Enter Branch catogry: ");
							brc_Catogary = sc.next();
//							System.out.print("Enter Phoneno: ");
//							Phoneno = sc.nextInt();
//                            System.out.print("Enter EmailId: ");
//							Email = sc.next();
//							System.out.print("Enter Date of Birth: ");
//							dob = sc.next();
							System.out.println(DatabaseInterface.add1(brc_Id, brc_Name, brc_Catogary));
							break;
					case 4: System.out.print("Provide the ID of the branch to be updated: ");
					brc_Id = sc.nextInt();
					System.out.println("Choose the detail to be updated:");
					System.out.println("1.Branch Name");
					//System.out.println("2. Student Salary");
//					System.out.println("2. Student Phoneno");
//					System.out.println("3. Student Email");
//					System.out.println("4. Student Date of Birth");
					System.out.print("Enter Your Choice: ");
					int upChoice1 = sc.nextInt();
					switch(upChoice1) {
						case 1: System.out.print("Enter New Name: ");
								brc_Name = sc.next();
								System.out.println(DatabaseInterface.updateName(brc_Id, brc_Name));
								System.out.println();
								break;
//						case 2: System.out.print("Enter New Salary: ");
//								salary = sc.nextDouble();
//								System.out.println(DatabaseInterface.updateSalary(id, salary));
//								System.out.println();
//								break;
//						case 2: System.out.print("Enter New Phone Number: ");
//						        Phoneno = sc.nextInt();
//						        System.out.println(DatabaseInterface.updatePhoneno(Id, Phoneno));
//						        System.out.println();
//						        break;
//						case 3: System.out.print("Enter New Email Id: ");
//						        Email = sc.next();
//						        System.out.println(DatabaseInterface.updateEmail(Id, Email));
//						        System.out.println();
//						        break;
//						case 5: System.out.print("Enter New Date of birth: ");
//						        dob = sc.next();
//						        System.out.println(DatabaseInterface.updateDob(Id,dob));
//						        System.out.println();
//						        break;
						default: System.out.println("\n\n *** WRONG CHOICE *** \n\n");
								
					}
					break;
					case 5: System.out.print("Provide the ID of the College Branch to be deleted: ");
					        brc_Id = sc.nextInt();
					        System.out.println(DatabaseInterface.delete(brc_Id));
					        System.out.println();
					        break;
					case 6:System.out.print("Provide the ID of the Branch: ");
					       brc_Name = sc.next();
					       System.out.println(DatabaseInterface.getByName(brc_Name));
					       break;
					default: System.out.println("\n\nEnter the correct choice\n\n"); 
				}
					
				 }
		  }
	 }
   }
}