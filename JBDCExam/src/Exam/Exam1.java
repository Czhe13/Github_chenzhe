package Exam;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam1 {
  public static void main(String[] args){
	  System.out.println("���������ID:");
	  Scanner scanner=new Scanner(System.in);
	 int abc=scanner.nextInt();
	   String country="SELECT city_id,city FROM city"+"WHERE country_id=abc";
	  Connection conn=null;
	  Statement st=null;
	  ResultSet rs=null;
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  conn=DriverManager.getConnection("jbdc:mysql://localhost:3306","root","");
		  st=conn.createStatement();
		  rs=st.executeQuery(country);
		while(rs.next()){
			  System.out.println(rs.getInt("city_id")+" ");
			  System.out.println(rs.getString("city")+" ");
		  }
	  }catch(Exception e){
		  e.printStackTrace();
	  }finally{
		  try{
			 rs.close(); 
		  }catch(Exception e2){
			  e2.printStackTrace();
		  }
		  try{
			  st.close();
		  }catch(Exception e3){
			  e3.printStackTrace();
		  }
		  try{
			  conn.close();
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	  
  }
}
