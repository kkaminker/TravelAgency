package airline;

import java.time.*;
import exceptions.*;
public class CreditCard {
	
	private double balance;
	private String creditCardID;
	private double creditLimit;
	private LocalDate expirationDate;
	private int pin;
	
	/**Constructor
	 * @param ID the credit card id
	 * @param expirationDate the date the credit card expires
	 * @param pin the credit card pin number
	 * @exception CardExpiredException if the credit card expired*/
	public CreditCard(String ID,String expirationDate,int pin)throws CardExpiredException
	{
		this.creditCardID=ID;
		if(LocalDate.parse(expirationDate).isBefore(LocalDate.now()))
			throw new CardExpiredException();
		this.expirationDate= LocalDate.parse(expirationDate); 
		this.pin=pin;
		this.balance=0;
		this.creditLimit=5000;
	}
	
	/**Copy Constructor
	 * @param card the CreditCard object to copy*/
	
	public CreditCard(CreditCard card){
		this.creditCardID=card.creditCardID;
		this.expirationDate=card.expirationDate;
		this.pin=card.pin;
		this.balance=card.balance;
		creditLimit=5000;
	}
	
	/**getPin
	 * @return pin the pin number*/
	public int getPin(){
		return this.pin;
	}
	
	/**addCharge: to charge the credit card
	 * @param charge the amount to charge
	 * @param pin the card's pin number
	 * @exception InvalidPinException if the pin does not match
	 * @exception InsufficientFundsException if goes over the credit limit
	 * @exception CardExpiredException if the card expired*/
	public void addCharge(double charge,int pin)throws InvalidPinException, InsufficientFundsException, CardExpiredException
	{
		if (this.pin!=pin)
			throw new InvalidPinException();
		if(expirationDate.isBefore(LocalDate.now()))
			throw new CardExpiredException();
		if(creditLimit-balance<=charge)
			throw new InsufficientFundsException("InsufficientFundsException: we can not process this charge as it exceeds the credit limit.");
		else
		    this.balance+=charge;//increase balance
	}
	
	/**getBalance
	 * @return balance the credit card balance*/
	public double getBalance(){
		return this.balance;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("Credit Card Number: "+creditCardID+"\nExp Date: "+expirationDate);
		
		return sb.toString();
	}
	
	
}//class
