#include <string>
#include <iostream>
#include "student.h"

using namespace std;

//Constructor for Student, initializes its data members
//by calling human's constructor  and prints a message
Student::Student(string name, int floor_number, string classroomID) 
		: Human(name, floor_number, classroomID) 
{
	cout << "A New Student has been created!" << endl;
    cout << "Name: "  << this->get_name()  << endl;
    cout << "Floor: " << this->get_floor() << endl;
    cout << "Class: " << this->get_classroomID() << endl;
}

//Destructor for Student, prints some messages
Student::~Student() {
    cout << "A Student to be destroyed!"   << endl;
    cout << "Name: "  << this->get_name()  << endl;
    cout << "Floor: " << this->get_floor() << endl;
    cout << "Class: " << this->get_classroomID() << endl;
}

//Prints the student's name and his/her tiredness
void Student::print()const {
    cout << "Name: " <<  this->get_name() << endl;
	cout << "Tiredness: " << this->get_tiredness() << endl;
}

//Edits the student's data member so that they show
//that the student has entered his/her classroom
void Student::get_in_your_classroom() {
	this->change_status(); //Changes the data member "in_class" 
						   //from "false" to "true"
}
