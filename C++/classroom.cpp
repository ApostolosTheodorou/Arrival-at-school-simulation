#include <iostream>
#include <string>
#include "classroom.h"

using namespace std;

//Constructor for Classroom, initializes its data members, prints a message
Classroom::Classroom(string classromID, int c_cl)
    : classroomID(classromID), c_class(c_cl), teacher(NULL), students_counter(0)
{
    students= new Student* [c_class]; // Allocates memory for the
                                      // maximum capacity of students
    cout << "\nA New Class has been created!\n" << endl; 
}

//Destructor for Classroom, frees all the Students
//who are in the classroom and prints a message
Classroom::~Classroom() {
	for (int i=0 ; i < students_counter ; i++) {
        delete students[i];
    }
    delete students;
    cout << "\nA Class to be destroyed!\n" << endl;
}

//Prints a message and the people in the classroom
void Classroom::print()const {
	cout << "\nPeople in class " << classroomID << " are:\n" << endl;
	for (int i=0 ; i < students_counter ; i++) {
		students[i]->print();
	}
	teacher->print();
}

//Places the teacher in the classroom
void Classroom::place(Teacher * teache) {
    teacher= teache;
    teacher->change_status();//Makes the teacher aware he/she is in classroom
}

//Places the new student in the students array
//Also updates the students_counter and the student's location
void Classroom::enter(Student* new_student) {
    students[students_counter]= new_student;
    students[students_counter]->get_in_your_classroom();
	cout << new_student->get_name() << " enters classroom !" << endl;
    students_counter++;
}

//Accessor for data member "classroomID"
string Classroom::get_classroomID()const {
    return classroomID;
}

//Makes the teacher teach and the students attend a lesson
//for a duration of some hours, which has as a result
//their tiredness to be increased
void Classroom::operate(int hours) {
	int i;

	for (i=0 ; i < students_counter ; i++) {
		students[i]-> attend(hours);
	}
	teacher->teach(hours);
}
