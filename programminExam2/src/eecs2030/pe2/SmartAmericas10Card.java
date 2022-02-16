/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Kabir Patel
Student Number: 217631318
Course Section: Z
*/


package eecs2030.pe2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A class that represents a smart phone card for the Americas. 
 * For SmartAmericas10 phone cards, only calls to Canada, the USA, and Latin America are allowed. 
 * For calls to Canada the cost per minute is $0.03, for calls to the USA the cost per minute is $0.05, and for calls to Latin America the cost per minute is $0.10. 
 * The initial balance on the card is $10.00. The weekly fees are $0.30. 
 * 
 * <p>Each card also keeps track of the history of calls charged to the card. 
 * The call history is List{@code <}Call>. For example, a brand new card would have as its call history the empty list []. 
 * If the card was then used to call +14167362100 in Canada for 2 minutes, its call history would then become [call to number +14167362100 in zone CANADA for 2 minutes]. 
 * If the card was then used to call +14152121000 in the USA for 2 minutes, its call history would then become [call to number +14167362100 in zone CANADA for 2 minutes, call to number +14152121000 in zone USA for 2 minutes]. 
 * Every time a call is successfully charged to the card, it is added to the call history. 
 * The relation between SmartAmericas10Card and its call history is composition.
 * @author EECS2030
 *
 */
public class SmartAmericas10Card extends PhoneCard {
	/**
	 * The initial balance for SmartAmericas10 cards.
	 */
	public static final double INITIAL_BALANCE = 10.00;
	/**
	 * The weekly fee for SmartAmericas10 cards.
	 */
	public static final double WEEKLY_FEES = 0.30;
	/**
	 * The cost per minute for calls to Canada for SmartAmericas10 cards.
	 */
	public static final double COST_PER_MIN_TO_CANADA = 0.03; 
	/**
	 * The cost per minute for calls to the USA for SmartAmericas10 cards.
	 */
	public static final double COST_PER_MIN_TO_USA = 0.05; 
	/**
	 * The cost per minute for calls to Latin America for SmartAmericas10 cards.
	 */
	public static final double COST_PER_MIN_TO_LATINAM = 0.10;
	
	
	private List<Call> list = new ArrayList<Call>();//added List<Call> list to assign call history
	
	/**
	 * Create a SmartAmericas10Card phone card with the given number and password. 
	 * Sets card's balance to INITIAL_BALANCE and its call history to the empty list.
	 * @param number  the card's number.
	 * @param password  the card's password.
	 * @pre. number and password are positive.
	 */
	public SmartAmericas10Card (long number, int password) { 
		super(number, password, INITIAL_BALANCE); //calls constructor of super method with the initial balance of INITIAL_BALANCE
	} 
	
	/**
	 * Create a copy of the given SmartAmericas10Card. A deep copy is returned.
	 * @param card  the card to make a copy of.
	 * @pre. card is not null.
	 */
	public SmartAmericas10Card (SmartAmericas10Card card) { 
		super(card.getNumber(), card.getPassword(), card.getBalance()); //calls constructor of super method with the initial balance of the other card
	}
	
	/**
	 * Get the history of calls as a List. 
	 * The client can modify the returned List without changing the state of the card.
	 * @return a List containing the call history of the card.
	 */
	public List<Call> getCallHistory(){
		return list; //simply returns the list that is private
	}
	
	/**
	 *Charge the given call to this phone card. 
	 *This method tries to charge the given call to the card. 
	 *If the balance is sufficient to cover it, the call is charged and added to the call history, and the value true is returned. 
	 *If the balance is insufficient, the balance and call history are left unchanged and false is returned. 
	 *The client can later mutate the call without changing the state of the card and its call history.
	 *@overrides charge in class PhoneCard
	 *@param call  the call to charge.
	 *@pre. call is not null and its zone is allowed for this card.
	 *@return true if the balance was sufficient to pay for the call, and false otherwise.
	 */
	@Override
	public boolean charge (Call call) {
		double rateCanada = call.getMinutes()*SmartAmericas10Card.COST_PER_MIN_TO_CANADA; // charge for calls to Canada for given minutes
		double rateUsa = call.getMinutes()*SmartAmericas10Card.COST_PER_MIN_TO_USA; // charge for calls to the USA for given minutes
		double rateLatinam = call.getMinutes()*SmartAmericas10Card.COST_PER_MIN_TO_LATINAM; // charge for calls to Latin America for given minutes
		
		//checking if the zone is Canada
		if((call.getZone().toString()).equals("CANADA")) {
			if(this.getBalance()>=rateCanada) {//checking balance
				this.setBalance(this.getBalance()-rateCanada);//deducting charges
				this.getCallHistory().add(call);//adding to call history
				return true;
			}
			else {
				return false;
			}
		}
		//checking if the zone is USA
		else if((call.getZone().toString()).equals("USA")) {
			if(this.getBalance()>=rateUsa) {//checking balance
				this.setBalance(this.getBalance()-rateUsa);//deducting charges
				this.getCallHistory().add(call);//adding to call history
				return true;
			}
			else {
				return false;
			}
		}
		//checking if the zone is Latin America given that the zones are neither of these three
		else {
			if(this.getBalance()>=rateLatinam) {//checking balance
				this.setBalance(this.getBalance()-rateLatinam);//deducting charges
				this.getCallHistory().add(call);//adding to call history
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 *Compares the card with another object for equality. 
	 *Two cards are equal if and only if their PhoneCard sub-objects are equal and their call histories are equal.
	 *@overrides equals in class PhoneCard
	 *@param obj  the object to compare with for equality.
	 *@return true if the card and object are equal; false otherwise.
	 */
	@Override
	public boolean equals (Object obj) {
		if(this.getCallHistory().equals(((SmartAmericas10Card)obj).getCallHistory())) {//checking if the call histories are equal
			if( (this.getNumber()==((SmartAmericas10Card)obj).getNumber()) && //checking for the euivalence of the numbers
				(this.getPassword()==((SmartAmericas10Card)obj).getPassword())	&&// checking if passwords are the same
				(this.getBalance()==((SmartAmericas10Card)obj).getBalance())) {//finally, checking if the balance in both is the same
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 *Check whether a call to the argument zone is allowed for this phone card. 
	 *For SmartAmericas10 phone cards, only calls to Canada, the USA, and Latin America are allowed.
	 *@specified_by isAllowed in class PhoneCard
	 *@param zone  the call zone to check.
	 *@pre. zone is not null.
	 *@return true if the card supports the call zone; false otherwise.
	 */
	@Override
	public boolean isAllowed(CallZone zone) {
		//checking if zones are CANADA or USA or LATINAM so as to allow them
		if(zone.toString().equals("CANADA") || zone.toString().equals("USA") || zone.toString().equals("LATINAM")) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 *Get the set of call zones that can be called on this phone card. 
	 *For SmartAmericas10 phone cards, only calls to Canada, the USA, and 
	 *Latin America are allowed.
	 *@specified_by allowedZones in class PhoneCard
	 *@return the set of allowed call zones on the card.
	 */
	@Override
	public Set<CallZone> allowedZones() {
		Set<CallZone> set = new HashSet<CallZone>();
		set.add(CallZone.CANADA);
		set.add(CallZone.USA);
		set.add(CallZone.LATINAM);
		return set;//returning a set of allowed zones for SmartAmericas10Card
	}

	/**
	 *Get the cost per minute of a call to the argument zone on this phone card.
	 *@specified_by costPerMin in class PhoneCard
	 *@param zone  the call zone to find the cost for.
	 *@pre. zone is not null and a call to zone is allowed for this card.
	 *@return the cost per minute to call the given call zone.
	 */
	@Override
	public double costPerMin(CallZone zone) {
		// checking for zones and returning respective values
		if (zone.toString().equals("CANADA")) {
			return SmartAmericas10Card.COST_PER_MIN_TO_CANADA;
		}
		else if (zone.toString().equals("USA")) {
			return SmartAmericas10Card.COST_PER_MIN_TO_USA;
		}
		else {
			return SmartAmericas10Card.COST_PER_MIN_TO_LATINAM;
		}
	}

	/**
	 *Deduct the appropriate weekly fees from the card's balance. 
	 *If the balance is insufficient, the balance becomes 0.
	 *@specified_by deductWeeklyFee in class PhoneCard
	 */
	@Override
	public void deductWeeklyFee() {
		// deducting weekly fees if the current balance is greater or equal to the fees
		if(this.getBalance() >= SmartAmericas10Card.WEEKLY_FEES) {
			double newBalance = this.getBalance()-SmartAmericas10Card.WEEKLY_FEES;
			this.setBalance(newBalance);
		}
		//else setting the balance to 0.00
		else {
			this.setBalance(0.00);
		}
	}

}
