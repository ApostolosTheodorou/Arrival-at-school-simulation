#ifndef STAIRS_H
#define STAIRS_H

#include <iostream>
#include <string>
#include "waiting_room.h"

using namespace std;

class Stairs : public Waiting_Room {
public:
	Stairs(int);
	~Stairs();
	bool is_full()const;
	void enter(Student *);
	Student * exit();
};

#endif
