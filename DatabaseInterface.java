package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInterface {
	
	static Connection con;
	

	static void dbConnect() throws ClassNotFoundException, SQLException {
		//1. Load the Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Establish Connection with Database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varun", 
											"root", "");

		//System.out.println(con);
	}
	
	static void dbDisconnect() throws SQLException {
		con.close();
	}
	

	
//	get Faculty table
	static String getAll() throws SQLException {
		String query = "select * from Faculty";
		
		Statement stat = con.createStatement();
		
		ResultSet rs = stat.executeQuery(query);

		
		String result = "|------------------------------------------------------------------------------------|\n";
			   result += "|ID\t|Name\t|Salary\t|Contact\t|EmailId\t|Departmen\n";
       	       result += "|------------------------------------------------------------------------------------|\n";
		while(rs.next()) {
			result += "|" + rs.getInt("faculty_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getDouble(3) +
					"\t|" + rs.getString(4) +
					"\t|" + rs.getString(5) +
					"\t|" + rs.getString(6) +"\n";
		}
		       result += "--------------------------------------------------------------------------------------|\n";
		
		return result;
	}
	
	
//	Get Faculty By Name
	
	public static String getByName(String name) throws SQLException {
		String query = "select * from Faculty where faculty_name like ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, "%" + name + "%");
		
	
		
		
		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			output += "|-----------------------------------------------------------------------------------|\n";
			output += "|ID\t|Name\t|Salary\t|Contact\t|EmailId\t\t|Department\n";
			output += "|-----------------------------------------------------------------------------------|\n";
			output += "|" + rs.getInt("faculty_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getDouble(3) +
					"\t|" + rs.getString(4) +
					"\t|" + rs.getString(5) +
					"\t|" + rs.getString(6) +"\n";
			output += "------------------------------------------------------------------------------------|\n";
		}		
		else
			output += "\n\n **** No Record Found **** \n\n";
		
		return output;
	}
	
	
	
//   Add more Faculty To faculty table
	
	public static String add(int id, String name, double salary,String contact,String email,String Department)
			throws SQLException {
		String query = "insert into Faculty values(?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setDouble(3, salary);
		ps.setString(4, contact);
		ps.setString(5, email);
		ps.setString(6, Department);
		int i = ps.executeUpdate();		
		String result="";
		
		if(i>0)
			result = "\nInserted Successfully.......";
		else
			result = "\nInsertion Failed";
		return result;	
	}
	

	
	
// 		Delete faculty From faculty table
	
	public static String delete(int id) throws SQLException {
		String query = "delete from Faculty where faculty_Id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "\nDeleted Successfully.......";
		else 
			output += "\nDelete Failed";
		
		return output;
	}

	
	
//		Update Faculty Name In faculty table by Id
	
	public static String updateName(int id, String name) throws SQLException {
		String query = "update Faculty set faculty_name = ? where faculty_Id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "\nName Updated Successfully.....";
		else 
			output += "\nUpdate Failed";
		
		return output;
	}
//	Update Faculty Department In faculty table by Id
	
	public static String updateDepartment(int id, String Department) throws SQLException {
		String query = "update Faculty set faculty_deparment = ? where faculty_Id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, Department);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "\n Faculty Department Updated Successfully.....";
		else 
			output += "\nUpdate Failed";
		
		return output;
	}
	
//	Update Faculty Contact number In faculty table by Id
	
	public static String updateContact(int id, String contact) throws SQLException {
		String query = "update Faculty set faculty_Contact = ? where faculty_Id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, contact);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "\n Faculty Department Updated Successfully.....";
		else 
			output += "\nUpdate Failed";
		
		return output;
	}
//	Update Faculty Email In faculty table by Id
	
	public static String updateEmail(int id, String email) throws SQLException {
		String query = "update Faculty set faculty_Email = ? where faculty_Id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, email);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "\n Faculty Department Updated Successfully.....";
		else 
			output += "\nUpdate Failed";
		
		return output;
	}
	
	
//	Update faculty salary In faculty table by Id

	public static String updateSalary(int id, double salary) throws SQLException {
		String query = "update Faculty set faculty_salary = ? where faculty_Id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setDouble(1, salary);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "\nsalary Updated Successfully.....";
		else 
			output += "\nUpdate Failed";
		
		return output;
	}



	
//	Get Faculty By ID
	
	
	public static String getById(int id) throws SQLException {
		String query = "select * from Faculty where faculty_Id = ?";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		String result="";
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			result+= "|-----------------------------------------------------------------------------------------------|\n";
			result+= "|ID\t|Name\t|Salary\t|Contact\t|EmailId\t\t|Departmen\n";
			result+= "|-----------------------------------------------------------------------------------------------|\n";
			result += "|" + rs.getInt("faculty_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getDouble(3) +
					"\t|" + rs.getString(4) +
					"\t|" + rs.getString(5) +
					"\t|" + rs.getString(6) +"\n";
		       result += "--------------------------------------------------------------------------------------------|\n";
		}
		else
			result+= "\nNo Records Found\n";	
		
		return result;
	}
	

	
	///////////////////////////////////////////////////////////////////////////////
	
//Student Information
	
	
	static String getAll1() throws SQLException {
		String query = "select * from student";
		
		Statement stat = con.createStatement();
		
		ResultSet rs = stat.executeQuery(query);

		
		String result = "|------------------------------------------------------------------------------------|\n";
			   result += "|ID\t|Name\t|Phoneno\t|EmailId\t|DOB\n";
       	       result += "|------------------------------------------------------------------------------------|\n";
		while(rs.next()) {
			result += "|" + rs.getInt("stu_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getInt(3) +
					"\t|" + rs.getString(4) +
					"\t|" + rs.getString(5) +"\n";
		}
		       result += "--------------------------------------------------------------------------------------|\n";
		
		return result;
	}
	
	//Get Student By Name
	
	public static String getByName1(String Name) throws SQLException {
		String query = "select * from Faculty where stu_name like ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, "%" + Name + "%");
		
	
		
		
		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			output += "|-----------------------------------------------------------------------------------|\n";
			output += "|ID\t|Name\t|Phoneno\t|EmailId\t\t|DOB\n";
			output += "|-----------------------------------------------------------------------------------|\n";
			output += "|" + rs.getInt("faculty_id") + 
					"\t|" + rs.getString(2) + 
					"\t|" + rs.getInt(3) +
					"\t|" + rs.getString(4) +
					"\t|" + rs.getString(5) +"\n";
			output += "------------------------------------------------------------------------------------|\n";
		}		
		else
			output += "\n\n **** No Record Found **** \n\n";
		
		return output;
	}
	
	
	
	public static String add(int Id, String Name, int Phoneno, String Email, String dob) throws SQLException
	{
       String query = "insert into Faculty values(?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, Id);
		ps.setString(2, Name);
		//ps.setDouble(3, salary);
		ps.setInt(3, Phoneno);
		ps.setString(4, Email);
		ps.setString(5, dob);
		int i = ps.executeUpdate();		
		String result="";
		
		if(i>0)
			result = "\nInserted Successfully.......";
		else
			result = "\nInsertion Failed";
		return result;	
	}
	// Update student phone number
	public static String updatePhoneno(int Id, int Phoneno) throws SQLException {
     String query = "update Faculty set stu_ph_no = ? where stu_id = ?";
		
		String output = "";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, Phoneno);
		ps.setInt(2, Id);
		
		int i = ps.executeUpdate();
		
		if(i>0)
			output += "\n Faculty Department Updated Successfully.....";
		else 
			output += "\nUpdate Failed";
		
		return output;
	}
//	Delete Student ID by Student table

public static String delete1(int Id) throws SQLException {
      String query = "delete from student where stu_id = ?";

     String output = "";

     PreparedStatement ps = con.prepareStatement(query);
     ps.setInt(1, Id);

     int i = ps.executeUpdate();

     if(i>0)
     	output += "\nDeleted Successfully.......";
    else 
    	output += "\nDelete Failed";

      return output;
}
//Update student Email Id
public static String updateEmail1(int Id, String Email) throws SQLException {
	String query = "update Faculty set stu_Email = ? where stu_Id = ?";
	
	String output = "";
	
	PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1, Email);
	ps.setInt(2, Id);
	
	int i = ps.executeUpdate();
	
	if(i>0)
		output += "\n Faculty Department Updated Successfully.....";
	else 
		output += "\nUpdate Failed";
	
	return output;
}
// Update student dob
public static String updateDob(int Id, String dob) throws SQLException {
	String query = "update Faculty set stu_dob = ? where stu_Id = ?";
	
	String output = "";
	
	PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1, dob);
	ps.setInt(2, Id);
	
	int i = ps.executeUpdate();
	
	if(i>0)
		output += "\n Faculty Department Updated Successfully.....";
	else 
		output += "\nUpdate Failed";
	
	return output;
}

public static String getById1(int Id) throws SQLException {
	String query = "select * from student where stu_Id = ?";
	
	PreparedStatement ps = con.prepareStatement(query);
	ps.setInt(1, Id);
	String result="";
	ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		result+= "|-----------------------------------------------------------------------------------------------|\n";
		result+= "|ID\t|Name\t|Phoneno\t|EmailId\t\t|DOB\n";
		result+= "|-----------------------------------------------------------------------------------------------|\n";
		result += "|" + rs.getInt("stu_id") + 
				"\t|" + rs.getString(2) + 
				"\t|" + rs.getInt(3) +
				"\t|" + rs.getString(4) +
				"\t|" + rs.getString(5) +"\n";
	       result += "--------------------------------------------------------------------------------------------|\n";
	}
	else
		result+= "\nNo Records Found\n";	
	
	return result;
}

//
//// Login Page
//
//class LoginInfo extends DatabaseInterface{
//	
//	
//	static String allLogin() throws SQLException {
//		String query = "select * from login";
//		
//		Statement stat = con.createStatement();
//		
//		ResultSet rs = stat.executeQuery(query);
//
//		
//		String result = "--------------------------------------\n";
//			   result += "|ID\t|Username\t|Password\n";
//       	       result += "--------------------------------------\n";
//		while(rs.next()) {
//			result += "|" + rs.getInt(1) + 
//					"\t|" + rs.getString(2) + 
//					"\t|" + rs.getString(3) +"\n";
//		}
//		       result += "--------------------------------------\n";
//		
//		return result;
//	}
//	
//	
//		public static String login_one() throws SQLException {
//			String query = "select * from login where Id = ?";
//			int id=1;
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			String result1="";
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				result1 += rs.getString(2);
//			}
//			else
//				result1 = "\nNo Records Found\n";	
//			
//			return result1;
//		}
//		public static String login_1() throws SQLException {
//			String query = "select * from login where id = ?";
//			
//			int id=1;
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			String result1="";
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//		
//				result1 += rs.getString(3);
//					
//			}
//			else
//				result1 = "\nNo Records Found\n";	
//			
//			return result1;
//		}
//		
//		
//		public static String login_two() throws SQLException {
//			String query = "select * from login where id = ?";
//			int id=2;
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			String result1="";
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				result1 += rs.getString(2);
//			}
//			else
//				result1 = "\nNo Records Found\n";	
//			
//			return result1;
//		}
//		public static String login_2() throws SQLException {
//			String query = "select * from login where id = ?";
//			
//			int id=2;
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			String result1="";
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//		
//				result1 += rs.getString(3);
//					
//			}
//			else
//				result1 = "\nNo Records Found\n";	
//			
//			return result1;
//		}
//
//
//		//Update UserName 
//		
//		public static String updateName(int id, String name) throws SQLException {
//		String query = "update login set Username = ? where ID = ?";
//		
//		String output = "";
//		
//		PreparedStatement ps = con.prepareStatement(query);
//		ps.setString(1, name);
//		ps.setInt(2, id);
//		
//		int i = ps.executeUpdate();
//		
//		if(i>0)
//			output += "\nUsername Updated Successfully.....";
//		else 
//			output += "\nUpdate Failed";
//		
//		return output;
//		}
//
//			
//		//Update Password
//		public static String updatePassword(int id, String password) throws SQLException {
//			String query = "update login set Password = ? where ID = ?";
//			
//			String output = "";
//			
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, password);
//			ps.setInt(2, id);
//			
//			int i = ps.executeUpdate();
//			
//			if(i>0)
//				output += "\nPassword Updated Successfully.....";
//			else 
//				output += "\nUpdate Failed";
//			
//			return output;
//		}
//    }


public static String getAll2() throws SQLException {
	String query = "select * from branch";
	
	Statement stat = con.createStatement();
	
	ResultSet rs = stat.executeQuery(query);

	
	String result = "|------------------------------------------------------------------------------------|\n";
		   result += "|ID\t|Name\t|Catogary\n";
   	       result += "|------------------------------------------------------------------------------------|\n";
	while(rs.next()) {
		result += "|" + rs.getInt("brc_Id") + 
				"\t|" + rs.getString(2) + 
				"\t|" + rs.getString(3) +"\n";
	}
	       result += "--------------------------------------------------------------------------------------|\n";
	
	return result;
}

public static String add1(int brc_Id, String brc_Name,String brc_Catogary) throws SQLException {
	String query = "insert into  values(?,?,?)";
	
	PreparedStatement ps = con.prepareStatement(query);
	ps.setInt(1, brc_Id);
	ps.setString(2, brc_Name);
	ps.setString(3, brc_Catogary);
//	//ps.setDouble(3, salary);
//	ps.setInt(3, Phoneno);
//	ps.setString(4, Email);
//	ps.setString(5, dob);
	int i = ps.executeUpdate();		
	String result="";
	
	if(i>0)
		result = "\nInserted Successfully.......";
	else
		result = "\nInsertion Failed";
	return result;	
}
//Update Branch Name from Branch Table
		public static String updateBrc_Name(int brc_Id, String brc_Name) throws SQLException {
			String query = "update branch set brc_Name = ? where brn_id = ?";
			
			String output = "";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, brc_Name);
			ps.setInt(2, brc_Id);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				output += "\nPassword Updated Successfully.....";
			else 
				output += "\nUpdate Failed";
			
			return output;
		}
		//Update branch Catogary from branch table
				public static String updateBrc_Catogary(int brc_Id, String brc_Catogary) throws SQLException {
					String query = "update branch set brc_Catogary = ? where brn_id = ?";
					
					String output = "";
					
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,brc_Catogary );
					ps.setInt(2, brc_Id);
					
					int i = ps.executeUpdate();
					
					if(i>0)
						output += "\nPassword Updated Successfully.....";
					else 
						output += "\nUpdate Failed";
					
					return output;
				}
				//Get Student By Name
				
public static String getByBrc_Name(String brc_Name) throws SQLException {
			String query = "select * from branch where brn_name like ?";
					
			String output = "";
					
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%" + brc_Name + "%");
					
				
					
					
					ResultSet rs = ps.executeQuery();

					if(rs.next()) {
						output += "|-----------------------------------------------------------------------------------|\n";
						output += "|ID\t|Name\t|Catogary\n";
						output += "|-----------------------------------------------------------------------------------|\n";
						output += "|" + rs.getInt("brn_id") + 
								"\t|" + rs.getString(2) + 
								"\t|" + rs.getString(3) +"\n";
						output += "------------------------------------------------------------------------------------|\n";
					}		
					else
						output += "\n\n **** No Record Found **** \n\n";
					
					return output;
				}
				
//Get by branch Id form branch table
public static String getByBrc_Id(String brc_Id) throws SQLException {
	String query = "select * from branch where brn_id like ?";
			
	String output = "";
			
	PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1, "%" + brc_Id + "%");
			
		
			
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				output += "|-----------------------------------------------------------------------------------|\n";
				output += "|ID\t|Name\t|Catogary\n";
				output += "|-----------------------------------------------------------------------------------|\n";
				output += "|" + rs.getInt("brn_id") + 
						"\t|" + rs.getString(2) + 
						"\t|" + rs.getString(3) +"\n";
				output += "------------------------------------------------------------------------------------|\n";
			}		
			else
				output += "\n\n **** No Record Found **** \n\n";
			
			return output;
		}
		
}
