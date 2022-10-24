#ifndef JUNIOR_H
#define JUNIOR_H

#include <iostream>
#include <string>
#include "student.h"

using namespace std;

class Junior : public Student {
private:
	int lj; //The factor which multiplies the hours of
		   //attending a class. The product is added
		   //to the tiredness of the student
public:
	Junior(string, string, int, int);
	void attend(int);
};

#endif
