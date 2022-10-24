#ifndef FLOOR_H
#define FLOOR_H

#include <iostream>
#include <string>
#include "classroom.h"
#include "corridor.h"
#include "operating_room.h"

class Teacher;

using namespace std;

class Floor : public Operating_Room {
private:
	Classroom ** classrooms;
	Corridor * corridor;
	int floor_number;
public:
	Floor(int, Corridor *, Classroom **);
	~Floor();
	void enter(Student *);
	void print()const;
	void place(string ID, Teacher *);
	void operate(int);
};

#endif
