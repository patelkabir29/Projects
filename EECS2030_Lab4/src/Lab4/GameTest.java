package Lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {


	@Test
	void testRole1() {
		Role role = new Role(); 
		boolean expected = true;
		boolean actual = (role.role == ' ') && (role.role == role.getRole());
		assertEquals(actual, expected, "The role is not initialized correctly by the default constructor of the Roll class..");
	}

	@Test
	void testRole2() {
		Role role = new Role('C'); 
		boolean expected = true;
		boolean actual = (role.role == 'C') && (role.role == role.getRole());
		assertEquals(actual, expected, "The role is not initialized correctly by the overloaded constructor of the Roll class..");
	}
	@Test
	void testRole3() {
		Role role1 = new Role('I'); 
		Role role2 = new Role(role1);
		boolean expected = true;
		boolean actual = (role2.role == 'I') && (role2.role == role1.getRole()) &&( role2.role == role1.role);
		assertEquals(actual, expected, "The role is not initialized correctly by the copy constructor of the Roll class.");
	}
	@Test
	void testMap1() {
		Map map = new Map(); 
		boolean expected = true;
		boolean actual = (map.theSkeld.compareTo("") == 0) && (map.miraHq.compareTo("") == 0) 
				&& (map.polus.compareTo("") == 0) && (map.airShip.compareTo("") == 0);
		assertEquals(actual, expected, "The map is not initialized correctly by the default constructor of the Map class.");
	}
	@Test
	void testMap2() {
		Map map = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		boolean expected = true;
		boolean actual = (map.theSkeld.compareTo("theSkeld") == 0) && (map.miraHq.compareTo("miraHq") == 0) && 
				(map.polus.compareTo("polus") == 0) && (map.airShip.compareTo("airShip") == 0);
		assertEquals(actual, expected, "The map is not initialized correctly by the overloaded constructor of the Map class.");
	}
	@Test
	void testMap3() {
		Map map1 = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		Map map2 = new Map(map1); 
		boolean expected = true;
		boolean actual = (map1.theSkeld.compareTo(map2.theSkeld) == 0) && (map1.miraHq.compareTo(map2.miraHq) == 0) && 
				(map1.polus.compareTo(map2.polus) == 0) && (map1.airShip.compareTo(map2.airShip) == 0);
		assertEquals(actual, expected, "The map is not initialized correctly by the copy constructor of the Map class.");
	}

	@Test
	void testPlayer1() {
		Role role = new Role('I'); 
		Player player = new Player("Jane", role); 
		boolean expected = true;
		boolean actual = (role == player.getRole());
		System.out.println(player.getRole() + "\n" + role.toString());
		assertEquals(actual, expected, "The aggregation relationship is not correcly implemented for the Player class [wrong getter method].");
	}
	@Test
	void testPlayer2() {
		Role role = new Role('C'); 
		Player player = new Player(); 
		player.setRole(role);
		boolean expected = true;
		boolean actual = (role == player.role);
		assertEquals(actual, expected, "The aggregation relationship is not correcly implemented for the Player class.[wrong setter method]");
	}
	@Test
	void testPlayer3() {
		Role role = new Role('C'); 
		Player player1 = new Player("Jane", role); 
		Player player2 = new Player(player1);
		boolean expected = true;
		boolean actual = (player1.getRole() == player2.getRole()) && (player2.getRole() == role);
		assertEquals(actual, expected, "The aggregation relationship is not correcly implemented in the copy constructor, for role attribute in Player class.");
	}
	@Test
	void testPlayer4() {
		Role role = new Role('C'); 
		Player player1 = new Player("Jane", role); 
		Player player2 = new Player("Jane", role);
		boolean expected = true;
		boolean actual = (player1.getName() == player2.getName());
		assertEquals(actual, expected, "The aggregation relationship is not correctly implemented for name in Player class.");
	}
	
	@Test
	void testPlayer5() {
		Role role = new Role('I'); 
		Player player1 = new Player(new String("Jane"), role); 
		Player player2 = new Player("Jane", role);
		boolean expected = true;
		boolean actual = (player1.getName() != player2.getName());
		assertEquals(actual, expected, "The aggregation relationship is not correctly implemented for name in Player class.");
	}
	@Test
	void testGame1() {
		Role role1 = new Role('C'); 
		Player player1 = new Player("Jane", role1); 
		Role role2 = new Role('I'); 
		Player player2 = new Player("John", role2); 
		Player [] player = new Player[2]; 
		player[0] = player1; 
		player[1] = player2;
		Map map = new Map(); 
		
		Game game = new Game(player, map); 
		boolean expected = true;
		boolean actual = (game.getPlayer() != player);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for the player list in Game class [getPlayer].");
	}
	@Test
	void testGame2() {
		Role role1 = new Role('C'); 
		Player player1 = new Player("Jane", role1); 
		Role role2 = new Role('I'); 
		Player player2 = new Player("John", role2); 
		Player [] player = new Player[2]; 
		player[0] = player1; 
		player[1] = player2;
		Map map = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		
		Game game = new Game(player, map); 
		boolean expected = true;
		boolean actual = (game.getMap() != map);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for the map attribute in Game class [getMap].");
	}
	@Test
	void testGame3() {
		Role role1 = new Role('C'); 
		Player player1 = new Player("Jane", role1); 
		Role role2 = new Role('I'); 
		Player player2 = new Player("John", role2); 
		Player [] player = new Player[2]; 
		player[0] = player1; 
		player[1] = player2;
		Map map = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		
		Game game = new Game();
		game.setMap(map);
		game.setPlayer(player);
		boolean expected = true;
		boolean actual = (game.getMap() != map) && (game.getPlayer() != player);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for map in Game class [setMap and setPlayer].");
	}
	@Test
	void testGame4() {
		Role role1 = new Role('C'); 
		Player player1 = new Player("Jane", role1); 
		Role role2 = new Role('I'); 
		Player player2 = new Player("John", role2); 
		Player [] player = new Player[2]; 
		player[0] = player1; 
		player[1] = player2;
		Map map = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		
		Game game = new Game();
		game.setMap(map);
		game.setPlayer(player);
		boolean expected = true;
		boolean actual = (game.getMap().airShip != map.airShip);
		System.out.println(game.getMap().airShip + "\n" + map.airShip);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for map in Game class [setMap].");
	}
	@Test
	void testGame5() {
		Role role1 = new Role('C'); 
		Player player1 = new Player("Jane", role1); 
		Role role2 = new Role('I'); 
		Player player2 = new Player("John", role2); 
		Player [] player = new Player[2]; 
		player[0] = player1; 
		player[1] = player2;
		Map map = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		
		Game game = new Game();
		game.setMap(map);
		game.setPlayer(player);
		boolean expected = true;
		boolean actual = (game.getPlayer()[0].name != player[0].name);
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for map in Game class [setPlayer].");
	}

	@Test
	void testGame6() {
		Role role1 = new Role('C'); 
		Player player1 = new Player("Jane", role1); 
		Role role2 = new Role('I'); 
		Player player2 = new Player("John", role2); 
		Player [] player = new Player[2]; 
		player[0] = player1; 
		player[1] = player2;
		Map map = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		
		Game game1 = new Game(player, map);
		Game game2 = new Game(player, map);
		boolean expected = true;
		boolean actual = (game1.getPlayer() != game2.getPlayer());
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for player array in Game class [copy constructor or overloaded constructor].");
	}
	@Test
	void testGame7() {
		Role role1 = new Role('C'); 
		Player player1 = new Player("Jane", role1); 
		Role role2 = new Role('I'); 
		Player player2 = new Player("John", role2); 
		Player [] player = new Player[2]; 
		player[0] = player1; 
		player[1] = player2;
		Map map = new Map("theSkeld", "miraHq", "polus", "airShip"); 
		
		Game game1 = new Game(player, map);
		Game game2 = new Game(player, map);
		boolean expected = true;
		boolean actual = (game1.getMap() != game2.getMap());
		assertEquals(actual, expected, "The Composition relationship is not correctly implemented for map in Game class [copy constructor or overloaded constructor].");
	}

}
