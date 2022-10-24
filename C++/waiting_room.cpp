#include <iostream>
#include <string>
#include "waiting_room.h"

using namespace std;

//Constructor for waiting_room, initializes its data members
Waiting_Room::Waiting_Room(int c_class) 
	: students_counter(0)
{
	//Create a table which can hold 
	//all the students of the school
	students= new Student * [c_class * 18];
}

//Places the new students in the students array
//and updates the student_counter
void Waiting_Room::enter(Student * new_student, string room) {
	students[students_counter]= new_student;
    cout << new_student->get_name() << " enters " << room << " !" <<  endl;
    students_counter++;
}

//Removes a student's entry from the array of students
//Returns a pointer to the student who left
//If there is no one in the waiting room, returns NULL
Student * Waiting_Room::exit(string room) {
	if (students_counter != 0) {
    	students_counter--;
        cout << students[students_counter]->get_name()
             << " exits " << room << " !" <<  endl;
        return students[students_counter];
    } else {return NULL;}
}


//Returns "true" if there is no one waiting 
//in the waiting room
bool Waiting_Room::is_empty()const {
	if (students_counter == 0) {
		return true;
	} else {return false;}
}

