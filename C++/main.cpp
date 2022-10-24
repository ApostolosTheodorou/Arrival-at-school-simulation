#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
#include "school.h"
#include "junior.h"
#include "senior.h"
#include "names.h"


using namespace std;

int main (int argc, char * argv[])
{
////// __________________ERRORS AND VARIABLES DEFINITIONS___________///////////

    //Error: The arguments must be 5
    if (argc != 6) {
        cout << "Run like below" << endl;
        cout << "./School Cclass Lj Ls Lt N" << endl;
        return 1;
    }
	//Variables' Definitions
    int i, j, pos, possibility=100, teachers_in, teachers_to_be_placed=18,
        who, * floors, teachers_selected;
    int c_class= atoi(argv[1]);
    int lj = atoi(argv[2]);
    int ls = atoi(argv[3]);
    int lt = atoi(argv[4]);
	int n  = atoi(argv[5]);
    Names setter;
    string * students_names, * teacher_names;
    long currtime;

//////________CREATIONS OF SCHOOL, STUDENTS AND TEACHERS______________/////////

    //Create a school
    School school("1o LYKEIO ARRENON ARVANITIAS", NULL,  c_class, NULL);

    //Create the students
    Student ** students;
    students= new Student * [c_class*18];

    students_names= new string[c_class*18];

    setter.give_me_names(students_names, c_class*18, 25934);

    for (i=0 ; i < 18 ; i++) {
        if (i < 3) {
            for (j=0 ; j < c_class ; j++){
                students[i*c_class+j]= 
				new Junior(students_names[i*c_class+j],
						   "A Junior "+to_string(i+1), 1, lj);
            }
        }
		else if (i < 6) {
            for (j=0 ; j < c_class ; j++){
                students[i*c_class+j]=
				new Senior(students_names[i*c_class+j],
                           "A Senior "+to_string(i+1), 1, ls);
            }
        }
        else if (i < 9) {
			for (j=0 ; j < c_class ; j++) {
                students[i*c_class+j]=
				new Junior(students_names[i*c_class+j],
                           "B Junior "+to_string(i%6+1), 2, lj);
            }
        }
		else if (i < 12) {
            for (j=0 ; j < c_class ; j++) {
                students[i*c_class+j]=
				new Senior(students_names[i*c_class+j],
                           "B Senior "+to_string(i%6+1), 2, ls);
            }
        }
        else if (i < 15) {
            for (j=0 ; j < c_class ; j++) {
                students[i*c_class+j]= 
				new Junior(students_names[i*c_class+j],
                           "C Junior "+to_string(i%6+1), 3, lj);
            }
        }
		else {
            for (j=0 ; j < c_class ; j++) {
                students[i*c_class+j]= 
				new Senior(students_names[i*c_class+j],
                           "C Senior "+to_string(i%6+1), 3, ls);
            }
        }
    }

    //Create the teachers
    Teacher ** teachers;
    teachers= new Teacher * [18];
	teacher_names= new string[18];

    setter.give_me_names(teacher_names,18, 766647);

    for (i=0 ; i < 18 ; i++) {
        if (i < 3) {
            teachers[i]= new Teacher(teacher_names[i], 1,
							 "A Junior "+to_string(i+1), lt);
        }
		else if (i < 6) {
            teachers[i]= new Teacher(teacher_names[i], 1,  
							 "A Senior "+to_string(i+1), lt);
        }
		else if (i < 9) {
            teachers[i]= new Teacher(teacher_names[i], 2,
                             "B Junior "+to_string(i%6+1), lt);
        }
        else if (i < 12) {
            teachers[i]= new Teacher(teacher_names[i], 2,
						   "B Senior "+to_string(i%6+1), lt);
        }
		else if (i < 15) {
            teachers[i]= new Teacher(teacher_names[i], 3,
                             "C Junior "+to_string(i%6+1), lt);
        }
        else {
            teachers[i]= new Teacher(teacher_names[i], 3,
						   "C Senior "+to_string(i%6+1), lt);
        }
    }

    //Now that the students and their teachers have been created
    //pass them to the school's class
    school.set_teachersANDstudents(teachers, students);
////____________________ENTER THE STUDENTS IN THE SCHOOL____________________////
    currtime= time(NULL);
    srand((unsigned int) currtime);
	teachers_selected= 0;

    school.enter(students); // Enter all the students in their classrooms
    pos= rand()%100;
	while (teachers_selected < 18) { //while some teacher have
		                        	 //not been selected yet
    	if (pos < possibility) {
        	teachers_in= rand()%teachers_to_be_placed;
        	for (i= 0; i < teachers_in ; i++) {
            	who= rand()%18;
           		if (!(teachers[who]->is_in_class())) {
               		school.place(teachers[who]->get_classroomID(),
                       teachers[who]->get_floor(), teachers[who]);
					teachers_selected++;
            	}
        	}
    	}
	}
    school.operate(n);
    school.print();

    return 0;
}
