package code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Conquest {
//whole game variables:
	int _numPlayers;
	int _numSchools;
	int _numDepartments;
	int _numStudents;
	static LinkedList<Player> livePlayers;
	boolean _univHasPresident;
	HashMap<Department, Player> chairRecords = new HashMap<Department, Player>();
	HashMap<School, Player> deanRecords = new HashMap<School, Player>();
	static String[] _playerNames = new String[20]; //should this be static? 
	
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter name of player 1: ");
			_playerNames[0] = in.nextLine();
			System.out.println("Enter name of player 2: ");
			_playerNames[1] = in.nextLine();
			String morePlayers = "junk";
			int counter = 3;
			while (counter < 20) {
				System.out.println("Add more players? Y or N");
				morePlayers = in.nextLine();
				if (morePlayers.compareToIgnoreCase("y") == 1) {
					System.out.println("Enter name of player " + counter);
					//check later that input doesn't already exist!!!!!
					_playerNames[counter - 1] = in.nextLine();
					counter += 1;
				}
				else if(morePlayers.compareToIgnoreCase("n") == 1) {
					counter -= 1;
					break;
				}
			}
			//FIGURE OUT TURNS AND ITERATORS
			Conquest gameDriver = new Conquest(counter);
			for(int i = 0; i < counter; i++) {
				Player tempPlayer = new Player(gameDriver, _playerNames[i]);
				livePlayers.add(tempPlayer);
			}
			
		}//end of main
		
		Conquest(int _nP){
			_numPlayers = _nP;
			_numSchools = 2;
			_numDepartments = 4;
			_numStudents = _numPlayers * 3;
			_univHasPresident = false;
			livePlayers = new LinkedList<Player>();
		}
	
		public LinkedList<Player> getPlayers(){
			return livePlayers;
		}
		
		public boolean killPlayer(Player p) {
			if (livePlayers.contains(p)) {
				livePlayers.remove(p);
				return true;
			}
			return false;
		}

		public int getNumSchools(){
			return _numSchools;
		}
		
		public int getNumDepartments(){
			return _numDepartments;
		}
}
	/* class Player{
		//player variables:
		String _playerName;
		LinkedList<Department> _chairOf;
		LinkedList<School> _deanOf;
		boolean _president;
		int _loyalStudents;
		
		Player(){
			LinkedList<Department> _chairOf = new LinkedList<Department>();
			LinkedList<School> _deanOf = new LinkedList<School>();
			boolean _president = false;
			int _loyalStudents = 0;
		}
		
		public boolean setName(String n) {
			_playerName = n;
			return true;
		}
		
		public String getName() {
			return _playerName;
		}
		
		public boolean addDept(Department d) {
			_chairOf.add(d);
			return true;
		}
		
		public LinkedList<Department> getDepts() {
			return _chairOf;
		}
		
		public boolean addSchool(School s) {
			_deanOf.add(s);
			return true;
		}
		
		public LinkedList<School> getSchools() {
			return _deanOf;
		}
		
		public boolean changeStudents(int i) {
			_loyalStudents += i;
			return true;
		}
		
		public int getStudents() {
			return _loyalStudents;
		}
		
		public boolean makePresident() {
			if ((_deanOf.size() == _numSchools) && (_chairOf.size() == _numDepartments)){
				_president = true;
				_univHasPresident = true;
			}
			return _president;
		}
		
		
		
	}//end player
	
	class School{
		//school variables
		Department[] _deptList;
		String _schoolName;
		
		School(int numDept, String name){
			_deptList = new Department[numDept];
			_schoolName = name;
		}
		
		public String getSchoolName() {
			return _schoolName;
		}
		
		public Department[] getDepts() {
			return _deptList;
		}
	}//end school
	
	class Department{
		String _deptName;
		LinkedList<Student> _deptStudents;
	}//end department
	
	class Student{
		Player _studentLoyalty;
		Department _studentDept;
		
		Student(Player p, Department d) {
			_studentLoyalty = p;
			_studentDept = d;
		}
		
		public boolean changeLoyalty(Player newLoyalty){
			_studentLoyalty = newLoyalty;
			return true;
		}
		
		public boolean changeLocation(Department newLoc){
			_studentDept = newLoc;
			return true;
		}
		
		public Player getLoyalty(){
			return _studentLoyalty;
		}
		
		public Department getStudentDept(){
			return _studentDept;
		}
		
		public Player getVote(Player one, Player two){
			//issues: check that parameter's players include this student's loyalty?
			//
			return one;
		}
	}//end student
	/*
	
}//end conquest

/* 
Things to consider:
1. What happens if one player kills all others BUT remaining player doesn't control whole board?
2. Can a single department hold more than 2 kinds of students at a time?
3. What happens during elections? Is an election called within one department or against another dept?
4. What kind of player can win an election, ie can a player who didn't call an election win an election?
5. Once we know who could win an election, how do we calculate vote?*/
