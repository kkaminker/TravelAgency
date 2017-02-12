package airline;
import exceptions.*;
import java.util.*;

public class TravelAgency {
	
	private ArrayList<Person> people;
	private ArrayList<ScheduledFlight>flights;
	public static int lastCustomerID=0;
	public static int lastEmployeeID=0;
	public static int lastPassengerID=0;
	
	/**Constructor
	 * No-Arg*/
	//initializes ArrayList fields
	public TravelAgency(){
		people=new ArrayList<Person>();
		flights=new ArrayList<ScheduledFlight>();
		
	}//constructor
	
	/**Add Customer method to add a customer to the ArrayList of people
	 * @param firstName the first name of the customer
	 * @param lastName the last name of the customer
	 * @param gender the gender of the customer
	 * @param street the street address of the customer
	 * @param city the customer's city of residence
	 * @param state the customer's state of residence
	 * @param zip the customer's zip code
	 * @param phone the customer's phone number
	 * @param card the CreditCard object that has the credit card information of the customer
	 * @exception DuplicateDataException in case an attempt is made to add a customer who already exists in the system */
	public void addCustomer(String firstName,String lastName, char gender, String street, String city, String state, String zip, String phone, CreditCard card)throws DuplicateDataException
	{
		//enhanced for loop checks all people in the array for a customer with some of the same fields as the one trying to add
		for(Person p: people){
			
			if(p instanceof Customer){
				if(p.getFirstName()==firstName && p.getLastName()==lastName && p.getPhoneNumber()==phone){
					throw new DuplicateDataException("This customer already exists in the system.");
				}//inner if	
			}//outer if
		}//for
		
		//if get to this point didn't throw an exception so can create a customer object and add to ArrayList
		lastCustomerID++;//increment the last customer id, and will assign this new one to the customer adding
		Customer cust=new Customer(lastCustomerID,firstName,lastName,gender,street,city,state,zip,phone,card);
		people.add(cust);
	}//addCustomer
	/**AddAgent method to add a travel agent to the ArrayList of people
	 * @param ssNum the social security number of the agent
	 * @param first the first name of the agent
	 * @param last the last name of the agent
	 * @param gender the gender of the agent
	 * @param street the street address of the agent
	 * @param city the agent's city of residence
	 * @param state the agent's state of residence
	 * @param zip the agent's zip code
	 * @param phone the agent's phone number
	 
	 * @exception DuplicateDataException in case an attempt is made to add a travel agent who already exists in the system */
	
	public void addAgent(String ssNum,String first,String last, char gender, String street, String city, String state, String zip, String phone) throws DuplicateDataException{
		
		for(Person p:people)
		{
			if(p instanceof TravelAgent)
			{
				if(p.getFirstName()==first && p.getLastName()==last && p.getPhoneNumber()==phone)
				{
					throw new DuplicateDataException();	
				}//inner if
		
			}//outer if	
		}//for
		
		lastEmployeeID++;
		TravelAgent ta=new TravelAgent(lastEmployeeID,ssNum,first,last,gender,street,city,state,zip,phone);
		people.add(ta);
		
	}//addAgent
	
	/**addPassenger  method to add a passenger to the ArrayList of people
	 * @param ssNum the social security number of the passenger
	 * @param first the first name of the passenger
	 * @param last the last name of the passenger
	 * @param gender the gender of the passenger
	 * @param street the street address of the passenger
	 * @param city the passenger's city of residence
	 * @param state the passenger's state of residence
	 * @param zip the passenger's zip code
	 * @param phone the passenger's phone number
	   @param p a Passport object containing the passenger's passport information
	 * @exception DuplicateDataException in case an attempt is made to add a passenger who already exists in the system */
	public void addPassenger(String first,String last, char gender, String street, String city, String state, String zip, String phone, Passport p)throws DuplicateDataException{
       
		for(Person pers:people)
		{
			if(pers instanceof Passenger)
			{
				if(pers.getFirstName()==first && pers.getLastName()==last && pers.getPhoneNumber()==phone)
				{
					throw new DuplicateDataException();	
				}//inner if
		
			}//outer if	
		}//for
		
		lastPassengerID++;
		Passenger passenger=new Passenger(lastPassengerID,first,last,gender,street,city,state,zip,phone,p);
		people.add(passenger);
		
		
	}//addPassenger
	
	/**findPassengerInfo method to find a passenger and get his information
	 * @param id the passenger's id number
	 * @return a passenger object
	 * @exception DataNotFoundException in case the passenger being searched for does not exist*/
	public Passenger findPassengerInfo(int id) throws DataNotFoundException{

		for(Person p:people)
		{
			if((p instanceof Passenger) && ((Passenger) p).getID()==id )
			{
				return new Passenger((Passenger)p);
			}//if
				
		}//for
		
		//if he had been found, then the return statement would have executed and would not get to this point
		throw new DataNotFoundException("This passenger can not be found.");
	
		
	}//findPassenger
	
	/**findCustomer method to find a customer
	 * @param id the customer's id number
	 * @return a customer object
	 * @exception DataNotFoundException in case the customer being searched for does not exist*/
	
	public Customer findCustomer(int id) throws DataNotFoundException{
	
		for(Person p: people){
			if((p instanceof Customer)&&((Customer)p).getCustomerID()==id){
			
				return new Customer ((Customer)p);
			}
				
		}//for
			throw new DataNotFoundException("This customer can not be found.");
			
	}//findCustomer
	
	
	/**getPassengers: Culls the passenger objects from the ArrayList of people, and 
	 * creates a new ArrayList just of passengers
	 * @return the ArrayList of passenger objects or null if it was empty*/
	public ArrayList<Passenger> getPassengers(){
		//instantiate a Passenger ArrayList
		ArrayList<Passenger>passengers=new ArrayList<Passenger>();
		//search through Person arraylist and if any people are passengers, add them to new arraylist
		for(Person p:people){
			if(p instanceof Passenger){
				passengers.add(new Passenger((Passenger)p));
				
			}//if
		}//for
		if(passengers.isEmpty())
			return null;
		else
		return passengers;
	}//get Passengers
	
	/**addScheduledFlight: to add a ScheduledFlight object to the ArrayList of flights
	 * @param flightNum, the flight id of the flight to be added
	 * @param departureDate the date the flight is to depart
	 * @param lastFirstClassSeat the number of the last seat in first class
	 * @exception DuplicateDataException in case there is a flight with the same id as the flight to be added*/
     //I added the lastFirstClassSeat to prevent hard coding in the scheduledflight class
	public void addScheduledFlight(int flightNum, String departureDate, int lastFirstClassSeat)throws DuplicateDataException{
		for(ScheduledFlight f: flights){
			if(f.getFlightID()==flightNum){
				throw new DuplicateDataException("There is already a flight with this id scheduled.");
				
			}//if
			
		}//for
		flights.add(new ScheduledFlight(departureDate,flightNum, lastFirstClassSeat));
		
	}//addScheduledFlight
	
	/**bookFlight: to book a ticket for a passenger
	 * @param flightNum the flight id of the flight to add
	 * @param seatNum the seat to be booked
	 * @param employeeID the id of the travel agent who booked the flight
	 * @param price the cost of the ticket
	 * @exception DataNotFoundException for a flight, passenger, or travel agent being searched for who does not exist
	 * @exception SeatNotAvailableException if the desired seat is already booked
	 * @exception DuplicateDataException if trying to book a passenger in two different seats
	 * */
	public void bookFlight(int flightNum,int passengerID,int seatNum,int employeeID, double price)
			throws DataNotFoundException, FullyBookedException, SeatNotAvailableException,DuplicateDataException
	{
	
		boolean flightFlag=false;
		boolean persFlag=false;
		//search for the passenger whose id was passed in in the AL of people
		//making sure the Person object is of type Passenger and their id matches the id passed in
		for(Person p: people){
			if(p instanceof Passenger && ((Passenger) p).getID()==passengerID)
			{
			
				//if the passenger was found, set flag and search for the correct flight
				persFlag=true;
			for(ScheduledFlight f:flights)
			{
				//if the flight is found, book the passenger a seat and set flag
				if(f.getFlightID()==flightNum)
				{
					f.bookSeat((Passenger)p, seatNum);
				    flightFlag=true;
				}
				
					
			}//for
			
			}//if		
			
		}//for
		
		 if(flightFlag!=true)
			 throw new DataNotFoundException("This flight could not be found.");
		 if(persFlag!=true)
			 throw new DataNotFoundException("This passenger could not be found.");
		
		 boolean taFlag=false;
		/*now to pay the travel agent (I didn't include this as a pre-condition for booking
		a seat because as long as the passenger and flight exist, he can have a ticket
		search for the TravelAgent object in the AL whose id matches the TA id passed in
		if the TA is found, can call the bookTicket method which will set the TA's earnings*/
		for(Person p1:people){
			if(p1 instanceof TravelAgent &&((TravelAgent)p1).getEmployeeID()==employeeID){
				((TravelAgent)p1).bookTicket(price);
				taFlag=true;
			}//if
			
				
		}//for
		if(taFlag==false)
		throw new DataNotFoundException("This travel agent could not be found.");
	}//bookFlight
	
	/**cancelFlight method to cancel a passenger's ticket
	 * @param flightNum the flight id of the flight on which he is booked
	 * @param passengerID the id of the passenger
	 * @param seatNum the seat number of the passenger
	 * @param DataNotFoundException if the flight or passenger is not found*/
	public void cancelFlight(int flightNum,int passengerID,int seatNum)throws DataNotFoundException{
		boolean persFlag=false;
		boolean flightFlag=false;
		for(Person p:people){
			if(p instanceof Passenger && ((Passenger) p).getID()==passengerID){
				
				persFlag=true;
				for(ScheduledFlight f:flights){
					if(f.getFlightID()==flightNum){
						flightFlag=true;
						f.cancelReservation((Passenger)p, seatNum);
					}
					
						
				}//for
				}//if
				
		}//for
		if(flightFlag!=true)
			 throw new DataNotFoundException("This flight could not be found.");
		 if(persFlag!=true)
			 throw new DataNotFoundException("This passenger could not be found.");
			
		
	}//cancelFlight
	
	@Override 
	public String toString(){
		StringBuilder sb=new StringBuilder();
		
		if(flights.isEmpty()){
			sb.append("There are no flights scheduled.");
		}
		else{
			sb.append("Flights\n");
		for(ScheduledFlight f: flights){
			sb.append("\n"+f.viewPlaneLayout());
		}
		}
		if(people.isEmpty()){
			System.out.println("There are no passengers, customers, or travel agents.");
		}
		else{
			System.out.println();
		for(Person p: people){
			sb.append("\n"+p.toString());
		}
		}
		
		return sb.toString();
	}
	


}//class
