package JavaSimulation;

import java.util.Random;


public final class Simulation {
	public static void main (String[] args)
	{
	////// __________________ERRORS AND VARIABLES DEFINITIONS___________///////////

	    //Error: The arguments must be 5
	    if (args.length != 5) {
	        System.out.println ("Run like below\n");
	        System.out.println("java Cclass Lj Ls Lt N\n");
	        System.exit(1);
	    }
		
		//Variables' Definitions
	    int i, j, pos, possibility=100, teachers_in, teachers_to_be_placed=18,
	        who, teachers_selected;
	    int c_class= Integer.parseInt(args[0]);
	    int lj = Integer.parseInt(args[1]);
	    int ls = Integer.parseInt(args[2]);
	    int lt = Integer.parseInt(args[3]);
		int n  = Integer.parseInt(args[4]);
	    Names setter = new Names();
	    String[] students_names;
	    String[] teacher_names;
	   

	//////________CREATIONS OF SCHOOL, STUDENTS AND TEACHERS______________/////////

	   // Student[] students;
	   // Teacher[] teachers;
	    
	    //Create a school
//	    School school= new School("1o LYKEIO ARRENON ARVANITIAS", students,  c_class, teachers);

	    //Create the students
	    Student[] students;
	    students= new Student [c_class*18];

	    students_names= new String[c_class*18];

	    setter.give_me_names(students_names, c_class*18, 25934);

	    for (i=0 ; i < 18 ; i++) {
	        if (i < 3) {
	            for (j=0 ; j < c_class ; j++){
	                students[i*c_class+j]= 
					new Junior(students_names[i*c_class+j],
							   "A Junior "+Integer.toString(i+1), 1, lj);
	            }
	        }
			else if (i < 6) {
	            for (j=0 ; j < c_class ; j++){
	                students[i*c_class+j]=
					new Senior(students_names[i*c_class+j],
	                           "A Senior "+Integer.toString(i+1), 1, ls);
	            }
	        }
	        else if (i < 9) {
				for (j=0 ; j < c_class ; j++) {
	                students[i*c_class+j]=
					new Junior(students_names[i*c_class+j],
	                           "B Junior "+Integer.toString(i%6+1), 2, lj);
	            }
	        }
			else if (i < 12) {
	            for (j=0 ; j < c_class ; j++) {
	                students[i*c_class+j]=
					new Senior(students_names[i*c_class+j],
	                           "B Senior "+Integer.toString(i%6+1), 2, ls);
	            }
	        }
	        else if (i < 15) {
	            for (j=0 ; j < c_class ; j++) {
	                students[i*c_class+j]= 
					new Junior(students_names[i*c_class+j],
	                           "C Junior "+Integer.toString(i%6+1), 3, lj);
	            }
	        }
			else {
	            for (j=0 ; j < c_class ; j++) {
	                students[i*c_class+j]= 
					new Senior(students_names[i*c_class+j],
	                           "C Senior "+Integer.toString(i%6+1), 3, ls);
	            }
	        }
	    }

	    //Create the teachers
	    Teacher[] teachers;
	    teachers= new Teacher [18];
		teacher_names= new String[18];

	    setter.give_me_names(teacher_names,18, 766647);

	    for (i=0 ; i < 18 ; i++) {
	        if (i < 3) {
	            teachers[i]= new Teacher(teacher_names[i], 1,
								 "A Junior "+Integer.toString(i+1), lt);
	        }
			else if (i < 6) {
	            teachers[i]= new Teacher(teacher_names[i], 1,  
								 "A Senior "+Integer.toString(i+1), lt);
	        }
			else if (i < 9) {
	            teachers[i]= new Teacher(teacher_names[i], 2,
	                             "B Junior "+Integer.toString(i%6+1), lt);
	        }
	        else if (i < 12) {
	            teachers[i]= new Teacher(teacher_names[i], 2,
							   "B Senior "+Integer.toString(i%6+1), lt);
	        }
			else if (i < 15) {
	            teachers[i]= new Teacher(teacher_names[i], 3,
	                             "C Junior "+Integer.toString(i%6+1), lt);
	        }
	        else {
	            teachers[i]= new Teacher(teacher_names[i], 3,
							   "C Senior "+Integer.toString(i%6+1), lt);
	        }
	    }
	    
	    School school= new School("1o LYKEIO ARRENON ARVANITIAS", students,  c_class, teachers);

	    //Now that the students and their teachers have been created
	    //pass them to the school's class
	    school.set_teachersANDstudents(teachers, students);
	////____________________ENTER THE STUDENTS IN THE SCHOOL____________________////
	    
	    Random rand = new Random();
	    
		teachers_selected= 0;

	    school.enter(students); // Enter all the students in their classrooms
	    pos= rand.nextInt(100);
		while (teachers_selected < 18) { //while some teacher have
			                        	 //not been selected yet
	    	if (pos < possibility) {
	        	teachers_in= rand.nextInt(teachers_to_be_placed);
	        	for (i= 0; i < teachers_in ; i++) {
	            	who= rand.nextInt(18);
	           		if (!(teachers[who].is_in_class())) {
	               		school.place(teachers[who].get_classroomID(),
	                       teachers[who].get_floor(), teachers[who]);
						teachers_selected++;
	            	}
	        	}
	    	}
		}
	    school.operate(n);
	    school.print();
	    school.empty();

	    System.exit(0);
	}

}
