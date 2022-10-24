#ifndef OPERATING_ROOM_H
#define OPERATING_ROOM_H

#include <iostream>
#include <string>
#include "room.h"

using namespace std;

//2) Operating rooms: rooms that can operate()
//	 which trigger teaching or attending
class Operating_Room : public Room {
public:
	virtual void print()const =0;
	virtual void enter(Student *) =0;
	virtual void operate(int) =0;
};
#endif
