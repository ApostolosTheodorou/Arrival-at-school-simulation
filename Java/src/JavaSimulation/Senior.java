package JavaSimulation;

public final class Senior extends Student {
	
	private int ls; //The factor which multiplies the hours of
					//attending a class. The product is added
					//to the tiredness of the student
	
	Senior (String name, String classroomID, int floor_number, int l)
    {
		super(name, floor_number, classroomID);
		ls= l;
    }

	//Adds some tiredness to the student, proportionable 
	//to the hours he/she has been having a lesson
	void attend(int hours) {
		this.add_tiredness(ls*hours);
	}

}
