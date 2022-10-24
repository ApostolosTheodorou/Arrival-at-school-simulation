#include <iostream>
#include <string>
#include "yard.h"

using namespace std;

//Constructor for Yard, initializes its data members 
//by calling waiting_room's nconstructor and prints
//a message
Yard::Yard(int c_class) 
	: Waiting_Room(c_class)
{
	cout << "A new Yard has been created!" << endl;
}

//Destructor for Yard, prints a message
Yard::~Yard() {
	cout << "A Yard to be destroyed!" << endl;
}

//Enters a new student to the students array by
//using the waiting_room's enter with apropriate second parameter
void Yard::enter(Student * new_student) {
	this->Waiting_Room::enter(new_student, "yard"); //Use the waiting
}

//Removes a student's entry from the array of students
//by using the waiting_room's exit()
//Returns the student who left
//If there is no one left in the yard, returns NULL
Student * Yard::exit() {
	Student * exiting_student;

	exiting_student= this->Waiting_Room::exit("yard");
	return exiting_student;
}
