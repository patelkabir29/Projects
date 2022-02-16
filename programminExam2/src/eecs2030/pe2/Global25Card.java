package eecs2030.pe2;

import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a phone card for making calls all over the world.
 * For calls to Canada the cost per minute is $0.05, for calls to
 * the USA the cost per minute is $0.10, for calls to Europe, Latin America,
 * and Australia and New Zealand, the cost
 * per minute is $0.15, and for calls to Asia, the cost per minute is $0.20.
 * The initial balance on the card is $25.00. The weekly
 * fees are $0.50.
 * 
 * <p>
 * Each card also keeps track of what call zones have been called in the past and charged on the card.
 * Initially, the set of called zones is empty. If a call to Canada is charged to the card,
 * the set of called zones would become { CallZone.CANADA }.  If three more calls are then charged
 * one to the USA, one to Canada and one to Europe, the set of called zones would then become
 * { CallZone.CANADA, CallZone.USA, CallZone.EUROPE }.  The relation between the Global25Card
 * object and the set of called zones is composition.
 * 
 * @author EECS2030
 * 
 */
public class Global25Card extends PhoneCard
{
	/**
	 * The initial balance for Global25 cards.
	 */
	public static final double INITIAL_BALANCE = 25.0;
	
	/**
	 * The weekly fee for Global25 cards.
	 */
	public static final double WEEKLY_FEES = 0.5;
	
	/**
	 * The cost per minute for calls to Canada for Global25 cards.
	 */
	public static final double COST_PER_MIN_TO_CANADA = 0.05;
	
	/**
	 * The cost per minute for calls to the USA for Global25 cards.
	 */
	public static final double COST_PER_MIN_TO_USA = 0.1;
	
	/**
	 * The cost per minute for calls to Europe for Global25 cards.
	 */
	public static final double COST_PER_MIN_TO_EUROPE = 0.15;
	/**
	 * The cost per minute for calls to Latin America for Global25 cards.
	 */
	public static final double COST_PER_MIN_TO_LATINAM = 0.15;
	/**
	 * The cost per minute for calls to Australia and New Zealand for Global25 cards.
	 */
	public static final double COST_PER_MIN_TO_ANZ = 0.15;
	/**
	 * The cost per minute for calls to Asia for Global25 cards.
	 */
	public static final double COST_PER_MIN_TO_ASIA = 0.20;

	private Set<CallZone> calledZones;
	
	/**
	 * Create a Global25Card phone card with the given number and password.
	 * Initializes the set of called zones to the empty set.
	 * Also initializes the balance.
	 * 
	 * @param number The phone card's number.
	 * @param password The phone card's password.
	 * @pre. number and password are positive.
	 */
	public Global25Card(long number, int password)
	{
		super(number, password, Global25Card.INITIAL_BALANCE);
		this.calledZones = new HashSet<CallZone>();
	}
	
	/**
	 * Get the Set of call zones that have been called in the past and charged to this card.
	 * The client can modify the returned Set without changing the state of the card.
	 * 
	 * @return A Set containing the call zones that have been called in the past and charged to this card.
	 */
	public Set<CallZone> getCalledZones()
	{
		return new HashSet<CallZone>(this.calledZones);
	}
	
	/**
	 * Get the set of call zones that can be called on this phone card. For
	 * Global25Card phone cards, calls to all zones are allowed.
	 * 
	 * @return the set of call zones that can be called on this card.
	 */
	@Override
	public Set<CallZone> allowedZones()
	{
		return CallZone.getAllZones();
	}

	/**
	 * Get the cost per minute of a call to the argument zone on this phone card.
	 * 
	 * @param zone The call zone to find the cost for.
	 * 
	 * @return The cost per minute to call the given call zone.
	 * @pre. zone is not null and a call to zone is allowed for this card.
	 * 
	 */
	@Override
	public double costPerMin(CallZone zone)
	{
		assert this.isAllowed(zone);
	    if(zone == CallZone.CANADA)
	    {
	    	return Global25Card.COST_PER_MIN_TO_CANADA;
	    }
	    else if(zone == CallZone.USA)
	    {
	        return Global25Card.COST_PER_MIN_TO_USA;
	    }
	    else if(zone == CallZone.ASIA)
	    {
	        return Global25Card.COST_PER_MIN_TO_ASIA;
	    }else
	    {
	    	assert (zone == CallZone.EUROPE || zone == CallZone.LATINAM || zone == CallZone.ANZ);
	    	return Global25Card.COST_PER_MIN_TO_LATINAM;
	    }
	}

	/**
	 * Deduct the appropriate weekly fees from the card's balance. If the
	 * balance is insufficient, the balance becomes 0.
	 * 
	 */
	@Override
	public void deductWeeklyFee()
	{
		this.setBalance(Math.max(0, this.getBalance() - Global25Card.WEEKLY_FEES));
	}

	/**
	 * Check whether a call to the argument zone is allowed for this phone card.
	 * For Global25Card phone cards, calls to all zones are allowed.
	 * 
	 * @param zone the call zone to check.
	 * @return true if the card supports the call zone; false otherwise.
	 * @pre. zone is not null.
	 */
	@Override
	public boolean isAllowed(CallZone zone)
	{
		return true;
	}

	/**
	 * Compares the card with another object for equality. Two Global25 cards are equal
	 * if and only if their PhoneCard sub-objects are equal and their sets of
	 * called zones are equal.
	 * 
	 * @param obj the object to compare with for equality.
	 * @return true if the card and object are equal; false otherwise.
	 * 
	 */
	@Override public boolean equals(Object obj)
	{
		boolean eq = super.equals(obj);
		if(eq)
		{
			Global25Card other = (Global25Card) obj;
			if(!this.getCalledZones().equals(other.getCalledZones()))
			{
				eq = false;
			}
		}
		return eq;
	}
}
