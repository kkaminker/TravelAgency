package airline;

public class Person {
	
	private Address adr;
	private String firstName;
	private String lastName;
	private char gender;
	private String phone;
	
	/**Constructor
	 * @param firstName the first name of the person
	 * @param lastName the last name of the person
	 * @param gender m or f (male or female)
	 * @param adr an Address object 
	 * @param phone the phone number of the person*/
	public Person(String firstName, String lastName,char gender, Address adr,String phone){
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.adr=new Address(adr);//deep copy using copy constructor
		this.phone=phone;
	}

	/**Constructor
	 * @param firstName the first name of the person
	 * @param lastName the last name of the person
	 * @param gender m or f (male or female)
	 * @param street to be passed to Address constructor
	 * @param city to be passed to Address constructor
	 * @param state to be passed to Address constructor
	 * @param zip to be passed to Address constructor
	 * @param phone the phone number of the person*/
	public Person(String firstName, String lastName, char gender, String street, String city, String state, String zip, String phone){
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.adr=new Address(street,city,state,zip);//deep copy using regular constructor
		this.phone=phone;
	}
	
	/**getAddress: to get the person's address
	 * @return an Address object*/
	public Address getAddress(){
		this.adr=new Address(adr);//return a deep copy
		return adr;
	}
	
	/**getFirstName
	 * @return the first name*/
	public String getFirstName(){
		return this.firstName;
	}
	
	/**getLastName
	 * @return the last name*/
	public String getLastName(){
		return this.lastName;
	}
	
	/**getPhoneNumber
	 * @return the phone number*/
	public String getPhoneNumber(){
		return this.phone;
	}
	
	/**getGender
	 * @return the gender*/
	public char getGender(){
		return this.gender;
	}
	/**setAddress
	 * @param street to be passed to Address constructor
	 * @param city to be passed to Address constructor
	 * @param state to be passed to Address constructor
	 * @param zip to be passed to Address constructor
	 * */
	public void setAddress(String street,String city,String state, String zip){
		this.adr=new Address(street,city,state,zip);
	}
	
	/**setLastName
	 * @param lastName to set the last name*/
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	
	/**setPhoneNumber
	 * @param phone the phone number to set*/
	public void setPhoneNumber(String phone){
		this.phone=phone;
	}
	
	/**setStreet
	 * @param street the street address to set
	 * @param zip the zip code to set*/
	public void setStreet(String street, String zip){
		this.adr.setStreet(street);
		this.adr.setZipCode(zip);
		
	}
	
	/**toString
	 * @return a string with the Person info*/
	@Override
	public String toString(){
		StringBuilder strb=new StringBuilder();
		strb.append("Name(last,first): "+lastName+", "+firstName+"\nGender: "+gender);
		strb.append("\nPhone number: "+phone+"\n\nAddress: "+adr);
		
		return strb.toString();
		
	}//toString
	
	
}//class



