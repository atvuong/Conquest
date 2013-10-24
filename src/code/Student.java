package code;

import code.Department;
import code.Player;

public class Student {
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
}
