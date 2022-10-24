package JavaSimulation;

public final class Floor extends Operating_Room {

	private Classroom[] classrooms;
	private Corridor corridor;
	private int floor_number;
	
	
	//Constructor for Floor, initializes its data members
	//and prints a message
	Floor(int flor_number, Corridor coridor, Classroom[] classroo)
	{
		floor_number= flor_number;
		corridor= coridor;
		classrooms= classroo;
		System.out.println("A New Floor has been created!\n");
	}

	//Pushes the new student to the corridor and prints a message
	void enter(Student new_student) {
		System.out.println(new_student.get_name() + " enters floor "
			 + new_student.get_floor() + " !\n");
	    corridor.enter(new_student);
	}

	//Prints a message, then the classrooms
	void print() {
	    int i;

	    System.out.println("Floor number " + floor_number + " contains:\n");
	    for (i=0 ; i < 6 ; i++) {
	        classrooms[(floor_number-1) * 6 + i].print();
	    }
	}

	//Finds the classroom's ID of the teacher, it matches it with the
	//correct classroom and calls the Classroom's function place()
	void place(String classID, Teacher teache) {
	    int i;

	    for (i=0; i < 6 ; i++) {
	        if (classID.equals(
	            classrooms[(floor_number-1) * 6 + i].get_classroomID())) {
	            classrooms[(floor_number-1) * 6 + i].place(teache);
	        }
	    }
	}

	//Triggers the classroom's member-function operate()
	//for all the classrooms in this floor
	//"Operates" the classrooms in the floor
	void operate(int hours) {
		int i;

		for (i=0 ; i < 6 ; i++) {
			classrooms[(floor_number-1) * 6 + i].operate(hours);
		}
	}
	
	//Takes a student out of his classroom 
	//puts him/her in the corridor and then 
	//out of the corridor and in the stairs
	Student exit() {
		Student exiting_student;
		int i;
		boolean all_empty= true; //Assume that all the classrooms are empty
		
		//Check all the classrooms in this floor
		for (i=0 ; i < 6 ; i++) {
			//If at least one is not empty, go on with exiting
			if (!(classrooms[(floor_number-1) * 6 + i].is_empty())) {
				all_empty= false;
				break;
			}
		}
		//If indeed all the classrooms are empty, return null
		if (all_empty) {
			return null;
		}
		
		
		//First will exit all the students of the first classroom
		//Then all the students of the second classroom and so on
		
		//If there are still students in the first classroom 
		if (!(classrooms[(floor_number-1) * 6 ].is_empty())) {
			exiting_student= classrooms[(floor_number-1) * 6 ].exit();
		}
		//If there are no more students in the first classroom
		//and there are still students in the second classroom
		else if (!(classrooms[(floor_number-1) * 6 + 1 ].is_empty())) {
			exiting_student= classrooms[(floor_number-1) * 6 + 1].exit();
		}
		//If there are no more students in the first, second classroom
		//and there are still students in the third classroom
		else if (!(classrooms[(floor_number-1) * 6 + 2 ].is_empty())) {
			exiting_student= classrooms[(floor_number-1) * 6 + 2].exit();
		}
		//If there are no more students in the first, second, third classroom
		//and there are still students in the forth classroom
		else if (!(classrooms[(floor_number-1) * 6 + 3 ].is_empty())) {
			exiting_student= classrooms[(floor_number-1) * 6 + 3].exit();
		}
		//If there are no more students in the first,second,third,forth classroom
		//and there are still students in the fifth classroom
		else if (!(classrooms[(floor_number-1) * 6 + 4 ].is_empty())) {
			exiting_student= classrooms[(floor_number-1) * 6 + 4].exit();
		}
		//If there are no more students in the rest classrooms
		//and there are only students in the sixth classroom
		else {
			exiting_student= classrooms[(floor_number-1) * 6 + 5].exit();
		}
		
		//Since the student left his/her classroom
		//then he/she will enter the corridor
		
		corridor.enter(exiting_student);
		
		//And after he/she will exit the corridor
		exiting_student= corridor.exit();
		
		//And he/she will have completely exited the floor he/she was in
		return exiting_student;
	}
	
	//Takes the teachers out of their classrooms in this specific floor
	void teachers_out() {
		int i;
		
		//For each classroom in this floor
		for (i=0 ; i < 6 ; i++) {
			classrooms[(floor_number-1) * 6 + i].teacher_out();
		}
	}
}
