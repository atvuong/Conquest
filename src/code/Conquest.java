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
	int countPlayers;
	static LinkedList<Player> livePlayers;
	boolean _univHasPresident;
	HashMap<Department, Player> chairRecords = new HashMap<Department, Player>();
	HashMap<School, Player> deanRecords = new HashMap<School, Player>();
	static String[] _playerNames = new String[20]; //should this be static? 
	
		public void addPlayers(String[] names) { //should be GUI
			_playerNames = names;
			if(names.length > 20) {
				throw new IllegalArgumentException();
			}
			else if(names.length < 2) {
				throw new IllegalArgumentException();
			}

				
			}
			//FIGURE OUT TURNS AND ITERATORS
			Conquest gameDriver = new Conquest(counter);
			for(int i = 0; i < counter; i++) {
				Player tempPlayer = new Player(gameDriver, _playerNames[i]);
				livePlayers.add(tempPlayer);
			}
			
		}//end of main
		
		
//Conquest Task List: 1. Add second constructor. First constructor will be called automatically and handle depts and schools ONLY!
//Second constructor is called AFTER addPLayers has been called as much as needed and countPlayers is accurate. This second constructor
//will instantiate 

public Conquest(){
			_numSchools = 2;
			_numDepartments = 4;
			_univHasPresident = false;
			livePlayers = new LinkedList<Player>();
			//addPlayer will add players one at a time to String array, makePlayers will use finished String array to construct Player objects
		}
	
		public int addPlayer(int count, String name){//GUI calls this method
			if((name == null) || (name == "")){
				throw new IllegalArgumentException("Name cannot be null or blank");
			}
			for(int i = 0; i<count; i++){
				if (name.equals(_playerNames[i])){
					throw new IllegalArgumentException("Name already exists");
			}
			_playerNames[count] = name;
			count = count + 1;
			return count;
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
		
		public makePlayers() {
			for (int i = 0; i < _playerNames.length; i ++) {
				Player tempPlayer = new Player(this, _playerNames[i]);
				livePlayers.add(tempPlayer);
			}
		}
}


/* 
Things to consider:
1. What happens if one player kills all others BUT remaining player doesn't control whole board?
2. Can a single department hold more than 2 kinds of students at a time?
3. What happens during elections? Is an election called within one department or against another dept?
4. What kind of player can win an election, ie can a player who didn't call an election win an election?
5. Once we know who could win an election, how do we calculate vote?*/
