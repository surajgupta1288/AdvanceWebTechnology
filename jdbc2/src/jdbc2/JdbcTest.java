package jdbc2;

import java.sql.*;
public class JdbcTest {
public static void main(String[] args) 
		throws SQLException,ClassNotFoundException 
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn024=DriverManager.getConnection(
	"jdbc:oracle:thin:@localhost:1522:xe",
	"system","manager");
Statement st=cn024.createStatement();
ResultSet rs024=st.executeQuery(
		"select id,name,age from emp");
while(rs024.next())
{
int id=rs024.getInt("id");
String en=rs024.getString("name");
int a=rs024.getInt("age");
System.out.printf("id : "+id +"\tName : "+en+"\tage : "+a);
}}}