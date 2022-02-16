package eecs2030.pe2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PhoneCardWalletTester {
	@Test
	public void testConstructor1() {
		PhoneCardWallet w = new PhoneCardWallet("XYZ");
		assertTrue("1 argument constructor sets name wrong", w.getName().equals("XYZ"));
	}
	
	@Test
	public void testConstructor2() {
		Set<PhoneCard> cset = new HashSet<PhoneCard>();
		cset.add(new Global25Card(456456,45678));
		PhoneCardWallet w = new PhoneCardWallet("XYZ",cset);
//		System.out.println( w.getCardSet().toString()+ w.getName());
		assertTrue("2 argument constructor assigns card set wrong", w.getCardSet().equals(cset) && w.getName().equals("XYZ"));
	}
	
	@Test
	public void testAdd() {
		Set<PhoneCard> cset = new HashSet<PhoneCard>();
		cset.add(new Global25Card(456456,45678));
		PhoneCardWallet w = new PhoneCardWallet("XYZ",cset);
		PhoneCard card = new Global25Card(567567,56789);
		cset.add(card);
		w.addCard(card);
		assertTrue("adding card fails", w.getCardSet().equals(cset));
	}
	
	@Test
	public void testRemove() {
		Set<PhoneCard> cset = new HashSet<PhoneCard>();
		cset.add(new Global25Card(456456,45678));
		PhoneCardWallet w = new PhoneCardWallet("XYZ",cset);
		PhoneCard card = new Global25Card(567567,56789);
		w.addCard(card);
		w.removeCard(card);
		assertTrue("removing card fails", w.getCardSet().equals(cset));
	}
	
	@Test
	public void testFilter1() {
		Set<PhoneCard> cset = new HashSet<PhoneCard>();
		cset.add(new Global25Card(456456,45678));
		cset.add(new Global25Card(567567,56789));
		PhoneCardWallet w = new PhoneCardWallet("XYZ",cset);
//		System.out.println( w.filter(CallZone.EUROPE, 10.0));
		assertTrue("filter fails", w.filter(CallZone.CANADA, 15.0).equals(cset));
	}
	
	@Test
	public void testFilter2() {
		Set<PhoneCard> cset = new HashSet<PhoneCard>();
		Set<PhoneCard> c2set = new HashSet<PhoneCard>();
		c2set.add(new Global25Card(456456,45678));
		c2set.add(new Global25Card(567567,56789));
		
		cset.add(new Global25Card(456456,45678));
		cset.add(new Global25Card(567567,56789));
		cset.add(new SmartAmericas10Card(5217567,5671289));
		cset.add(new SmartAmericas10Card(56312567,526789));
		
		PhoneCardWallet w = new PhoneCardWallet("XYZ",cset);
//		System.out.println( w.filter(CallZone.EUROPE, 20.0).toString());
		
		assertTrue("filter fails", w.filter(CallZone.EUROPE, 20.0).equals(c2set));
	}
	
	@Test
	public void testHashCode() {
		PhoneCardWallet w1 = new PhoneCardWallet("XYZ");
		PhoneCardWallet w2 = new PhoneCardWallet("XYZ");
		PhoneCard card = new Global25Card(567567,56789);
		w1.addCard(card);
		w2.addCard(card);
		assertTrue("hashCode fails", w1.hashCode() == w2.hashCode());
	}
	@Test
	public void testEquals() {
		PhoneCardWallet w1 = new PhoneCardWallet("XYZ");
		PhoneCardWallet w2 = new PhoneCardWallet("XYZ");
		PhoneCard card = new Global25Card(567567,56789);
		w1.addCard(card);
		w2.addCard(card);
		assertTrue("equals fails", w1.equals(w2));
	}
}
