package JavaSimulation;

public abstract class Student extends Human {

	
	abstract void attend(int hours);
	
	//Constructor for Student, initializes its data members
	//by calling human's constructor  and prints a message
	Student(String name, int floor_number, String classroomID) 
	{
		super(name, floor_number, classroomID);
		System.out.println("\nA New Student has been created!\n"); 
		System.out.println("Name: "  + get_name() );
		System.out.println("Floor: " + get_floor() );
		System.out.println("Class: " + get_classroomID() );
	}
	
	Student(){
		super();
	}

	//Prints the student's name and his/her tiredness
	void print() {
		System.out.println("Name: " + super.get_name() );
		System.out.println("Tiredness: " + super.get_tiredness() + "\n");
	}

	//Edits the student's data member so that they show
	//that the student has entered his/her classroom
	void get_in_your_classroom() {
		super.change_status(); //Changes the data member "in_class" 
							   //from "false" to "true"
	}


}
