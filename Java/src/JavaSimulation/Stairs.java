package JavaSimulation;

public final class Stairs extends Waiting_Room {

//	private Student none= new Senior("None", "None", -1, -1);
	Stairs(int c_class) 
	{
		super(c_class);
		System.out.println("New Stairs have been created!\n");
	}


	//Enters a new student to the students array by
	//using the waiting_room's enter with apropriate second parameter
	void enter(Student  new_student) {
        super.enter(new_student, "stairs"); 
    }    

	//Removes a student's entry from the array of students
	//by using the waiting_room's exit()
	//Returns the student who left
	//If there is no one left in the yard, returns none
	Student exit() {
        Student  exiting_student;

        exiting_student= super.exit("stairs");
        return exiting_student;
	}



}
