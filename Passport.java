package airline;
import java.time.*;
import exceptions.InvalidDateException;

public class Passport {
	
	//fields
	private String passportID;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String birthPlace;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private String nationality;
	

    /**Constructor
     * @param passportID the passport ID
     * @param firstName the passport holder's first name
     * @param lastName the last name
     * @param birthDate the date of birth
     * @param issueDate the date the passport was issued
     * @param expirationDate when the passport expires
     * @param nationality
     * @param birthplace where the passport holder was born
     * @exception InvalidDateException*/
	
	public Passport(String passportID,String firstName, String lastName, String birthDate,String issueDate, String expirationDate, String nationality, String birthPlace)throws InvalidDateException
	{
		this.passportID=passportID;
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthPlace=birthPlace;
		
		if(LocalDate.parse(birthDate).isAfter(LocalDate.parse(issueDate)))
			throw new InvalidDateException("Invalid date: the issue date is before the passport holder's birthdate.");
		if(LocalDate.parse(issueDate).isAfter(LocalDate.parse(expirationDate)))
			throw new InvalidDateException("Invalid date: the issue date is after the expiration date.");
		
		//if passes all exceptions then can parse the dates and assign to LocalDate fields
		else{	
		this.birthDate=LocalDate.parse(birthDate);
		this.issueDate=LocalDate.parse(issueDate);
		this.expirationDate=LocalDate.parse(expirationDate);
		}
		this.nationality=nationality;
	}
	
	/**Copy Constructor
	 * @param pspt the Passport object to copy*/
	public Passport(Passport pspt){
		this.firstName=pspt.firstName;
		this.lastName=pspt.lastName;
		this.birthDate=pspt.birthDate;
		this.passportID=pspt.passportID;
		this.issueDate=pspt.issueDate;
		this.nationality=pspt.nationality;
		this.expirationDate=pspt.expirationDate;
		this.birthPlace=birthPlace;
	}
	
	/**isExpired: checks if the passport has expired
	 * @return true if the passport expired, false if it didn't*/
	public boolean isExpired(){
		if(this.expirationDate.isBefore(LocalDate.now()))
			return true;
		else
			return false;
	}//isExpired
	
	
	/**compareTo method to see which passport's id is greater*/
	public int compareTo(Passport other){
		if(this.passportID.compareTo(other.passportID)<0)
			return -1;
		else if(this.passportID.compareTo(other.passportID)>0)
			return 1;
		else
			return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//check the addresses
			return true;
		if (obj == null)//make sure obj isn't null
			return false;
		if (getClass() != obj.getClass())//if not in same class, return false
			return false;
		Passport other = (Passport) obj;//type cast obj to Passport type and then compare fields
		if (this.nationality == null) //if comparee(this) field is null(already checked comparer)
		{
			if (other.nationality != null)//and the other field isn't, return false
				return false;
		} 
		else if (!this.nationality.equals(other.nationality))//if comparee not null, then can compare fields, if fields not equal return false
			return false;
		if (passportID != other.passportID)
			return false;
		return true;//else, none of the falses were returned, so can return true
	}

	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("Passport ID: "+this.passportID+"\nName(First Last):"+this.firstName+" "+this.lastName+
				"\nBirthday: "+this.birthDate+"\nBirthplace: "+this.birthPlace+"\nNationality: "+
				this.nationality+"\nIssued: "+this.issueDate+"\nExpires: "+this.expirationDate+"\n");
		return sb.toString();
	}
	
	/**getExpirationDate
	 * @return the expiration date*/
	public LocalDate getExpirationDate()
	{
		return this.expirationDate;
	}//getExpirationDate()
	
	
	/**getID
	 * @return the passport id #*/
	public String getID()
	{
		return this.passportID;	
	}//getID()
	
	/**getLastName
	 * @return the last name*/
	public String getLastName()
	{
		return this.lastName;
	}//getLastName()
	
	
	/**getFirstName
	 * @return the first name*/
	public String getFirstName()
	{
		return this.firstName;
	}//getFirstName()
	
	
	/**getNationality
	 * @return the nationality*/
	public String getNationality()
	{
		return this.nationality;
	}//getNationality()
	
	
	/**getBirthPlace
	 * @return the birthplace*/
	public String getBirthPlace(){
		return this.birthPlace;
	}
	
	
	
}//class passport


