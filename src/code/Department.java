package code;

import java.util.LinkedList;

public class Department {
	String _deptName;
	//LinkedList<Student> _deptStudents;
	LinkedList<Department> _deptAdjacencies;
	
	public Department(String name){
		_deptName = name;
		//_deptStudents = new LinkedList<Student>();
		_deptAdjacencies = new LinkedList<Department>();
	}
	
	public boolean addAdjacencies(Department d){
		if(_deptAdjacencies.contains(d)){
			return false;
		}
		_deptAdjacencies.add(d);
		return true;
	}
	
	public boolean removeAdjacencies(Department d){
		if(_deptAdjacencies.contains(d);
			_deptAdjacencies.remove(d);
			return true;
		}
		return false;
	}
	
	public LinkedList<Department> getAdjacencies(){
		return _deptAdjacencies;
	}
	
	
}//end Department class
