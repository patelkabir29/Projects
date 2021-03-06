package eecs2030.pe2;

import java.util.Set;

import eecs2030.pe2.Call;
import eecs2030.pe2.CallZone;
import eecs2030.pe2.PhoneCard;

/**
 * An abstract class that encapsulates information about phone cards.
 * The information includes the card number, password, and balance.
 * 
 * @author EECS2030
 *
 */
public abstract class PhoneCard {
	private long number;
	private int password;
	private double balance;
	
	/* class invariant: 0 < number && 0 < password && 0 <= balance */
	
	/**
	 * Create a phone card with the given number, password, and balance.
	 * 
	 * @param number the phone card's number.
	 * @param password the card's password.
	 * @param balance the card's balance.
	 * @pre. number and password are positive and balance is non negative.
	 */
	public PhoneCard(long number, int password, double balance)
	{ 
		assert 0 < number && 0 < password && 0 <= balance;
		this.number = number;
		this.password = password;
		this.balance = balance;
	}

	/**
	 * Get the number of this phone card.
	 * 
	 * @return the number of this phone card.
	 */
	public long getNumber()
	{
		return this.number;
	}

	/**
	 * Get the password of this phone card.
	 * 
	 * @return the password of this phone card.
	 */
	public int getPassword()
	{
		return this.password;
	}

	/**
	 * Get the balance of this phone card.
	 * 
	 * @return the balance of this phone card.
	 */
	public double getBalance()
	{
		return this.balance;
	}
	/**
	 * Set the balance of this phone card.
	 * 
	 * @param balance the balance to set.
	 * @pre. balance is non negative.
	 */
	public void setBalance(double balance)
	{
		assert 0 <= balance;
		this.balance = balance;
	}

	/**
	 * Check whether a call to the argument zone is allowed for this phone card.
	 * 
	 * @param zone the zone to check.
	 * @return true if calls to this zone is allowed for this phone card, and false otherwise.
	 * @pre. zone is not null.
	 */
	public abstract boolean isAllowed(CallZone zone);
	
	/**
	 * Get the set of call zones that can be called on this phone card.
	 * 
	 * @return the set of allowed call zones.
	 */	
	public abstract Set<CallZone> allowedZones();

	/**
	 * Get the cost per minute of a call to the argument zone on this phone card.
	 * 
	 * @param zone the call zone to find the cost for.
	 * @return the cost per minute.
	 * @pre. zone is not null and a call to zone is allowed for this card.
	 */	
	public abstract double costPerMin(CallZone zone);

	/**
	 * Get the number of minutes allowed for a call to zone given the balance.
	 * This method returns the maximum number of minutes that can be charged for a call
	 * to the argument zone given the card's balance (truncated down to the next integer).
	 * 
	 * @param zone the zone that the call is going to.
	 * @return the maximum number of minutes for a call to the given zone.
	 * @pre. zone is not null and a call to zone is allowed for this card.
	 */
	public int getLimit(CallZone zone)
	{
		assert this.isAllowed(zone);
		return (int) (this.getBalance() / this.costPerMin(zone));
	}
	
	/**
	 * Charge the given call to this phone card.
	 * This method tries to charge a call to zone with the given number of minutes
	 * to the card; if the balance is sufficient to cover it, it returns true and
	 * if the balance is not sufficient, it leaves it unchanged and returns false.
	 * 
	 * @param call the call to charge.
	 * @return true if the balance was sufficient to pay for the call, and false otherwise.
	 * @pre. the call is not null and its zone is allowed for this card.
	 */
	public boolean charge(Call call)
	{  
		assert this.isAllowed(call.getZone());
	    if(call.getMinutes() * this.costPerMin(call.getZone()) > this.getBalance())
	    {
		   return false;
	    }
	    else
	    {
		   this.setBalance(this.getBalance() - call.getMinutes() * this.costPerMin(call.getZone())); 
	       return true;
	    }
	}

	/**
	 * Deduct the appropriate weekly fees from the card's balance.
	 * If the balance is insufficient, the balance becomes 0.
	 */
	public abstract void deductWeeklyFee();

	/**
	 * Creates a hash code for the object. 
	 * The hash code is generated by considering the cards' number.
	 * 
	 * @return the object's hash code.
	 */
	@Override
	public int hashCode() {
		return ((Long)this.getNumber()).hashCode();
	}

	/**
	 * Indicate whether some other object is "equal to" this one.
	 * The result is true if and only if the argument is not null,
	 * has the same class as this object,
	 * and both objects have the same number.
	 * 
	 * @param obj The object to compare with.
	 * @return true if the cards' numbers are equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean eq = false;
		if(obj != null && this.getClass() == obj.getClass())
		{
			PhoneCard other = (PhoneCard) obj;
			eq = this.getNumber() == other.getNumber();
		}
		return eq;
	}
	
	/**
	 * Create a string representation of the object.
	 * The string is "card no " followed by the card's number followed by
	 * " has a balance of " followed by the card's balance.
	 * 
	 * @return the string representation of the object.
	 */
	@Override 
	public String toString()
	{
		String res = "card no " + this.getNumber() + " has a balance of ";
	    res = res + String.format("%.2f", balance);
	    return res;
	}

}
