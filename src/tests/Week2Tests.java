package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import code.Conquest;
import code.Department;
import code.Player;
import code.School;
import code.Student;

public class Week2Tests {
	
	/*
	@Before //things to be done before every test
	public void setup() {
		Conquest tester = new Conquest();
	}*/
	
	/// --- got rid of @Before and @After here - we can either have a Conquest constructor that doesn't take in a parameter and gets players after
	/// OR have it take in a parameter and add the names first but cannot call addPlayers on empty constructor

	@Test //test for adding only 3 players
	public void test1() {
		String[] players = new String["Sam", "Wendy", "Amie"];
		tester.addPlayers(players);
		assertTrue("Number of players should be 3", players.length == 3)
	}
	
	@Test (expected = IllegalArgumentException.class)//test for adding 0 players
	public void test2() {
		String[] players = new String[];
		tester.addPlayers(players);
	}
	
	@Test //test for adding 20 players
	public void test3() {
		String[] players = new String[20];
		tester.addPlayers(players);
		assertTrue("Number of players should be 20", players.length == 20)
	}
	
	@Test (expected = IllegalArgumentException.class) //test for adding 21 players
	//EXCEPTION EXPECTED
	public void test4() {
		String[] players = new String[21];
		tester.addPlayers(players);
	}
	
	@Test (expected = IllegalArgumentException.class)//test for giving two players in a row the same names
	public void test5() {
		String players = new String["Bob", "Bob"];
		tester.addPlayers(players);
	}
	
	@Test (expected = IllegalArgumentException.class)//test for giving two nonconsecutive players the same name
	public void test6() {
		String players = new String["Bob","Jane","Bob"];
		tester.addPlayers(players);
	}
	
	@Test //test for correct number of schools in week two: 6
	public void test7() {
		int expected = 6;
		int actual = tester.getNumSchools();
		assertTrue("Expected "+expected+" schools, Got "+actual, expected == actual);
	}
	
	@Test //test for correct number of depts in week two: 24
	public void test8() {
		int expected = 24;
		int actual = tester.getNumDepartments();
		assertTrue("Expected " + expected + " depts, but got " + actual, expected == actual);
	}
	
	//NOTE tests 9 -14 use an unwritten method to get a string array of all depts in a school
	//if tests 9-14 fail, double check our assertTrue boolean. It might be shady because we used .toString() to compare arrays
	
	@Test //text access to dept names in sciences school
	public void test9() {
		String[] expected = new String["Biology","Chemistry", "Mathematics", "Physics"];
		String[] actual = tester.getDeptNames("Science");
		assertTrue("Expected the following names in the Science School: "+expected.toString() + ", but got these names instead: " + actual.toString(), expected.toString() == actual.toString());
	}
	
	
	@Test //test access to dept names in humanities school
	public void test10() {
		String[] expected = new String["History", "Linguistics", "Literature", "Religion"];
		String[] actual = tester.getDeptNames("Humanities");
		assertTrue("Expected the following names in the Humanities School: "+expected.toString() + ", but got these names instead: " + actual.toString(), expected.toString() == actual.toString());
	}
	
	@Test //test access to dept names in arts school
	public void test11() {
		String[] expected = new String["Dance", "Music", "Theatre", "Visual Arts"];
		String[] actual = tester.getDeptNames("Arts");
		assertTrue("Expected the following names in the Arts School: "+expected.toString() + ", but got these names instead: " + actual.toString(), expected.toString() == actual.toString());
	}
	
	@Test //test access to dept names in engineering school
	public void test12() {
		String[] expected = new String["Civil", "Computer", "Electrical", "Mechanical"];
		String[] actual = tester.getDeptNames("Engineering");
		assertTrue("Expected the following names in the Engineering School: "+expected.toString() + ", but got these names instead: " + actual.toString(), expected.toString() == actual.toString());
	}
	
	@Test //test access to dept names in law school
	public void test13() {
		String[] expected = new String["Business", "Criminal", "Family", "Immigration"];
		String[] actual = tester.getDeptNames("Law");
		assertTrue("Expected the following names in the Law School: "+expected.toString() + ", but got these names instead: " + actual.toString(), expected.toString() == actual.toString());
	}
	
	@Test //test access to dept names in medicine school
	public void test14() {
		String[] expected = new String["Anesthesia", "Otolaryngology", "Pathology", "Pediatrics"];
		String[] actual = tester.getDeptNames("Medicine");
		assertTrue("Expected the following names in the Medicine School: "+expected.toString() + ", but got these names instead: " + actual.toString(), expected.toString() == actual.toString());
	}
	
	@Test //test adjacencies of one dept in sciences
	public void test15() {
		LinkedList<Department> expected = new LinkedList<Department>();
		expected.add(Anesthesia);
		expected.add(Biology);
		expected.add(Physics);
		expected.add(Mathematics);
		assertTrue("", Chemistry.getAdjacencies().equals(expected));
	}
	
	@Test //test adjacencies of one dept in humanities
	public void test16() {
		LinkedList<Department> expected = new LinkedList<Department>();
		expected.add(History);
		expected.add(Literature);
		expected.add(Religion);
		expected.add(Computer);
		assertTrue("", Linguistics.getAdjacencies().equals(expected));
	}
	
	@Test //test adjacencies of one dept in arts
	public void test17() {
		LinkedList<Department> expected = new LinkedList<Department>();
		expected.add(Anesthesia);
		expected.add(Biology);
		expected.add(Physics);
		expected.add(Mathematics);
		assertTrue("", Chemistry.getAdjacencies().equals(expected));
	}
	
	@Test //test adjacencies of one dept in engineering
	public void test18() {
		String[] expected = new String["Dance", "Physics", "Theatre", "Visual Arts"];
		String[] actual = tester.getAdjacencies("Music");
		assertTrue("Expected the following adjacencies for Music Dept: " + expected + ", but got these adjacencies: " + actual, actual.toString().equals(expected.toString());
	}
	
	@Test //test adjacencies of one dept in law
	public void test19() {
		String[] expected = new String["Business", "Family", "Immigration", "Pathology"];
		String[] actual = tester.getAdjacencies("Criminal");
		assertTrue("Expected the following adjacencies for Music Dept: " + expected + ", but got these adjacencies: " + actual, actual.toString().equals(expected.toString());
	}
	
	@Test ////test adjacencies of one dept in medicine
	public void test20() {
		String[] expected = new String["Otolaryngology", "Pathology", "Pediatrics", "Chemistry"];
		String[] actual = tester.getAdjacencies("Anesthesia");
		assertTrue("Expected the following adjacencies for Music Dept: " + expected + ", but got these adjacencies: " + actual, actual.toString().equals(expected.toString());
	}
	
	/*
	@After
	public void teardown(){
		
	}*/
	
}
