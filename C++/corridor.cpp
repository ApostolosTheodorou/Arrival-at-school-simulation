#include <iostream>
#include <string>
#include "corridor.h"

using namespace std;

//Constructor of Corridor, initializes its data members
//by calling waiting_room's constructor and prints a message
Corridor::Corridor(int c_class, int fl)
		: Waiting_Room(c_class), floor_number(fl)
{
	cout << "A new Corridor has been created!" << endl;
}

//Destructor of corridor, prints a message
Corridor::~Corridor() {
	cout << "A corridor to be destroyed!" << endl;
}

//Enters a new student to the students array by
//using the waiting_room's enter with apropriate second parameter
void Corridor::enter(Student * new_student) {
        this->Waiting_Room::enter(new_student, "corridor"); 
}

//Removes a student's entry from the array of students
//by using the waiting_room's exit()
//Returns the student who left
//If there is no one left in the corridor, returns NULL
Student * Corridor::exit() {
        Student * exiting_student;
        exiting_student= this->Waiting_Room::exit("corridor");
        return exiting_student;
}
