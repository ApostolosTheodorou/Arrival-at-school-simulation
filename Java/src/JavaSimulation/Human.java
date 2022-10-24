package JavaSimulation;

public abstract class Human {
	private String name;
	private int floor_number;
	private String classroomID;
	private boolean in_class;
	private int tiredness;
	
	abstract void print();
	
	//Constructor of the abstract class human
	//Initializes its data members, prints no message
	Human(String n, int fl, String cl) 
	{
		name= n;
		floor_number= fl;
		classroomID= cl;
		in_class= false;
		tiredness= 0;
	}
	
	Human()
	{
		name= "None";
		floor_number= -1;
		classroomID= "No classroom";
		in_class= false;
		tiredness= -1;
	}
	
	//Changes the state of datamember "in_class", which shows
	//whether this human is in his/her classroom or not
	public void change_status() {
		if (in_class == true ) {
			in_class= false ;
		} else {in_class= true;}
	}
	
	//Updates the data member tiredness of the human
	//according to the hours he/she attended or teached a class
	public void add_tiredness(int amount) {
		tiredness+= amount;
	}
	
	//Accessor for data member "name"
	public String get_name() {
		return name;
	}
	
	//Accessor for data member "floor_number"
	public int get_floor() {
	        return floor_number;
	}

	//Accessor for datamember "classroomID"
	public String get_classroomID() {
	        return classroomID;
	}
	
	//Accessor for data member "tiredness"
	public int get_tiredness() {
		return tiredness;
	}
	
	//Accessor for data member "in_class"
	//Returns true if the teacher/student is in his/her classroom
	public boolean is_in_class(){
	        return in_class;
	}

}
