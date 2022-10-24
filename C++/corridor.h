#ifndef CORRIDOR_H
#define CORRIDOR_H

#include <iostream>
#include <string>
#include "waiting_room.h"

using namespace std;

class Corridor : public Waiting_Room {
private: 
	int floor_number;
public:
	Corridor(int, int);
	~Corridor();
	void enter (Student *);
	Student * exit ();
};

#endif
