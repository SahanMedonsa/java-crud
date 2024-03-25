import java.sql.*;
import java.util.*;


public class my_crud {

	public static void main(String[] args) {
		
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/ToDo";
		String USER = "root";
		String PASS = "";
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
			
			
			String query = "CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255), email VARCHAR(255), PRIMARY KEY (id))";
			
			stmt.executeUpdate(query);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("1. Add User");
			System.out.println("2. Read User");
			System.out.println("3. Update User");
			System.out.println("4. Delete User");
			
			System.out.print("Enter Choice:");
			String choice = scan.nextLine();
			
			switch(choice) {
			case "1":
				//ADD USERS
				System.out.print("Enter user name : ");
				String name = scan.nextLine();
				
				System.out.print("Enter user Email : ");
				String email = scan.nextLine();
				
				query = "INSERT INTO users (name,email) VALUES ('"+name+"','"+email+"')";
				
				stmt.executeUpdate(query);
				break;
			case "2":
				//Read Users
				System.out.print("Enter user id : ");
				int id = scan.nextInt();
				
				query = "SELECT * FROM users WHERE id ="+ id;
				
				ResultSet rs = stmt.executeQuery(query);
				
				if(rs.next()) {
					System.out.println("ID:    "+ rs.getInt("id"));
					System.out.println("Name:  "+ rs.getString("name"));
					System.out.println("Email: "+ rs.getString("email"));
					
				}else {
					System.out.print("User Not Found");
				}
				break;
				
			case "3":
				
				System.out.print("Enter user ID: ");
				 id = scan.nextInt();
				 
				 scan.nextLine();
				 
				System.out.print("Enter new user name : ");
				 name = scan.nextLine();
				
				 
				System.out.print("Enter new user Email : ");
				 email = scan.nextLine();
				
				 query = "UPDATE users SET name = '"+name+"', email= '"+email+"' WHERE id ="+ id;
				 
				int result = stmt.executeUpdate(query);
				
				if(result >0) {
					System.out.print("User Update Successfully");
				}else {
					System.out.print("User Not Found");
				}
				
				break;
				
			case "4":
				System.out.print("Enter user ID: ");
				 id = scan.nextInt();
				 
				 query = "DELETE FROM users WHERE id ="+ id;
				 
					 result = stmt.executeUpdate(query);
					
					if(result >0) {
						System.out.print("User Deleted Successfully");
					}else {
						System.out.print("User Not Found");
					}
				 
				 
				break;
			}
			
			
			
		
			
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.print("Error :"+e.getMessage());
		}
				

	}

}
