package homework2;

public class StudentRec {
	private String lastName;
	private String firstName;
	private String age;
	private String major;
	protected double gpa;
	protected int creditsEarned;
	private DOB dob;
	
	public StudentRec(String lastName, String firstName, String age, String major, 
			double gpa, int creditsEarned){
		/**
		 *	@ author Tony Morelli
		 *	@throws None 
		 *	
		 * 	Date: 		7 February 2014
		 *  Purpose: 	Handles storing and retrieving gpas	
		 *  Uses:		 
		 *  
		 */

		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.major = major;
		this.gpa = gpa;
		this.creditsEarned = creditsEarned;
		dob = new DOB(age);
		System.out.println(dob.getAge());
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getGpa() {
		return gpa;
	}
	public int getCreditsEarned() {
		return creditsEarned;
	}
	public String toString(){
		return "lastName: " + lastName+
				" firstName: "+ firstName+
				" age: "+age+
				" major: " + major+
				" gpa: "+gpa+
				" creditsEarned: "+ creditsEarned;
		
	}
}
