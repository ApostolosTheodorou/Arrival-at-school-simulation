#include <iostream>
#include <string>
#include "senior.h"

using namespace std;

//Constructor for senior, initializes its data members
//by calling the constructor of student
Senior::Senior (string name, string classroomID, int floor_number, int l)
        : Student(name, floor_number, classroomID), ls(l)
{
        //Nothing to be done here
}

//Adds some tiredness to the student, proportionable 
//to the hours he/she has been having a lesson
void Senior::attend(int hours) {
        this->add_tiredness(ls*hours);
}

