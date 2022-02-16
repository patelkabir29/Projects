package eecs2030.pe2;

import java.util.HashSet;
import java.util.Set;

/**
* A class that specifies a set of call zones for making long distance calls
* using phone cards.  
* The valid call zones are identified by the given static constants.
* 
* @author EECS2030
*
*/
public class CallZone
{
	private String name;
	
	private static Set<CallZone> allZones = new HashSet<CallZone>();
	
	/**
	 * The call zone for Canada.
	 */
	public static final CallZone CANADA = new CallZone("CANADA");
	
	/**
	 * The call zone for the United States.
	 */	
	public static final CallZone USA = new CallZone("USA");
	
	/**
	 * The call zone for Europe.
	 */
	public static final CallZone EUROPE = new CallZone("EUROPE");
	
	/**
	 * The call zone for Asia.
	 */
	public static final CallZone ASIA = new CallZone("ASIA");
	
	/**
	 * The call zone for Australia and New Zeland.
	 */
	public static final CallZone ANZ = new CallZone("ANZ");
	
	/**
	 * The call zone for Latin America.
	 */
	public static final CallZone LATINAM = new CallZone("LATINAM");
	
	/**
	 * The call zone for Africa.
	 */
	public static final CallZone AFRICA = new CallZone("AFRICA");

	private CallZone(String name)
	{
		this.name = name;
		CallZone.allZones.add(this);
	}
	
	/**
	 * Produces the set of all valid call zones.
	 * 
	 * @return the set of all valid call zones.
	 */
	public static Set<CallZone> getAllZones()
	{
		return new HashSet<CallZone>(CallZone.allZones);
	}

	/**
	 * Creates a string representation of the object; the call zone's name is returned.
	 * 
	 * @return the string representation of the object.
	 */
	@Override 
	public String toString()
	{
		return this.name;
	}

	/**
	 * Creates a hash code for the object, which is the hash code of the string
	 * that is the call zone's name.
	 * 
	 * @return the object's hash code.
	 */
	@Override 
	public int hashCode()
	{
		return this.toString().hashCode();
	}
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * The result is true if and only if the argument is not null, is a call zone,
	 * and both objects have the same name.
	 * 
	 * @param obj The object to compare with.
	 * @return true if the call zones' names are equal; false otherwise.
	 */
	@Override 
	public boolean equals(Object obj)
	{
		boolean eq = false;
		if(obj != null && this.getClass() == obj.getClass())
		{
			CallZone other = (CallZone) obj;
			eq = this.toString().equals(other.toString());
		}
		return eq;
	}
}
