package Lab4;

/**
 * This class implements a game like 'among us'
 *
 */
public class Game {
	private Player[] player;// = new Player[10];
	private Map map;
	// your code goes here
	
	/**
	 * This is the default constructors. 
	 * At most 10 player can play this game. 
	 * At most there are 4 areas that players can play in.
	 */
	public Game() {
		// your code goes here
		this.player = new Player[0];
		this.map = new Map();
	}
	
	/**
	 * This is the overloaded constructor for this class
	 * @param player is an array containing all the players who entered the game.
	 * @param map is the area that is available to the players to play.
	 */
	
	public Game (Player [] player, Map map) {
		// your code goes here
		this.player = new Player[player.length];
		for(int i=0; i<player.length; i++) {
			this.player[i] = player[i];
		}
		this.map = new Map(map);
	}
	/**
	 * This the copy constructor for this class
	 * @param game is an object of Game, whose component is deeply copied into 
	 * the component of this object.
	 */

	public Game (Game game) {
		// your code goes here
		this(game.getPlayer(), game.getMap());
	}
	/**
	 * This is the getter method for the player list.
	 * @return returns an array containing all the players of this game. 
	 */
	public Player[] getPlayer() {
		// your code goes here - change the return
		Player[] newPlayer = new Player[this.player.length];
		
		for(int i=0; i<this.player.length; i++) {
			newPlayer[i] = this.player[i];
		}
		return newPlayer;
	}
	/**
	 * This is the getter method for the map attribute.
	 * @return Returns an object of map containing all the components of this game's map.
	 */

	public Map getMap() {
		// your code goes here - change the return
		return new Map(this.map);
	}
	/**
	 * This is the setter method for the player attribute, which deeply copies 
	 * the input parameter into the player attribute of this object. 
	 * @param player is an array of Player, whose elements are copied in the player attribute of this object.
	 */
	
	public void setPlayer(Player [] player) {
		// your code goes here
		this.player = new Player[player.length];
		for(int i=0; i<player.length; i++) {
			this.player[i] = new Player(new String(player[i].name), player[i].role);
		}
	}
	/**
	 * This is the setter method for the map attribute, which deeply copies 
	 * the input parameter into the map attribute of this object.
	 * @param map is an object of Map, whose attributes are copied in the map attribute of this object.
	 */
	public void setMap(Map map) {
		// your code goes here
		this.map = new Map(map);
	}

}

/**
 * 
 * This class implements all a player requires to play in this game. 
 *
 */
class Player {
	String name;
	Role role; 

	// your code goes here
	
	
	/**
	 * This the default constructor for this class
	 */
	public Player() {
		// your code goes here
		name = "";
		role = new Role();
	}
	
	/**
	 * This is the overloaded constructor for this class
	 * @param name
	 * @param role
	 */
	public Player(String name, Role role) {
		// your code goes here
		this.name = name;
		this.role = role;
	}
	
	/**
	 * This is the copy constructor for this class
	 * @param player
	 */
	public Player(Player player) {
		// your code goes here
		this(player.name, player.role);
	}
	/**
	 * This is the getter method for attribute name
	 * @return returns the value of attribute name
	 */
	public String getName() {
		// your code goes here - change the return
		return this.name;
	}
	
	/**
	 * This is the getter method for attribute role
	 * @return returns the reference to attribute role.
	 */
	public Role getRole() {
		// your code goes here - change the return
		return this.role;
	}
	
	/**
	 * This is the setter method for attribute name
	 * @param name  is the value that is used to initialize name attribute
	 */
	public void setName(String name) {
		// your code goes here
		this.name = name;
	}
	
	/**
	 * This is the setter method for attribute role
	 * @param role is the object, whose reference is used to initialize attribute role.
	 */
	public void setRole(Role role) {
		// your code goes here
		this.role = role;
	}
	
}
/**
 * This class implements the areas in which players can play.
 *
 */
class Map{
	String theSkeld; 
	String miraHq; 
	String polus;
	String airShip;
	
	/**
	 * This is the default constructor. 
	 */
	public Map() {
		// your code goes here
		this("", "", "", "");
	}
	/**
	 * This is the overloaded constructor.
	 * @param theSkeld is the first area in which player can play.
	 * @param miraHq is the second area in which player can play.
	 * @param polus is the third area in which player can play.
	 * @param airShip  is the fourth area in which player can play.
	 */
	public Map(String theSkeld, String miraHq, String polus, String airShip) {
		// your code goes here
		this.theSkeld = new String(theSkeld);
		this.miraHq = new String(miraHq);
		this.polus = new String(polus);
		this.airShip = new String(airShip);
	}
	/**
	 * This is the copy constructor.
	 * @param map is an object of Map that is used to initialize this object.
	 */
	public Map(Map map) {
		// your code goes here
		this(map.theSkeld, map.miraHq, map.polus, map.airShip);
	}
	
}
/**
 * 
 * This class presents the role of the players, 
 * which can be either imposter or crewmate. 
 *  Imposter role, gets the value of 'i'and 
 *  Cremate gets the value of 'c'
 *
 */
class Role{
	char role; 
	/**
	 * This is the default constructor.
	 */
	public Role() {
		// your code goes here
		role = ' ';
	}
	/**
	 * This is the overloaded constructor.
	 * @param role is used as an initial value of the instance variable role
	 */
	public Role(char role) {
		// your code goes here
		this.role = role;
	}
	/**
	 * This is the copy constructor. 
	 * @param role is an object of Role that is used to initialize the instance variable role.
	 */
	public Role(Role role) {
		// your code goes here
		this.role = role.role;
	}
	public char getRole() {
		// your code goes here - change the return
		return role;
	}
	public void setRole(char role) {
		// your code goes here
		this.role = role;
	}
	
}
