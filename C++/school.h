#ifndef SCHOOL_H
#define SCHOOL_H

#include <string>
#include <iostream>
#include "student.h"
#include "teacher.h"
#include "classroom.h"
#include "corridor.h"
#include "floor.h"
#include "yard.h"
#include "stairs.h"
#include "operating_room.h"

using namespace std;

class School : public Operating_Room {
private:
	Student ** students;
	int total_number_of_students;
	Teacher ** teachers;	
	Classroom ** classrooms;
	Corridor ** corridors;
	Floor ** floors;
	Yard * yard;
	Stairs * stairs;
	string name;
public:
	School(string, Student **, int, Teacher **);
	~School();
	void print()const;
	void enter(Student **);
	void enter(Student *);	
	void place(string, int, Teacher *);
	void set_teachersANDstudents(Teacher ** &, Student ** &);
	bool all_in_classrooms()const;
	void operate(int);
};

#endif
