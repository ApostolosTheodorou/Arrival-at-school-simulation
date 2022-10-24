package JavaSimulation;

public final class Yard extends Waiting_Room {
	
	//Constructor for Yard, initializes its data members 
	//by calling waiting_room's constructor and prints
	//a message
	Yard(int c_class) 
	{
		super(c_class);
		System.out.println("A new Yard has been created!\n");
	}

	//Enters a new student to the students array by
	//using the waiting_room's enter with apropriate second parameter
	void enter(Student new_student) {
		super.enter(new_student, "yard"); 
	}
	
	//Removes a student's entry from the array of students
	//by using the waiting_room's exit()
	//Returns the student who left
	//If there is no one left in the yard, returns the student none
	Student exit() {
		Student exiting_student;

		exiting_student= super.exit("yard");
		return exiting_student;
	}

	
}
