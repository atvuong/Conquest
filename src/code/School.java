package code;



public class School {
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
	
}
