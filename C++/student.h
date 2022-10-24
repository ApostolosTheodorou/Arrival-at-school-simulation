#ifndef STUDENT_H
#define STUDENT_H

#include <string>
#include <iostream>
#include "human.h"

using namespace std;

class Student : public Human {
public:
	Student(string, int, string);
	~Student();
	void print()const;
	virtual void attend(int) =0;
	void get_in_your_classroom();
};

#endif
