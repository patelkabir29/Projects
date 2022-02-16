package Lab7;
import java.util.Date;
import java.util.Objects;




public abstract class Account {
	protected int accountNo;
	protected double balance;
	protected String fullName;
	protected Date dateOpened;
	protected double maxTransferable;
	
	Account(int accountNo, double balance, String fullName, Date dateOpened, double maxTransferable) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.fullName = fullName;
		this.dateOpened = dateOpened;
		this.maxTransferable = maxTransferable;
	}
	
	/**
	 * This method deposit <code> amount </code> to this account.
	 * @param amount is the amount that is deposited to this account. 
	 */
	public void deposit (double amount) {
		this.balance = this.balance + amount;
	}
	/**
	 * This method withdraw <code> amount </code> from this account.
	 * @param amount is the amount that should be withdrawn from this account
	 * @return It returns true of the transaction is done successfully. 
	 * @throws Exception This methods may throw either <code> NotEnoughMoneyException </code> or
	 * <code> TransferNotAllowedException </code>.
	 */
	public boolean withdraw(double amount) throws Exception {
		boolean var = false;
		
		if (amount > this.balance) throw new NotEnoughMoneyException("Not enough money");
		else if (amount > this.maxTransferable) throw new TransferNotAllowedException("Cannot withdraw more than the limit");
		else {
			this.balance = this.balance - amount;
			var = true;
		}
		return var;
	}
	/**
	 * This method transfer money from this account to the given account.
	 * @param to is the account that the money is deposited to.
	 * @param amount is the amount of money that is transfered. 
	 * @return It returns true if transaction is successful. 
	 * @throws Exception This methods may throw either <code> NotEnoughMoneyException </code> or
	 * <code> TransferNotAllowedException </code>.
	 */
	public boolean transferFrom(Account to, double amount) throws Exception{
		boolean var = true;
		
		if (amount > this.balance) throw new NotEnoughMoneyException("Not enough money");
		else if (amount > this.maxTransferable) throw new TransferNotAllowedException("Cannot withdraw more than the limit");
		else {
			to.balance = to.balance + amount;
			this.balance = this.balance - amount;
			var = true;
		}
		return var;
		
	}
	/**
	 * This is the accessor method for <code> accountNo </code>
	 * @return It returns the accountNo of the account.
	 */
	public int getAccountNo() {
		return this.accountNo;
	}
	/**
	 * This is the accessor method for <code> balance </code>
	 * @return It returns the balance of the account.
	 */
	public double getBalance() {
		return this.balance;
	}
	/**
	 * This is the accessor method for <code> fullName </code>
	 * @return It returns the name of the holder of the account.
	 */
	public String getFullName() {
		return this.fullName;
	}
	/**
	 * This is the accessor method for <code> dateOpened </code>
	 * @return It returns the date at which the account was opened.
	 */
	public Date getDateOpened() {
		return this.dateOpened;
	}
	/**
	 * This is the accessor method for <code> maxTransferable </code>
	 * @return It returns the maximum allowed amount that can be withdrawn from this account.
	 */
	public double getmaxTransferable() {
		return this.maxTransferable;
	}
	/**
	 * This method compares to account. If two accounts have the same values
	 * for all the instance variables, they are considered, equal and this 
	 * method returns 0. If two objects were not equal, the account whose accountNo is less, 
	 * is the smaller object so this method returns -1. Otherwise it returns 1.
	 * @param object is an object of type account. 
	 * @return It returns 0, if two objects are equal. 
	 * It returns -1, if this object is less than the object that is passed as a parameter into the method. 
	 * It returns 1, if this object is greater than the object that is passed as a parameter into the method. 
	 */
	public int compareTo(Object object) {
		Account obj = (Account) object;
		int n;
		
		if (this.accountNo == obj.accountNo && this.balance == obj.balance && this.dateOpened == obj.dateOpened && this.fullName == obj.fullName && this.maxTransferable == obj.maxTransferable) {
			n = 0;
		}
		else if (this.accountNo < obj.accountNo) {
			n = -1;
		}
		else {
			n = 1;
		}
		return n;
	}
}

class NotEnoughMoneyException extends Exception {
	public NotEnoughMoneyException (){
		super();
	}

	public NotEnoughMoneyException(String string) {
		super(string);
	}
}
class TransferNotAllowedException extends NotEnoughMoneyException {
	public TransferNotAllowedException() {
		super();
	}

	public TransferNotAllowedException(String string) {
		super(string);
	}
}

class Current extends Account {
	Current(int accountNo, double balance, String fullName, Date dateOpened, double maxTransferable) {
		super(accountNo, balance, fullName, dateOpened, maxTransferable);
	}
}