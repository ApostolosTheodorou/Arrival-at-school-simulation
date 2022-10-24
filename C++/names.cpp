#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
#include "names.h"

using namespace std;

void Names::give_me_names(string * & teachers_names, int count,
			                          	     int random_number)
{
	long currtime;
	int i, j, k;

	currtime= time(NULL);
	srand((unsigned int) currtime+ random_number);

	for (i=0 ; i < count ; i++) {
		j= rand()%60;
		k= rand()%75;
		teachers_names[i]=names[j]+" "+surnames[k];
	}
}
