package CRUD_Project;

import java.sql.*;
import java.util.*;

public class CRUD_Operation {
  public static void main(String[] args) {
	 String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 String DB_URL = "jdbc:mysql://localhost:3306/crud";
	 String USER = "root";
	 String PASS ="Root";
	 
	 try {
		 Class.forName(JDBC_DRIVER);
		 Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		 Statement stmt = conn.createStatement();
		 
		 String query = "CREATE TABLE IF NOT EXISTS user(id INT NOT NULL AUTO_INCREMENT,name VARCHAR(250),email VARCHAR(250),PRIMARY KEY(id))";
		 stmt.executeUpdate(query);
		 
		 Scanner scan = new Scanner(System.in);
		 
		 System.out.println("1.Create user");
		 System.out.println("2.Read user");
		 System.out.println("3.Update user");
		 System.out.println("4.Delete user");
		 
		 System.out.print("Enter choice: ");
		 String choice = scan.nextLine();
		 
		 switch(choice) {
		 case "1":
			
			 System.out.print("Enter user name: ");
			 String name = scan.nextLine();
			 
			 System.out.print("Enter user email: ");
			 String email = scan.nextLine();
			 
			 query = "INSERT INTO user (name, email)VALUES ('"+name+"','"+email+"')";
			 
			 stmt.executeUpdate(query);
			 break;
			 
		 case "2":
			 System.out.print("Enter user id: ");
			 int id = scan.nextInt();
			 
			 query = "SELECT * from user WHERE id = "+id;
			
			 ResultSet rs = stmt.executeQuery(query);
			 
			 if(rs.next()) {
	              System.out.println("ID: "+rs.getInt("id"));
	              System.out.println("name: "+rs.getString("name"));
	              System.out.println("email: "+rs.getString("email"));
			 }else {
				 System.out.println("User not found");
			 }
			 
			 break;
		 case "3":
			 System.out.print("Enter user id: ");
			 id = scan.nextInt();
			 
			 scan.nextLine();
			 
			 System.out.print("Enter new user name: ");
			 name = scan.nextLine();
			 
			 System.out.print("Enter new user email: ");
	     	 email = scan.nextLine();
			 
			 query = "UPDATE user SET name = '"+name+"',email ='"+email+"' WHERE id =" +id;
			 
			 int result =stmt.executeUpdate(query);
			 
			 if(result > 0) {
				 System.out.println("User Updated Successfully!");
			 }else {
				 System.out.println("user not found!");
			 
			 }
			 
			 break;
			 
		 case"4":
			 System.out.print("Enter user id:");
			 id = scan.nextInt();
			 
             query = "DELETE FROM user WHERE id = " +id;
			 
			 result =stmt.executeUpdate(query);
			 
			 if(result > 0) {
				 System.out.println("User Delete Successfully!");
			 }else {
				 System.out.println("user not found!");
			 
			 }
			 
			 break;
			 
		 }
		 
		
		 stmt.close();
		 conn.close();
	 }catch(Exception e) {
		 System.out.print("Error: "+e.getMessage());
	 }
}
  
}
