package airline;

public class Passenger extends Person {

	private Passport pspt;
	private int id;
	
	/**Constructor 1
	 * @param id the passenger's id #
	 * @param first the first name of the person
	 * @param last the last name of the person
	 * @param gender m or f (male or female)
	 * @param street
	 * @param city 
	 * @param state 
	 * @param zip 
	 * @param phone the phone number of the person
	 * @param pspt the Passport the passenger "has"*/
	public Passenger(int id,String first, String last, char gender, String street, String city, String state, String zip, String phone, Passport pspt)
	{
		super(first,last,gender,street,city,state,zip,phone);
		this.id=id;
		this.pspt=pspt;
		
	}
	
	/**Constructor 2* 
	 * @param id the passenger's id #
	 * @param first the first name of the person
	 * @param last the last name of the person
	 * @param gender m or f (male or female)
	 * @param street
	 * @param city 
	 * @param state 
	 * @param zip 
	 * @param phone the phone number of the person*/
	public Passenger(int id, String first, String last, char gender, String street, String city, String state, String zip, String phone){
		this(id, first, last, gender, street, city, state, zip, phone, null);//calling the first constructor
		
	}
	
	/**copy constructor
	 * @param other the Passenger object to copy*/
	public Passenger(Passenger other){
		super(other.getFirstName(),other.getLastName(),other.getGender(),other.getAddress(),other.getPhoneNumber());
		this.pspt=other.pspt;
		this.id=other.id;
	}
	
	/**hasPassport: checks if the passenger has a passport and makes sure it isn't expired
	 * @return true or false depending on whether or not the person has a valid passport or not*/
	public boolean hasPassport(){
		if(pspt==null || pspt.isExpired())
			return false;
		else
			return true;
	}
	
	/**setPassport 
	 * @param p a passport to set*/
	public void setPassport(Passport p){
		this.pspt=p;
	}
	/**getPassport
	 * @return a Passport object*/
	public Passport getPassport(){
		return this.pspt;
	}
	
	/**getID
	 * @return the Passenger id*/
	public int getID(){
		return this.id;
	}
	
	
	@Override
	public boolean equals(Object other){
		if(this==other)//check addresses
			return true;
	    if(other==null)//check param isn't null
	    	return false;
		if(other.getClass()!=this.getClass())//check classes
			return false;
		Passenger PassOther=(Passenger) other;//type cast the object
		if(this.id==PassOther.id)//check ids
			return true;
		else
			return false;
		
	}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("Passenger ID #: "+this.id);
		sb.append("\n"+super.toString());
		sb.append("\n"+this.pspt);
		
		return sb.toString();
	}
	
	
}//class
