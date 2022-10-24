#ifndef YARD_H
#define YARD_H

#include <iostream>
#include <string>
#include "waiting_room.h"

class Yard : public Waiting_Room {
public:
	Yard(int);
	~Yard();
	void enter(Student *);
	Student * exit();
};

#endif
