#include <iostream>
#include <string>
#include "teacher.h"

using namespace std;
//Constructor for teacher
//Initializes its data members by calling the human's constructor
//and prints a message for the teacher
Teacher::Teacher(string name, int floor_number, string classroomID, int l)
	: Human(name, floor_number, classroomID), lt(l)
{
	cout << "A new Teacher has been created:" << endl;
	cout << "Name: " <<  this->get_name() << endl;
	cout << "Floor: " << this->get_floor() << endl;
	cout << "Class: " << this->get_classroomID() << endl;
}

//Destructor for teacher
//Prints a message
Teacher::~Teacher() {
	cout << "A Teacher to be destroyed!" << endl;		
	cout << "Name: " <<  this->get_name() << endl;
        cout << "Floor: " << this->get_floor() << endl;
        cout << "Class: " << this->get_classroomID() << endl;
}

//Adds some tiredness to the teacher, proportionable 
//to the hours he/she has been teaching
void Teacher::teach(int hours) {
	this->add_tiredness(lt*hours);
}

//Prints the teachers elements
void Teacher::print()const {
	cout << "The teacher is:" << endl;
	cout << this->get_name() << endl;
	cout << "Tiredness: " << this->get_tiredness() << endl;
}
