package code;

import java.util.LinkedList;


public class Player {

	//player variables:
			String _playerName;
			LinkedList<Department> _chairOf;
			LinkedList<School> _deanOf;
			boolean _president;
			int _loyalStudents;
			Conquest currentGame;
			
			Player(Conquest c, String name){
				currentGame = c;
				_playerName = name;
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
				if ((_deanOf.size() == currentGame.getNumSchools()) && (_chairOf.size() == currentGame.getNumDepartments())){
					_president = true;
				}
				return _president;
			}
			
			
			
	
	
}
