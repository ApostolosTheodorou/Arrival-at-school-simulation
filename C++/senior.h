#ifndef SENIOR_H
#define SENIOR_H

#include <iostream>
#include <string>
#include "student.h"

using namespace std;

class Senior : public Student {
private:
	int ls; //The factor which multiplies the hours of
		   //attending a class. The product is added
		   //to the tiredness of the student
public:
	Senior(string, string, int, int);
	void attend(int);
};

#endif
