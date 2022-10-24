#include <iostream>
#include <string>
#include "stairs.h"

using namespace std;

//Constructor for stairs, initializes its data members 
//by calling waiting_room's constructor and prints a message
Stairs::Stairs(int c_class) 
	: Waiting_Room(c_class)
{
	cout << "New Stairs have been created!" << endl;
}

//Destructor of stairs, prints a message
Stairs::~Stairs() {
	cout << "Stairs to be destroyed!" << endl;
}

//Enters a new student to the students array by
//using the waiting_room's enter with apropriate second parameter
void Stairs::enter(Student * new_student) {
        this->Waiting_Room::enter(new_student, "stairs"); //Use the waiting
}    

//Removes a student's entry from the array of students
//by using the waiting_room's exit()
//Returns the student who left
//If there is no one left in the yard, returns NULL
Student * Stairs::exit() {
        Student * exiting_student;

        exiting_student= this->Waiting_Room::exit("stairs");
        return exiting_student;
}

