package airline;
import exceptions.*;

public class Seat {

	private boolean available;
	private Passenger passenger;
	private SeatType section;
	
	/**Constructor
	 * @param section the seat type (economy or first class)*/
	public Seat(String section){
		//passed seatType as a string
		available=true;
		passenger=null;
		this.section=SeatType.valueOf(section);
		
	}
	
	/**bookSeat: to book a seat for a passenger
	 * @param p the passenger who wants a seat
	 * @exception SeatNotAvailableException if the requested seat is already booked*/
	public void bookSeat(Passenger p) throws SeatNotAvailableException{
		if(this.available==true)//if seat is available
		{
			this.available=false;//make it not available
			this.passenger=p;//and set the passenger field to the passenger parameter
		}
		else
			throw new SeatNotAvailableException();
	}//bookSeat
	
	/**cancelReservation: to cancel a passenger's booking
	 * @param p the Passenger
	 * @exception DataNotFoundException if the passenger can not be found*/
	public void cancelReservation(Passenger p)throws DataNotFoundException{
		
		if(!this.passenger.equals(p))
		{
			throw new DataNotFoundException("This passenger can not be found.");
		}
		else
		{
			available=true;//make seat available again
			passenger=null;//set passenger field to null because there is no one booked for this seat
		}
			
	}//cancelReservation
	
	/**isAvailable: checks if the seat is available or not
	 * @return true if it is available false if it isn't*/
	public boolean isAvailable(){
		if(this.available==true)
			return true;
		else
			return false;
	}//isAvailable()
	
	/**getSeatType
	 * @return section the seat type/section of the seat (economy or first class)*/
	public SeatType getSeatType(){
		return this.section;
	}//getSeatType
	
	/**getPassenger
	 * @return the Passenger object*/
	public Passenger getPassenger(){
		
		return this.passenger=new Passenger(passenger);//deep copy
		
	}//getPassenger()
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(section+" seat");
		
		if(available){
			sb.append("\t Available\n");
		}
		else{
			sb.append("\t Not available:");
			sb.append(" Passenger "+passenger.getID()+"\n");
		}
		return sb.toString();
	}
	
	
}//class
