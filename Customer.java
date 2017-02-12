package airline;
import exceptions.*;

public class Customer extends Person{
	
	private int customerID;
	private CreditCard card;

	
	/**Constructor
	 * @param customerID the customer's id number
	 * @param first the first name 
	 * @param last the last name 
	 * @param gender m or f (male or female)
	 * @param street
	 * @param city 
	 * @param state 
	 * @param zip 
	 * @param phone the phone number of the person
	 * @param card the credit card the customer has
	 * */
	public Customer(int customerID, String firstName, String lastName, char gender, String street, String city, String state, String zip, String phoneNumber, CreditCard card){
		super(firstName,lastName,gender,street,city,state,zip,phoneNumber);//create the person object 
		this.customerID=customerID;
		this.card=new CreditCard(card);//deep copy of the creditcard
	}
	
	/**Constructor
	 * @param customerID the customer's id number
     * @param firstName the first name 
	 * @param lastName the last name 
	 * @param gender m or f (male or female)
	 * @param adr an Address object
	 * @param card a CreditCard object
	 * @param phoneNumber the phone number */
	public Customer(int customerID, String firstName, String lastName, char gender, Address adr,CreditCard card, String phoneNumber){
		super(firstName,lastName,gender,adr,phoneNumber);
		this.customerID=customerID;
		this.card=new CreditCard(card);
	}
	
	//added this copy constructor to help in the findCustomer method of TravelAgency
	/**Copy Constructor
	 * @param c the Customer object to be copied*/
	public Customer(Customer c){
		super(c.getFirstName(),c.getLastName(),c.getGender(),c.getAddress(),c.getPhoneNumber());
		this.customerID=c.customerID;
		this.card=c.card;
	}
	
	/**chargeCard to add a charge to the custome's credit card
	 * @param amount the amount to charge
	 * @exception InvalidPinException if the pin does not match
	 * @exception InsufficientFundsException if goes over the credit limit
	 * @exception CardExpiredException if the card expired*/
	public void chargeCard(double amount)throws InsufficientFundsException, InvalidPinException, CardExpiredException
	{
		int pin=card.getPin();//gets the card's pin to pass to its addCharge method
		card.addCharge(amount, pin);//invokes the CreditCard's addCharge method
	}
	
	//needed to access customer's creditCard in order to get the balance, 
	//anyhow it has no setters so don't have to really worry
	/**getCard
	 * @return a CreditCard object*/
	public CreditCard getCard(){
		return new CreditCard(card);//deep copy
	}
	
	/**compareTo: compares two customers based on their ids*/
	public int compareTo(Customer cust){
		if(this.customerID<cust.customerID)
			return -1;
		else if(this.customerID>cust.customerID)
			return 1;
		else
			return 0;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(obj.getClass()!=this.getClass())
			return false;
		Customer other=(Customer)obj;
		if (other.customerID!=this.customerID)
			return false;
		else
			return true;
	}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
	
		sb.append("\nCustomer ID: "+ this.customerID);
		sb.append("\n");
	    sb.append(super.toString());
		//I don't want the creditcard info printed
		return sb.toString();
		
		
	}
	
	
	//needed to check customer Id in findCustomer method in TravelAgency class
	/**getCustomerID
	 * @return the customer's id*/
	public int getCustomerID(){
		return this.customerID;
	}
	
}//class
