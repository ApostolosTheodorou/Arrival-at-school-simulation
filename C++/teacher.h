#ifndef TEACHER_H
#define TEACHER_H

#include <iostream>
#include <string>
#include "human.h"

using namespace std;

class Teacher : public Human {
private:
	int lt; //The factor which multiplies the hours of
		//teaching. The product is added to the tiredness
		//of the teacher
public:
	Teacher(string, int, string, int);
	~Teacher();
	void teach(int);
	void print()const;
};
#endif
