package Database;

import java.sql.SQLException;

public class StartApp {
	public static void main(String[] args) {
		try {
			DatabaseInterface.dbConnect();
			//UIInterface.login1();
			UIInterface.startApp();
			//LoginInfo.allLogin();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			//System.out.println("finally");
			try {
				DatabaseInterface.dbDisconnect();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}