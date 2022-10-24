#ifndef CLASSROOM_H
#define CLASSROOM_H

#include <iostream>
#include <string>
#include "teacher.h"
#include "student.h"
#include "operating_room.h"

using namespace std;

class Classroom : public Operating_Room {
private:
	string classroomID;
	int c_class;
	int students_counter;
	Teacher * teacher;
	Student ** students;
public:
	Classroom(string, int);
	~Classroom();
	void print()const;
	void enter(Student *);
	string get_classroomID()const;
	void place(Teacher * teache);
	void operate(int);
};

#endif
