
public class Patient 
{
	public String firstname;		// information about the patient
	public String lastname;			// name, age and their priority level
	public int age;
	public String nextOfKin;
	public String diagnosis;
	
	public int priority;
	public String summary;
	

	// constructor for the patient
	public Patient(String firstname, String lastname, int age, String nextOfKin, String diagnosis)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.nextOfKin = nextOfKin;
		this.diagnosis = diagnosis;
		this.priority = 0; 		// patients priority initially set as 0, updated later
		this.summary = "";		// set summary as a blank string, will be updated at the end
	} // end constructor
	
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
} // end patient
