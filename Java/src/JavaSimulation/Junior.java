package JavaSimulation;

public final class Junior extends Student {
	
	private int lj; //The factor which multiplies the hours of
	   				//attending a class. The product is added
	   				//to the tiredness of the student
	
	//Constructor for junior, initializes its data members
	//by calling the constructor of student
	Junior (String name, String classroomID, int floor_number, int l)
	{
		super(name, floor_number, classroomID);
		lj= l;
	}

	//Adds some tiredness to the student, proportionable 
	//to the hours he/she has been having a lesson
	void attend(int hours) {
		super.add_tiredness(lj*hours);
	}
}
