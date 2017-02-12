package airline;
import exceptions.*;
import java.util.*;
import java.time.*;

public class ScheduledFlight {
	
	private ArrayList<Passenger> passengers;
	private Seat[]seats=new Seat[10];
	private LocalDate departureDate;
	private int flightID;
	private int availableFirst;
	private int availableEconomy;
	//I don't like that the for loop in the constructor is hard coded
	//so...
	private int lastFirstClassSeat;
	//and I am adding it as a parameter to the constructor
	
	/**Constructor
	 * @param departureDate the date the flight is to depart
	 * @param flightID the flight id number
	 * @param lastFirstClassSeat the last seat number in first class*/
	public ScheduledFlight(String departureDate, int flightID, int lastFirstClassSeat)
	{
		this.departureDate=LocalDate.parse(departureDate);
		this.flightID=flightID;
		this.passengers=new ArrayList<Passenger>();//instantiate ArrayList
		this.availableFirst=5;
		this.availableEconomy=5;
		this.lastFirstClassSeat=lastFirstClassSeat;
		
		//in each for loop (one for first class, one for economy seats)
		//create each seat object passing the seatType to the Seat constructor
		for(int index=0;index<this.lastFirstClassSeat+1;index++)
		{
			seats[index]=new Seat("FIRSTCLASS");
			
		}//for
		
		for(int index=this.lastFirstClassSeat+1;index<seats.length;index++)
		{
			seats[index]=new Seat("ECONOMY");
	
		}
	}//constructor
	
	/**getSeatType
	 * @return the seat type*/
	public SeatType getSeatType(int seatNumber){
		return seats[seatNumber].getSeatType();//the seat type of the Seat object referenced in the array
	}
	
	//needed for addScheduledFlight in TravelAgency class
	/**getFlightID
	 * @return flightID the flight ID*/
	public int getFlightID(){
		return this.flightID;
	}
	
	/**bookSeat to book a seat for a passenger
	 * @param p the Passenger
	 * @param seatNumber the seat he wants booked
	 * @exception DuplicateDataException if the passenger already has a seat
	 * @exception SeatNotAvailableException if the seat is booked by someone else*/
	public void bookSeat(Passenger p, int seatNumber) throws DuplicateDataException, SeatNotAvailableException, FullyBookedException{
	
		boolean flag=false;
	//check if plane fully booked
		for(int index=0;index<seats.length;index++){
			if(seats[index].isAvailable())
				flag=true;//if there is one seat available, good			
		}//for
		
		if (flag==false)//flag stayed false meaning no available seats, so throw exception
			throw new FullyBookedException();
		
		//search for the passenger to make sure doesn't already have a seat	
		if(passengers.contains(p))
			throw new DuplicateDataException("This passenger already has a seat.");
				
		//check if seat available
		if(!seats[seatNumber].isAvailable())
			throw new SeatNotAvailableException();
		
		
		//if does not already have a seat

			passengers.add(p);//add to arraylist of passengers
			seats[seatNumber].bookSeat(p);//use bookSeat method of the Seat object referenced by the array
			if(seats[seatNumber].getSeatType()==SeatType.FIRSTCLASS)//check what type the seat is that is being booked
	//and decrement the amount of available seats in that section
				this.availableFirst--;
			else
				this.availableEconomy--;	
		
			
		
	}//bookSeat
	
	public void cancelReservation(Passenger p, int seatNumber)throws DataNotFoundException{
		
		if(!passengers.contains(p))//if he isn't in the AL of passengers
			throw new DataNotFoundException("This passenger can not be found.");
		
		//if he was found then continue to cancel the reservation (using method from Seat class)
		//and increment the number of available seats in the section he was sitting in
		seats[seatNumber].cancelReservation(p);
		
		if(seats[seatNumber].getSeatType()==SeatType.FIRSTCLASS)
			this.availableFirst++;
		else
			this.availableEconomy++;
	
		
	}//cancelReservation
	
	/**viewPlaneLayout
	 * @return the ScheduledFlight class info, like a toString() would*/
	public String viewPlaneLayout(){
		StringBuilder sb=new StringBuilder();
		sb.append("Flight #: ");
		sb.append(flightID);
		sb.append("\nDeparture Date:");
		sb.append(departureDate);
		sb.append("\nRemaining available seats: ");
		sb.append(availableEconomy+availableFirst);
		sb.append("\n  First Class:");
		sb.append(availableFirst);
		sb.append("\n  Economy:    "+availableEconomy+"\n");
		
		for(int index=0;index<seats.length;index++){
			sb.append(index+": "+seats[index]);
		}//for
		
		
		return sb.toString();
	}
	

}//class
