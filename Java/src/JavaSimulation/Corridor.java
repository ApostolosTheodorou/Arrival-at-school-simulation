package JavaSimulation;

public final class Corridor extends Waiting_Room {

	private int floor_number;
	
	//Constructor of Corridor, initializes its data members
	//by calling waiting_room's constructor and prints a message
	Corridor(int c_class, int fl)
	{
		super(c_class);
		floor_number= fl;
		System.out.println("A new Corridor has been created!\n");
	}

	//Enters a new student to the students array by
	//using the waiting_room's enter with apropriate second parameter
	void enter(Student new_student) {
	        super.enter(new_student, "corridor"); 
	}

	//Removes a student's entry from the array of students
	//by using the waiting_room's exit()
	//Returns the student who left
	//If there is no one left in the corridor, returns none
	Student exit() {
	        Student exiting_student;
	        exiting_student= super.exit("corridor");
	        return exiting_student;
	}

}
