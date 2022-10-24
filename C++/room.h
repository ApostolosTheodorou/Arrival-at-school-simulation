#ifndef ROOM_H
#define ROOM_H

#include <iostream>
#include <string>
#include "student.h"

using namespace std;

//Room is a place where a student can enter
//There are two type of rooms:
//1) Waiting rooms: rooms where students wait before
//   they go in their classrooms
//2) Operating rooms: rooms that can operate()
//	 which trigger teaching or attending
class Room {
public:
	virtual void enter(Student *) =0;
};

#endif
