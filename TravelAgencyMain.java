package airline;
import exceptions.*;
import java.util.*;
import java.time.format.DateTimeParseException;



public class TravelAgencyMain {

	public static void main(String[]args){
		
		TravelAgency travels=new TravelAgency();
		Scanner input=new Scanner(System.in);
		int choice=menu(input);
		do{
			switch(choice){
			case 1:
				System.out.println("Please enter:");
				input.nextLine();
				System.out.println("First name:");
				String first=input.nextLine();
				System.out.println("Last name:");
				String last=input.nextLine();
				System.out.println("Gender (m for male or f for female):");
				String sgender=input.nextLine();
				char gender=sgender.charAt(0);
				//validate gender input 
				while(!sgender.toUpperCase().startsWith("F")&&!sgender.toUpperCase().startsWith("M")){
					System.out.println("Please enter m for male or f for female.");
					sgender=input.nextLine().toUpperCase();
					gender=sgender.charAt(0);
				}
				System.out.println("Street (address and street):");
				String street=input.nextLine();
				System.out.println("City:");
				String city=input.nextLine();
				System.out.println("State: (no spaces)");
				String stateTemp=input.nextLine();
				//remove spaces and make upper case
				String state=stateTemp.replaceAll("\\s","").toUpperCase();
				System.out.println("Zipcode:");
				String zip=input.nextLine();
				System.out.println("Phone number:(no symbols only numbers)");
				String phone=input.nextLine();
				System.out.println("Credit Card Number");
				String ccNum=input.nextLine();
				System.out.println("Expiration Date: (yyyy-mm-dd)");
				String expDate=input.nextLine();
				
				System.out.println("3 digit pin");
				int pin=input.nextInt();
				try{
				
				CreditCard card=new CreditCard(ccNum,expDate,pin);
				addCustomer(travels,first,last,gender,street,city,state,zip,phone,card);
				System.out.println("This is your customer id: "+travels.lastCustomerID);
				}
				catch(DateTimeParseException dpe){
					System.out.println(dpe);
					System.out.println("Therefore this customer could not be added. Please try again.");
				}

				catch(DuplicateDataException dd){
					System.out.println(dd);
					
				}
				catch(CardExpiredException cee){
					System.out.println(cee);
					System.out.println("Therefore this customer could not be added. Please try again.");
				}
			System.out.println();//to make it prettier and easier to read
				break;
			case 2:
				System.out.println("Please enter:");
				input.nextLine();
				System.out.println("Social Security number");
				String social=input.nextLine();
				System.out.println("First name:");
				String first2=input.nextLine();
				System.out.println("Last name:");
				String last2=input.nextLine();
				System.out.println("Gender (m for male or f for female):");
				String sgender2=input.nextLine();
				char gender2=sgender2.charAt(0);
				//validate gender input 
				while(!sgender2.toUpperCase().startsWith("F")&&!sgender2.toUpperCase().startsWith("M")){
					System.out.println("Please enter m for male or f for female.");
					sgender2=input.nextLine().toUpperCase();
					gender2=sgender2.charAt(0);
				}
				System.out.println("Street (address and street):");
				String street2=input.nextLine();
				System.out.println("City:");
				String city2=input.nextLine();
				System.out.println("State: (no spaces)");
				String stateTemp2=input.nextLine();
				//remove spaces and make upper case
				String state2=stateTemp2.replaceAll("\\s","").toUpperCase();
				System.out.println("Zipcode:");
				String zip2=input.nextLine();
				System.out.println("Phone number:(no symbols only numbers)");
				String phone2=input.nextLine();
				try{
				addAgent(travels,social,first2,last2,gender2,street2,city2,state2,zip2,phone2);
				System.out.println("This is your travel agent's id: "+travels.lastEmployeeID);
				}
				catch(DuplicateDataException dde){
					System.out.println(dde);
				
				}
				System.out.println();
				break;
			case 3:
				
				System.out.println("Please enter:");
				input.nextLine();//because just entered an int for their choice
				//now need passport info to create a passport object for them
				System.out.println("Passport ID:");
				String pId=input.nextLine();
				System.out.println("First name on Passport:");
				first=input.nextLine();
				System.out.println("Last name on Passport:");
				last=input.nextLine();
				System.out.println("Nationality");
				String nationality=input.nextLine();
				System.out.println("Birthplace");
				String birthplace=input.nextLine();
				//some person info
				System.out.println("Gender (m for male or f for female):");
				sgender=input.nextLine();
				gender=sgender.charAt(0);
				//validate gender input 
				while(!sgender.toUpperCase().startsWith("F")&&!sgender.toUpperCase().startsWith("M")){
					System.out.println("Please enter m for male or f for female.");
					sgender=input.nextLine().toUpperCase();
					gender=sgender.charAt(0);
				}
				System.out.println("Street (address and street):");
				street=input.nextLine();
				System.out.println("City:");
				city=input.nextLine();
				System.out.println("State: (no spaces)");
				stateTemp=input.nextLine();
				//remove spaces and make upper case
				state=stateTemp.replaceAll("\\s","").toUpperCase();
				System.out.println("Zipcode:");
				zip=input.nextLine();
				System.out.println("Phone number:(no symbols only numbers)");
				phone=input.nextLine();
				
				//dates for passport
				System.out.println("Birthdate: yyyy-mm-dd");
				String birthDate=input.nextLine();
				System.out.println("Passport issue date: yyyy-mm-dd");
				String issueDate=input.nextLine();
				System.out.println("Passport expiration date: yyyy-mm-dd");
				expDate=input.nextLine();
				
			    try{
			    	//create a passport, call addPassenger method which will call the addPassenger method of the TA class
				Passport passport=new Passport(pId,first,last,birthDate,issueDate,expDate,nationality,birthplace);
				addPassenger(travels,first,last,gender,street,city,state,zip,phone,passport);
				System.out.println("This is your passenger id: "+travels.lastPassengerID);
			    }
			    //in case sent in the wrong format
			    catch(DateTimeParseException dtpe){
			    	System.out.println(dtpe);
			    	System.out.println("Therefore this passenger could not be added. Please try again.");
			    }
			    catch(InvalidDateException id){
			    	System.out.println(id);
			    	System.out.println("Therefore this passenger could not be added. Please try again.");
			    }
			    catch(DuplicateDataException dd){
			    	System.out.println(dd);
			  
			    }
				System.out.println();
				break;
			case 4:
				System.out.println("Please enter the id # of the passenger whose information you want:");
				int id=input.nextInt();
				try{
				findPassengerInfo(travels,id);
				}
				catch(DataNotFoundException dnfe){
					System.out.println(dnfe);
				}
				System.out.println();
				break;
			case 5:
				System.out.println("Please enter the id # of the customer you want to find:");
				id=input.nextInt();
				try{
				findCustomer(travels,id);
				}
				catch(DataNotFoundException dnfe){
					System.out.println(dnfe);
				}
				System.out.println();
				break;
			case 6:
				getPassengers(travels);
				System.out.println();
				break;
			case 7:
				System.out.println("Please enter the flight number:");
				int flightNum=input.nextInt();
				System.out.println("Please enter the number of the last seat in first class");
				int lastFirstSeat=input.nextInt();
				input.nextLine();
				System.out.println("Please enter the flight's departure date (yyyy-mm-dd)");
				String departureDate=input.nextLine();
				try{
					addFlight(travels,flightNum,departureDate,lastFirstSeat);
					System.out.println("This flight has been added successfully.");
				}
				catch(DateTimeParseException dtpe){
					System.out.println(dtpe);
					System.out.println("Therefore this flight could not be added. Please try again.");
				}
				catch(DuplicateDataException dde){
					System.out.println(dde);
					System.out.println("Therefore this flight could not be added. Please try again.");
				}
				System.out.println();
				break;
			case 8:
				System.out.println("Please enter the flight number of the flight on which to book the passenger:");
				flightNum=input.nextInt();
				System.out.println("The id of the passenger to book:");
				int pID=input.nextInt();
				System.out.println("the number of the desired seat:");
				int seatNum=input.nextInt();
				System.out.println("The id of the travel agent who is booking this ticket:");
				int taID=input.nextInt();
				System.out.println("The ticket price:");
				double price=input.nextDouble();
				try{
				bookTicket(travels,flightNum,pID,seatNum,taID,price);
				System.out.println("Your seat has been booked.");
				}
				catch(DuplicateDataException dde){
					System.out.println(dde);
					System.out.println("Therefore this seat could not be booked. Please try again.");
				}
				catch(SeatNotAvailableException snae){
					System.out.println(snae);
					System.out.println("Therefore this seat could not be booked. Please try again.");
				}
				catch(FullyBookedException fbe){
					System.out.println(fbe);
					System.out.println("Therefore this seat could not be booked. Please try again on a different flight.");
				}
				catch(DataNotFoundException dnfe){
					System.out.println(dnfe);
					System.out.println("Therefore this seat could not be booked. Please try again.");
				}
				System.out.println();
				break;
			case 9:
				System.out.println("Please enter the flight number of the flight on which to cancel the passenger's ticket:");
				flightNum=input.nextInt();
				System.out.println("The id of the passenger who wishes to cancel:");
			    pID=input.nextInt();
				System.out.println("the number of his/her seat:");
				seatNum=input.nextInt();
				
				try{
				cancelTicket(travels,flightNum,pID,seatNum);
				System.out.println("The seat has been canceled");
				}
				
				
				catch(DataNotFoundException dnfe){
					System.out.println(dnfe);
					System.out.println("Therefore this seat could not be canceled. Please try again.");
				}
				System.out.println();
				break;
			case 10:
				display(travels);
				break;
			case 11:
				System.out.println("Goodbye.");
				System.exit(0);//to actually end it and not go to the menu again
				break;
			}
			choice=menu(input);	//to prevent infinite loops
			
		}while(choice!=0);
		
		
	}//main
	
	public static int menu(Scanner input){
		int choice;
		System.out.println("Please enter the number of your choice:");
		System.out.println("1.Add a customer\n2.Add a travel agent\n3.Add a passenger\n4.Find a passenger");
		System.out.println("5.Find a customer\n6.Get the list of passengers\n7.Add a flight\n8.Book a flight");
		System.out.println("9.Cancel a flight\n10.Display\n11.Quit");
		choice=input.nextInt();
		
		while(choice<1||choice>11){
			System.out.println("Invalid entry. Please try again.");
			choice=input.nextInt();
		}
		
		
		return choice;
	}//menu
	

	
	public static void addCustomer(TravelAgency travels, String first, String last, char gender, String street, String city, String state,String zip,String phone,CreditCard card)
			throws DuplicateDataException
	{
		travels.addCustomer(first, last, gender, street, city, state, zip, phone, card);
	}//addCustomer
	
	public static void addAgent(TravelAgency travels,String social, String first, String last, char gender, String street, String city, String state,String zip,String phone)
	throws DuplicateDataException
	{
		travels.addAgent(social, first, last, gender, street, city, state, zip, phone);
	}//addAgent
	
	
	public static void addPassenger(TravelAgency travels,String first,String last,char gender,String street,String city,String state,String zip,String phone,Passport passport)
	throws DuplicateDataException{
		travels.addPassenger(first, last, gender, street, city, state, zip, phone, passport);
	}
	
	public static void findPassengerInfo(TravelAgency travels,int id)
	throws DataNotFoundException
	{
		Passenger p=travels.findPassengerInfo(id);
		System.out.println(p);
	}
	
	
	public static void findCustomer(TravelAgency travels, int id)throws DataNotFoundException{
		Customer cust=travels.findCustomer(id);
		System.out.println(cust);
	}
	
	public static void getPassengers(TravelAgency travels){
		if(travels.getPassengers().equals(null))
			System.out.println("There are currently no passengers.");
		else{
			ArrayList<Passenger> passengers=travels.getPassengers();
			for(Passenger p:passengers){
				System.out.println(p.toString());
				System.out.println();
			}
		}
		    
	}
	
	public static void addFlight(TravelAgency travels, int flightNum, String departureDate, int lastFirstSeat)
	throws DuplicateDataException
	{
		travels.addScheduledFlight(flightNum, departureDate, lastFirstSeat);
	}
	
	
	public static void bookTicket(TravelAgency travels,int flightNum,int pID,int seatNum, int taID,double price) 
			throws DataNotFoundException, FullyBookedException, SeatNotAvailableException, DuplicateDataException
	{
		travels.bookFlight(flightNum, pID, seatNum, taID, price);
	}
	
	public static void cancelTicket(TravelAgency travels,int flightNum, int pID, int seatNum) throws DataNotFoundException{
		travels.cancelFlight(flightNum, pID, seatNum);
	}
	
	public static void display(TravelAgency travels){
		System.out.println(travels.toString());
		System.out.println();
	}
	
	
	
}//class
