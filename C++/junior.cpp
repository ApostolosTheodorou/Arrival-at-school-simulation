#include <iostream>
#include <string>
#include "junior.h"

using namespace std;

//Constructor for junior, initializes its data members
//by calling the constructor of student
Junior::Junior (string name, string classroomID, int floor_number, int l)
	: Student(name, floor_number, classroomID), lj(l)
{
	//Nothing to be done here
}

//Adds some tiredness to the student, proportionable 
//to the hours he/she has been having a lesson
void Junior::attend(int hours) {
	this->add_tiredness(lj*hours);
}
