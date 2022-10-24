#ifndef WAITING_ROOM_H
#define WAITING_ROOM_H

#include <iostream>
#include "room.h"

using namespace std;

//Waiting rooms: rooms where students wait before
//they go in their classrooms
class Waiting_Room : public Room {
private:
	int students_counter;
	Student ** students;
public:
	virtual void enter(Student *) =0;
	Waiting_Room(int);
	void enter(Student *, string);
	Student * exit(string);
	bool is_empty()const;
};
#endif
