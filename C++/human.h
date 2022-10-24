#ifndef HUMAN_H
#define HUMAN_H

#include <iostream>
#include <string>

using namespace std;

class Human {
private:
	string name;
	int floor_number;
	string classroomID;
	bool in_class;
	int tiredness;
public:
	Human(string, int, string);
	virtual void print() const =0;
	void change_status();
	void add_tiredness(int);
	string get_name()const;
	int get_floor()const;
	string get_classroomID()const;
	int get_tiredness()const;
	bool is_in_class() const;
};
#endif
