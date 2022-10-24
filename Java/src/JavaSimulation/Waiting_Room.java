package JavaSimulation;

abstract public class Waiting_Room extends Room {

	private int students_counter;
	private Student[] students;
	//Student none= new Senior("None", "None", -1, -1);
	
	
	abstract void enter(Student s);
	
	//Constructor for waiting_room, initializes its data members
	Waiting_Room(int c_class) 
	{
		students_counter= 0;
		//Create a table which can hold 
		//all the students of the school
		students= new Student [c_class * 18];
	}
	

	//Places the new student in the students array
	//and updates the student_counter
	void enter(Student new_student, String room) {
		students[students_counter]= new_student;
	    System.out.println(new_student.get_name() + " enters " + room + " !" + "\n");
	    students_counter++;
	}

	//Removes a student's entry from the array of students
	//Returns a pointer to the student who left
	//If there is no one in the waiting room, returns NULL
	Student exit(String room) {
		if (students_counter != 0) {
	    	students_counter--;
	        System.out.println(students[students_counter].get_name() +" exits " +
	    	room + " !\n");
	        return students[students_counter];
	    } else {return null;}
	}


	//Returns "true" if there is no one waiting 
	//in the waiting room
	boolean is_empty() {
		if (students_counter == 0) {
			return true;
		} else {return false;}
	}

}
