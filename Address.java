package airline;
public class Address {
	
	//fields
	private String street;
	private String city;
	private USState state;
	private String zipcode;
	
	/**Constructor
	 * @param street the street address
	 * @param city the city
	 * @param state the state
	 * @param zipcode the zip code*/
	public Address(String street, String city, String state,String zipcode)
	{
		this.street=street;
		this.city=city;
		String stateTemp=state.replaceAll("\\s","").toUpperCase();
		this.state=USState.valueOf(stateTemp);
		this.zipcode=zipcode;
		
	}
	
	
	/**Copy Constructor
	 * @param adr an Address object to copy*/
	public Address(Address adr)
	{
		this.street=adr.street;
		this.city=adr.city;
		this.state=adr.state;
		this.zipcode=adr.zipcode;
		
	}
	
	
	/**getCity
	 * @return the city*/
	public String getCity()
	{
		return this.city;
	}
	

	/**getState
	 * @return the state*/
	public String getState()
	{
		return this.state.toString();
	}
	

	/**getZipCode
	 * @return the zip code*/
	public String getZipCode()
	{
		return this.zipcode;
	}


	/**getStreet
	 * @return the street*/
	public String getStreet()
	{
		return this.street;
	}
	
	/**setCity
	 * @param the city to set the field to*/
	public void setCity(String city)
	{
		this.city=city;
	}
	
	/**setState
	 * @param state the state*/
	public void setState(String state){
		this.state=USState.valueOf(state);
		
	}
	
	/**setStreet
	 * @param street the street*/
	public void setStreet(String street)
	{
		this.street=street;
	}
	
	/**setZipCode
	 * @param zipcode the zip code*/
	public void setZipCode(String zipcode)
	{
		this.zipcode=zipcode;
	}
	
	@Override
	public String toString()
	{
		StringBuilder strbldr=new StringBuilder();
		
		strbldr.append(street);
		strbldr.append("\n"+city+", ");
		strbldr.append(state.getSymbol());
		strbldr.append(" "+ zipcode);
		return strbldr.toString();
	}
	
}//class
