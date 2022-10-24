#include <iostream>
#include <string>
#include "human.h"

using namespace std;

//Constructor of the abstract class human
//Initializes its data members, prints no message
Human::Human(string n, int fl, string cl) 
	: name(n), floor_number(fl), classroomID(cl), in_class(false), tiredness(0)
{
	//Nothing to be done here
}

//Changes the state of datamember "in_class", which shows
//whether this human is in his/her classroom or not
void Human::change_status() {
        in_class? in_class= false : in_class= true;
}

//Updates the data member tiredness of the human
//according to the hours he/she attended or teached a class
void Human::add_tiredness(int amount) {
	tiredness+= amount;
}

//Accessor for data member "name"
string Human::get_name()const {
	return name;
}

//Accessor for data member "floor_number"
int Human::get_floor()const {
        return floor_number;
}

//Accessor for datamember "classroomID"
string Human::get_classroomID()const {
        return classroomID;
}

//Accessor for data member "tiredness"
int Human::get_tiredness()const {
	return tiredness;
}

//Accessor for data member "in_class"
//Returns true if the teacher/student is in his/her classroom
bool Human::is_in_class()const{
        return in_class;
}

