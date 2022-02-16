package Lab6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ContainerTester {

	@Test
	void testPush_1() {
		Stack stack = new Stack(); 
		stack.push("A");
		stack.push("B");
		stack.push("C");
		int expected = 3; 
		int actual = stack.getSize();
		assertEquals(expected, actual, "The stack does not push the objects correctly!");
	}

	@Test
	void testPush_2() {
		Stack stack = new Stack(); 
		String str = "A"; 
		for (int i = 0; i < 26; i++) {
			str = str + String.valueOf(i);
			stack.push(str);
		}
		int expected = 26; 
		int actual = stack.getSize();
		assertEquals(expected, actual, "The stack does not push the objects correctly!");
	}
	
	@Test
	void testPush_3() {
		Stack stack = new Stack(); 
		int expected = 0; 
		int actual = stack.getSize();
		assertEquals(expected, actual, "The stack expected to be empty!");
	}
	
	@Test
	void testPop_1() {
		Stack stack = new Stack(); 
		stack.push("A");
		stack.push("B");
		stack.push("C");
		String expected = "C";
		String actual = (String) stack.pop(); 
		String message = "The stack pops" + actual+ ", while "+ expected + "is expected";
		assertEquals(expected, actual, message);
	}

	@Test
	void testPop_2() {
		Stack stack = new Stack(); 
		stack.push("A");
		String expected = "A";
		String actual = (String) stack.pop(); 
		String message = "The stack pops" + actual+ ", while "+ expected + "is expected";
		assertEquals(expected, actual, message);
	}
	@Test
	void testPop_3() {
		Stack stack = new Stack(); 
		String str = "A"; 
		for (int i = 0; i < 26; i++) {
			str = str + String.valueOf(i);
			stack.push(str);
			str = "A"; 
		}
		String expected = "A25";
		String actual = (String) stack.pop(); 
		String message = "The stack pops" + actual+ ", while "+ expected + "is expected";
		assertEquals(expected, actual, message);
	}
	@Test
	void testgetSize_1() {
		Stack stack = new Stack(); 
		stack.push("A");
		stack.push("B");
		stack.push("C");
		int expected = 2;
		stack.pop(); 
		int actual = stack.getSize();
		String message = "The stack size should be " + expected+ ", while "+ actual + "is given";
		assertEquals(expected, actual, message);
	}
	@Test
	void testgetSize_2() {
		Stack stack = new Stack(); 
		stack.push("A");
		stack.pop(); 
		int expected = 0;
		int actual = stack.getSize();
		String message = "The stack size should be " + expected+ ", while "+ actual + "is given";
		assertEquals(expected, actual, message);
	}
	
	@Test
	void testgetSize_3() {
		Stack stack = new Stack(); 
		String str = "A"; 
		for (int i = 0; i < 26; i++) {
			str = str + String.valueOf(i);
			stack.push(str);
			str = "A"; 
		}
		stack.pop(); 
		int expected = 25;
		int actual = stack.getSize();
		String message = "The stack size should be " + expected+ ", while "+ actual + "is given";
		assertEquals(expected, actual, message);
	}
	@Test
	void testTop_1() {
		Stack stack = new Stack(); 
		stack.push("A");
		stack.push("B");
		stack.push("C");
		String actual = (String) stack.top(); 
		boolean equal = (actual.compareTo("C") == 0) && stack.getSize() == 3;
		String message = "The stack top() does not work properly. ";
		assertEquals(true, equal, message);
	}

	@Test
	void testTop_2() {
		Stack stack = new Stack(); 
		stack.push("A");
		String actual = (String) stack.top(); 
		boolean equal = (actual.compareTo("A") == 0) && stack.getSize() == 1;
		String message = "The stack top() does not work properly. ";
		assertEquals(true, equal, message);
	}
	@Test
	void testTop_3() {
		Stack stack = new Stack(); 
		String str = "A"; 
		for (int i = 0; i < 26; i++) {
			str = str + String.valueOf(i);
			stack.push(str);
			str = "A"; 
		}
		String actual = (String) stack.top(); 
		boolean equal = (actual.compareTo("A25") == 0) && stack.getSize() == 26;
		String message = "The stack top() does not work properly. ";
		assertEquals(true, equal, message);
	}

}
