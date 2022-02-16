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

import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a wallet of phone cards. 
 * Such a wallet has a name and a composed set of phone cards.
 * @author EECS2030
 *
 */
public class PhoneCardWallet {
	private String name;//initiating var. name
	private Set<PhoneCard> set;//creating a set to store cards
	
	public PhoneCardWallet(String name) {
		this.name = name;//setting name as this wallet's name
		this.set = new HashSet<>();//initiating the set
	}
	
	public PhoneCardWallet(String name, Set<PhoneCard> cardSet) {
		this.name = name;//assigning the name of the wallet
		this.set = new HashSet<>();
		for(int i=0; i<cardSet.size(); i++) {
			this.set.add((PhoneCard) (cardSet.toArray())[i]);//shallow copying individual objects to this wallet
		}
	}
	
	public String getName() {
		return name;//returning this.name
	}
	public Set<PhoneCard> getCardSet() {
		Set<PhoneCard> newWallet = new HashSet<>();
		
		for(int i=0; i<this.set.size(); i++) {
			newWallet.add((PhoneCard) (this.set.toArray())[i]);//shallow copying
		}
		
		return newWallet;//returning a shallow copy of the set of cards 
	}
	public void addCard (PhoneCard card) {
		this.set.add(card);
	}
	public void removeCard (PhoneCard card) {
		if(this.set.contains(card)) {//checking if the set contains given card and removing it if it does
			this.set.remove(card);
		}
	}
	public Set<PhoneCard> filter (CallZone zone, double cost) {
		Set<PhoneCard> newWallet = new HashSet<>();//creating a new set to store filtered cards
		
		for(PhoneCard card : this.set) {
			if(card.getBalance()>=cost && card.isAllowed(zone)) {//checking if the balance is greater than the cost and if the given zone is allowed in the set of cards
				newWallet.add(card);
			}
		}
		return newWallet;
	}
	
	public String toString() {
		String str = "PhoneCardWallet named " + this.getName() + " with cards ";
		for(int i=0; i<this.set.size(); i++) {
			str += this.set.toArray()[i].toString();//adding individual cards as strings
		}
		return str;
	}
	
	public int hashCode() {
		return this.name.hashCode() + this.set.hashCode();//adding hashcodes of wallets name and card set.
	}
	
	public boolean equals(Object obj) {
		boolean result = true;
		PhoneCardWallet card = (PhoneCardWallet)obj;
		if(this.name.equals(card.getName())){//checking if the names are the same
			for(int i=0; i<this.set.size(); i++) {
				if (!((this.set.toArray()[i]).equals(card.getCardSet().toArray()[i]))) {//checking if the cards are equal
					result = false;
					break;
				}
			}
		}
		else {result = false;}
		return result;
	}
}
