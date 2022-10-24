#include <iostream>
#include <string>
#include "floor.h"

using namespace std;

//Constructor for Floor, initializes its data members
//and prints a message
Floor::Floor(int flor_number, Corridor * coridor, Classroom ** classroo)
	 : floor_number(flor_number), corridor(coridor), classrooms(classroo)
{
	cout << "A New Floor has been created!" << endl;
}

//Destructor for Floor, prints a message
Floor::~Floor() {
	cout << "A Floor to be destroyed!" << endl;
}

//Pushes the new student to the corridor and prints a message
void Floor::enter(Student *new_student) {
	cout << new_student->get_name() << " enters floor "
		 << new_student->get_floor() << " !" << endl;
    corridor->enter(new_student);
}

//Prints a message, then the classrooms
void Floor::print()const {
    int i;

    cout << "Floor number " << floor_number << " contains:" << endl;
    for (i=0 ; i < 6 ; i++) {
        classrooms[(floor_number-1) * 6 + i]->print();
    }
}

//Finds the classroom's ID of the teacher, it matches it with the
//correct classroom and calls the Classroom's function place()
void Floor::place(string classID, Teacher * teache) {
    int i;

    for (i=0; i < 6 ; i++) {
        if (classID ==
            classrooms[(floor_number-1) * 6 + i]->get_classroomID()) {
            classrooms[(floor_number-1) * 6 + i]->place(teache);
        }
    }
}

//Triggers the classroom's member-function operate()
//for all the classrooms in this floor
//"Operates" the classrooms in the floor
void Floor::operate(int hours) {
	int i;

	for (i=0 ; i < 6 ; i++) {
		classrooms[(floor_number-1) * 6 + i]->operate(hours);
	}
}
