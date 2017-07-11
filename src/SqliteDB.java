
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SqliteDB 
{
	Connection c = null;
	PreparedStatement stmt = null;
	
	public SqliteDB() 
	{	// try connect to DB
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Patients.sqlite");
			System.out.println("Connected to DB ok");
		}
		catch (Exception e)
		{
			System.out.println("Error: "  + e.getMessage());
			e.printStackTrace();
		}
	} // end constructor
	
	
	public void insert(String fname, String lname, int age, String nok, String diagnosis)
	{			// add the created person to the database
		String sql = "INSERT INTO Patients (firstname, lastname, age, nextOfKin, diagnosis) VALUES(?,?,?,?,?)";
			try 									// method for inserting a string of information to the database
			{										// all parameters taken in for patient details
				stmt = c.prepareStatement(sql);		// 'sql' string is statement format for adding to DB with VALUES being the 
				stmt.setString(1, fname);			// parameters and each corrisponding database column
				stmt.setString(2, lname);
				stmt.setInt(3, age);
				stmt.setString(4, nok);
				stmt.setString(5, diagnosis);
				stmt.executeUpdate();				// execute the update and add to DB
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Create Error: "  + e.getMessage());
				e.printStackTrace();
			}
	} // end insert
	
	public void addPriority(int priority, String fname, String lname)
	{														// update a person in the database to set their priority. 
		String sql = "UPDATE Patients SET priority = ? "	// used first name and surname as the checking parameters,
				+ "WHERE firstname = ? AND "				// as it is unlikely to have more than one person with the same name
				+ "lastname = ? ";
		try
		{
			stmt = c.prepareStatement(sql);
			stmt.setInt(1, priority);
			stmt.setString(2, fname);
			stmt.setString(3, lname);
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println("Priority Error: "  + e.getMessage());
			e.printStackTrace();
		}
	} // end addPriority
	
	
	public void addSummary(String summary, String fname, String lname)
	{														// update a patients summary after seeing the doctor
		String sql = "UPDATE Patients SET summary = ? "		// same as for adding priority 
				+ "WHERE firstname = ? AND "				// use first and last name as checks
				+ "lastname = ? ";
		try
		{
			stmt = c.prepareStatement(sql);
			stmt.setString(1, summary);
			stmt.setString(2, fname);
			stmt.setString(3, lname);
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println("Summary Error: "  + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection()
	{
		try
		{
			c.close();
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	} // end closeConnection
}
