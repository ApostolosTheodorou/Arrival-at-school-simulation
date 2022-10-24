package JavaSimulation;

import java.util.Random;

public final class School extends Operating_Room {

	private Student[] students;
	private	int total_number_of_students;
		Teacher[] teachers;	
	private	Classroom[] classrooms;
	private	Corridor[] corridors;
	private	Floor[] floors;
	private	Yard  yard;
	private	Stairs stairs;
	private	String name;
	
	//private Teacher no_teacher= new Teacher("None", -1, "no classroom", -1);
	//private Student none= new Senior("None", "None", -1, -1);

	School(String nam, Student[]  studentss, 
		       int c_class, Teacher[]  teacherss)      
	{
	    int i;
	    String classID;
	    
	    name= nam;
	    students= studentss;
	    total_number_of_students= c_class * 18;
        teachers= teacherss;

	    System.out.println("A New School has been created!\n" );

	    yard= new Yard(c_class); 
	    stairs= new Stairs(c_class); 
	    floors= new Floor[3];
	    corridors= new Corridor[3];
	    classrooms= new Classroom [18];

	    for (i=0; i < 3 ; i++) {
	        corridors[i]= new Corridor(c_class, i+1); //Creates the corridors
	        floors[i]= new Floor(i+1, corridors[i], classrooms);//Creates the floors
	    }
	    for (i=0 ; i < 3 ; i++) {
	        classID= "A Junior "+Integer.toString(i+1);
	        //Creates the Junior classrooms of the first floor
	        classrooms[i]= new Classroom(classID, c_class);
	    }
		for (i=3 ; i < 6 ; i++) {
	        classID= "A Senior "+Integer.toString(i+1);
	        //Creates the Senior classrooms of the first floor
	        classrooms[i]= new Classroom(classID, c_class);
	    }
		for (i=0 ; i < 3 ; i++) {
	        classID= "B Junior "+Integer.toString(i+1);
	        //Creates the classrooms of the second floor
	        classrooms[i+6]= new Classroom(classID, c_class);
	    }
		for (i=3 ; i < 6 ; i++) {
	        classID= "B Senior "+Integer.toString(i+1);
	        //Creates the classrooms of the second floor
	        classrooms[i+6]= new Classroom(classID, c_class);
	    }
	    for (i=0 ; i < 3 ; i++) {
	        classID= "C Junior "+Integer.toString(i+1);
	        //Creates the classrooms of the third floor
	        classrooms[i+12]= new Classroom(classID, c_class);
	    }
		for (i=3 ; i < 6 ; i++) {
	        classID= "C Senior "+Integer.toString(i+1);
	        //Creates the classrooms of the third floor
	        classrooms[i+12]= new Classroom(classID, c_class);
	    }

	}

	

	//Prints a message and the floors
	void print() {
	    int i;

	    System.out.println("__________WELCOME TO " + name + "____________\n");
	    System.out.println("School life consist of:\n");
	    for (i=0; i < 3 ; i++) {
	    		System.out.println("\n");
	            floors[i].print();
	    }
	}

	//Pushes a student in the yard and prints a message
	void enter(Student new_student) {
		System.out.println(new_student.get_name() + " enters school!\n");
		yard.enter(new_student);
	}

	//Places a teacher in his floor
	void place(String ID, int flo,  Teacher teacher) {
	    floors[flo-1].place(ID, teacher);
	}

	void set_teachersANDstudents(Teacher[] t, Student[] s) {
	    teachers= t;
	    students= s;
	}

	//"Operates" the school for some hours
	//Triggers the floors' operate()
	void operate(int hours) {
		int i;

		for (i=0; i < 3 ; i++) {
			floors[i].operate(hours);
		}
	}

	//Simulates the entrance of the students in the school
	void enter(Student[] students) {
	    int i, j, students_floor;
	    Student entering_student;
	    String students_classID;
	    
	    Random rand = new Random(); 

	    //Step 1: Insert students in the yard 

	    //While there are still students outside the school
		while (total_number_of_students > 0) {
	        //Pick a random student
			i= rand.nextInt(total_number_of_students);
	     //   i= rand() % total_number_of_students;
			
	        //If the last student of the table was chosen
	        //(no hole is created in the table)
	        if ( i == total_number_of_students-1) {
	            //Reduce the students who were not chosen yet
	            total_number_of_students--;
	            //Insert the chosen student into the schoolyard
	            yard.enter(students[total_number_of_students]);
	            //Remove the chosen student from the unchosen students
	            students[total_number_of_students]= null;
	        }
	        else {//If the chosen student is in the middle of the array
	              //(and his/her removal will create an empty space in
	              //the middle of the array)
	            entering_student= students[i];//Save the chosen student somewhere
	            //Put the last student in the place where the chosen student was
	            students[i]= students[total_number_of_students-1];
	            //Reduce the unchosen students
	            total_number_of_students--;
				//Empty the last student's (who changed position in the array)
	            // entry on the array
	            students[total_number_of_students]= null;
	            //Insert the chosen student into the schoolyard
	            yard.enter(entering_student);
	        }
	    }//while (total_number_of_students > 0)
	     //Apparently now no one is waiting outside the school
		
		System.out.println("\n");

	    //Step 2: Take students from the yard and put them in the stairs
	    //While there are still people in the students waiting in the yard
		while ( !(yard.is_empty())) {
	        //Exit someone from the yard
	        entering_student= yard.exit(); //He/She is actually exiting now
	        //If no one exited the yard
	        // (because there is no one there anymore)
	        if (entering_student == null) {
	            break; //Stop trying to exit any other students from the 
	                   //yard to place them into the stairs
	        }
	        //If someone really exited from the yard
	        //place him/her into the stairs
	        stairs.enter(entering_student);
	    }// while (!(yard->is_empty()))
	    //Apparently there are no more students
	    //waiting in the yard to enter in the stairs
		
		System.out.println("\n");

	    //Step 3: Takes students from stairs and puts them in their floors
	    //Then the floor pushes them directly to the corridor

	    // While there are still students waiting in the stairs
		while (! (stairs.is_empty()) ) {
	        //Try to remove a student from the stairs
	        entering_student= stairs.exit();
	        //If there are no students left in the stairs
	        //and exit() failed to return a student
	        if (entering_student == null) {
	            break;//Stop trying to remove students from the stairs
	        }//If a student was removed from the stairs
	        //Find the floor he/she belongs to
			students_floor= entering_student.get_floor();
	        //Insert him/her into the floor he/she belong to
	        floors[students_floor-1].enter(entering_student);
	    }//The students have been inserted into their floors
	     //and then pushed into their corridors
		
		System.out.println("\n");

	    //Step 4: Take the students from the corridors and put them 
	    //in their classrooms

	    //For every floor/corridor
		for (i=0 ; i < 3 ; i++) {
	        //While there are still students waiting in the corridor
	        while (! (corridors[i].is_empty()) ) {
				//Try to remove a student from the corridor
	            entering_student= corridors[i].exit();
	            //If the removal was unsuccessful (no one exited because
	            //there are no students left in this corridor)
	            if (entering_student == null) {
	                break; //Stop trying to remove students from this corridor
	            }//If a student indeed exited from the corridor
	            //Find the classroom of the students who was removed from 
	            //the corridor
	            students_classID= entering_student.get_classroomID();

	            //Find which of the classrooms in this corridor has
	            //this ID and insert him/her there
	            for (j=0 ; j < 6 ; j++) {
	                if( students_classID.equals(classrooms[i*6+j].get_classroomID()) ) {
	                    classrooms[i*6+j].enter(entering_student);
	                    break;
	                }
	            }
	        }//while (! (corridors[i]->is_empty()) )
			//Apparently there are no students left at this corridor
	        //So, repeat the same proccess for the next corridor
	    }// for (i=0 ; i < 3 ; i++) //for each corridor
	    //Step 4 is completed
	    //The insertion of students in the school and their placement
	    //in their classrooms has been completed    
	}
	
	//Simulates the exit of the students from the school building
	void empty() {
		Student exiting_student;
		int i;
		
		System.out.println("\nThe bell rang. It is time to go home!\n");
		//For every floor
		for (i=0; i < 3 ; i++) {
			//While a students exits a floor (exits from the floor's corridor)
			//(until every student does exit the corridor in this floor)
			while ( (exiting_student= floors[i].exit())  !=  null ) {
				//The student will enter the stairs
				stairs.enter(exiting_student);
				//Then the student will exit the stairs
				exiting_student= stairs.exit();
				//Then the student will enter the yard
				yard.enter(exiting_student);
				//At last, the student will exit the yard 
				//(so he/she will have exited the school building)
				exiting_student= yard.exit();
			}
			//Now all the students of the i+1 floor have left the building
			//Let's take out the teachers of this floor as well
			floors[i].teachers_out();
		}	
	}
}
