package airline;

public class TravelAgent extends Person {
	
	private int employeeID;
    private double earnings;
    private String socialSecurityNumber;
    private static double commissionRate=0.2;
    
    /**Constructor
     * @param empID the travel agent's employee ID number
     * @param sSnum the travel agent's social security number
     * @param first the first name
	 * @param last the last name
	 * @param gender m or f (male or female)
	 * @param street
	 * @param city 
	 * @param state 
	 * @param zip 
	 * @param phone the phone number*/
    public TravelAgent(int empID, String sSNum, String first, String last, char gender, String street, String city, String state, String zip, String phone){
    	super(first,last,gender,street, city, state, zip,phone);
    	this.employeeID=empID;
    	this.socialSecurityNumber=sSNum;
    	this.earnings=0;
    	
    }

    /**bookTicket: calculates the travel agent's earnings
     * @param ticketPrice the price of the ticket booked*/
    public void bookTicket(double ticketPrice){
    	this.earnings=ticketPrice*commissionRate;
    }
    
    /**getEmployeeID
     * @return the travel agent's id*/
    public int getEmployeeID(){
    	return this.employeeID;
    }
    
    /**getEarnings
     * @return the travel agent's earnings*/
    public double getEarnings(){
    	return this.earnings;
    }
    
    /**getSocialSecurityNumber
     * @return socialSecurityNumber the travel agent's social security number*/
    public String getSocialSecurityNumber(){
    	return this.socialSecurityNumber;
    }
    
    /**getCommissionRate
     * @return the commission rate of all travel agents*/
    public double getCommissionRate(){
    	return this.commissionRate;
    }
    
    /**compareTo method to compare travel agents ids*/
    public int compareTo(TravelAgent other){
    	if(this.employeeID<other.employeeID)
    		return -1;
    	else if(this.employeeID>other.employeeID)
    		return 1;
    	else
    		return 0;
    	
    }
    
    @Override
    public boolean equals(Object obj){
    	if (this==obj)
    		return true;
    	if(obj==null)
    		return false;
    	if(obj.getClass()!=this.getClass())
    		return false;
    	TravelAgent other=(TravelAgent) obj;
    	if(other.employeeID==this.employeeID)
    		return true;
    	else
    		return false;
    	
    	
    }
    
    @Override
    public String toString(){
    	StringBuilder sb=new StringBuilder();
    	sb.append("Travel Agent ID #: "+employeeID);
    	sb.append("\n");
    	//I don't want the social security number printed
    	sb.append(super.toString());
    	
    	return sb.toString();
    	
    }
    
    
    
}//class
