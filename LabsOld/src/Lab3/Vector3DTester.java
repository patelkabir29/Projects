package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Vector3DTester {
	
	private double rand() {
		return (int) ((Math.random() * 100.0)*10)/10.0;
	}

	private double negRand() {
		return (int) ((Math.random() * 100.0)*10)/-10.0;
	}

	@Test
	void testCnstr1() {
		double r = Math.random(); 
		double x = 0; 
		double y = 0; 
		double z = 0;
		if (r < 0.5) x = negRand(); 
		else x = rand(); 
		r = Math.random(); 
		if (r < 0.5) y = negRand(); 
		else y = rand(); 
		r = Math.random(); 
		if (r < 0.5) z = negRand(); 
		else z = rand(); 
		Vector3D vect = new Vector3D(x, y, z); 
		testGetX(x, vect); 
		testGetY(y, vect); 
		testGetZ(z, vect); 
	}
	private void testGetX(double x, Vector3D vect) {
		boolean equal = Math.abs(x - vect.getX()) < 0.00001;
		String message = "getX() or the Constructor is wrong for x = " + x;
		assertTrue(equal, message);
		System.out.println("x --> " + x + " :: " + vect.getX());
	}

	private void testGetY(double y, Vector3D vect) {
		boolean equal = Math.abs(y - vect.getY()) < 0.00001;
		String message = "getY() or the Constructor is wrong for y = " + y;
		assertTrue(equal, message);
		System.out.println("y --> " + y + " :: " + vect.getY());
	}
	private void testGetZ(double z, Vector3D vect) {
		boolean equal = Math.abs(z - vect.getZ()) < 0.00001;
		String message = "getX() or the Constructor is wrong for z = " + z;
		assertTrue(equal, message);
		System.out.println("z --> " + z + " :: " + vect.getZ());
	}
	@Test
	void testCnstr2() {
		testGetX(0, new Vector3D()); 
		testGetY(0, new Vector3D()); 
		testGetZ(0, new Vector3D()); 
	}
	@Test
	void testAdd() {
		Vector3D vect1 = new Vector3D(); 
		vect1.add(vect1);
		testGetX(0, new Vector3D()); 
		testGetY(0, new Vector3D()); 
		testGetZ(0, new Vector3D()); 
	}
	@Test
	void testAdd2() {
		double r = Math.random();
		double x = 0;
		double y = 0;
		double z = 0;
		if (r < 0.5) x = negRand();
		else x = rand();
		r = Math.random();
		if (r < 0.5) y = negRand();
		else y = rand();
		r = Math.random();
		if (r < 0.5) z = negRand();
		else z = rand();
		Vector3D vect1 = new Vector3D(x, y, z);
		vect1.add(vect1);
		testGetX(2*x, vect1);
		testGetY(2*y, vect1);
		testGetZ(2*z, vect1);
	}

	@Test
	void testSubtract() {

		Vector3D vect1 = new Vector3D();
		vect1.subtract(vect1);
		
		testGetX(0, new Vector3D()); 
		testGetY(0, new Vector3D()); 
		testGetZ(0, new Vector3D()); 
	}

	@Test
	void testSubtract2() {
		double r = Math.random();
		double x = 0;
		double y = 0;
		double z = 0;
		if (r < 0.5) x = negRand();
		else x = rand();
		r = Math.random();
		if (r < 0.5) y = negRand();
		else y = rand();
		r = Math.random();
		if (r < 0.5) z = negRand();
		else z = rand();
		Vector3D vect1 = new Vector3D(x, y, z);
		vect1.subtract(vect1);

		testGetX(0, vect1);
		testGetY(0, vect1);
		testGetZ(0, vect1);
	}

	@Test
	void testScalarMultiplication() {
		Vector3D vect1 = new Vector3D(); 
		vect1.scalarMultiplication(1);

		testGetX(0, new Vector3D()); 
		testGetY(0, new Vector3D()); 
		testGetZ(0, new Vector3D()); 
	}

	@Test
	void testScalarMultiplication1() {
		double r = Math.random();
		double x = 19.3;
		double y = 78.6;
		double z = 87.7;
		if (r < 0.5) x = negRand();
		else x = rand();
		r = Math.random();
		if (r < 0.5) y = negRand();
		else y = rand();
		r = Math.random();
		if (r < 0.5) z = negRand();
		else z = rand();
		Vector3D vect1 = new Vector3D(x, y, z);
		double n = rand();
		vect1.scalarMultiplication(n);


		testGetX(n*x, vect1);
		testGetY(n*y, vect1);
		testGetZ(n*z, vect1);
	}

	@Test
	void testDotProduct() {
		Vector3D vect1 = new Vector3D(); 
//		vect1.dotProduct(vect1);

		boolean equal = Math.abs(0 - vect1.dotProduct(vect1)) < 0.00001;
		String message = "dotProduct() or the Constructor is wrong for dotProduct = " + 0;
		assertTrue(equal, message);
		System.out.println(0 + " :: " + vect1.dotProduct(vect1));

	}

	@Test
	void testDotProduct1() {
		double r = Math.random();
		double x = 0;
		double y = 0;
		double z = 0;
		if (r < 0.5) x = negRand();
		else x = rand();
		r = Math.random();
		if (r < 0.5) y = negRand();
		else y = rand();
		r = Math.random();
		if (r < 0.5) z = negRand();
		else z = rand();
		Vector3D vect1 = new Vector3D(x, y, z);
//		vect1.dotProduct(vect1);

		double dotProd = ((x*x) + (y*y) + (z*z));
		boolean equal = Math.abs( dotProd - vect1.dotProduct(vect1)) < 0.00001;
		String message = "dotProduct() or the Constructor is wrong for dotProduct = " + dotProd;
		assertTrue(equal, message);
		System.out.println(dotProd + " :: " + vect1.dotProduct(vect1));

	}

	@Test
	void testMagnitude() {
		Vector3D vect1 = new Vector3D(); 
//		vect1.magnitude();

		boolean equal = Math.abs( 0 - vect1.magnitude()) < 0.00001;
		String message = "magnitude() or the Constructor is wrong for magnitude = " + 0;
		assertTrue(equal, message);
		System.out.println(0 + " :: " + vect1.magnitude());
	}

	@Test
	void testMagnitude1() {
		double r = Math.random();
		double x = 0;
		double y = 0;
		double z = 0;
		if (r < 0.5) x = negRand();
		else x = rand();
		r = Math.random();
		if (r < 0.5) y = negRand();
		else y = rand();
		r = Math.random();
		if (r < 0.5) z = negRand();
		else z = rand();
		Vector3D vect1 = new Vector3D(x, y, z);
//		vect1.magnitude();

		double magn = Math.sqrt((x*x) + (y*y) + (z*z));
		boolean equal = Math.abs( magn - vect1.magnitude()) < 0.00001;
		String message = "magnitude() or the Constructor is wrong for magnitude = " + magn;
		assertTrue(equal, message);
		System.out.println(magn + " :: " + vect1.magnitude());
	}

	@Test
	void testToString() {
		Vector3D vect1 = new Vector3D();
//		vect1.toString();

		boolean equal = (vect1.toString()).equals("[0.0, 0.0, 0.0]");
		String message = "toString() or the Constructor is wrong for String = [0.0, 0.0, 0.0]";
		assertTrue(equal, message);
		System.out.println("[0.0, 0.0, 0.0] :: " + vect1.toString());
	}

	@Test
	void testToString1() {
		double r = Math.random();
		double x = 0;
		double y = 0;
		double z = 0;
		if (r < 0.5) x = negRand();
		else x = rand();
		r = Math.random();
		if (r < 0.5) y = negRand();
		else y = rand();
		r = Math.random();
		if (r < 0.5) z = negRand();
		else z = rand();
		Vector3D vect1 = new Vector3D(x, y, z);
//		vect1.toString();

		boolean equal = (vect1.toString()).equals("[" + x +", " + y + ", " + z + "]");
		String message = "toString() or the Constructor is wrong for String = " + "[" + x +", " + y + ", " + z + "]";
		assertTrue(equal, message);
		System.out.println("[" + x +", " + y + ", " + z + "]" + " :: " + vect1.toString());
	}
	
	@Test
	void testEqualto() {
		Vector3D vect1 = new Vector3D(); 
//		vect1.equalTo(vect1, 0);

		boolean equal = (vect1.equalTo(vect1, 0.0));
		String message = "equalTo() or the Constructor is wrong for it to be = " + "true";
		assertTrue(equal, message);
		System.out.println("true :: " + vect1.equalTo(vect1, 0.0));
		
	}

	@Test
	void testEqualto1() {
		double r = Math.random();
		double x = 0;
		double y = 0;
		double z = 0;
		if (r < 0.5) x = negRand();
		else x = rand();
		r = Math.random();
		if (r < 0.5) y = negRand();
		else y = rand();
		r = Math.random();
		if (r < 0.5) z = negRand();
		else z = rand();
		Vector3D vect1 = new Vector3D(x, y, z);
//		vect1.equalTo(vect1, 0);

		boolean equal = (vect1.equalTo(vect1, 0)) == true;
		String message = "equalTo() or the Constructor is wrong for it to be = " + "true";
		assertTrue(equal, message);
		System.out.println("true :: " + vect1.equalTo(vect1, 0));
	}
}

