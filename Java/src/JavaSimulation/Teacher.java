package JavaSimulation;

public class Teacher extends Human {
	private int lt; //The factor which multiplies the hours of
					//teaching. The product is added to the tiredness
					//of the teacher

	//Prints the teacher's elements
	void print() {
		System.out.println("The teacher is:\n" );
		System.out.println(get_name());
		System.out.println("Tiredness: " + get_tiredness() + "\n");
	}
	
	//Constructor for teacher
	//Initializes its data members by calling the human's constructor
	//and prints a message for the teacher
	Teacher(String name, int floor_number, String classroomID, int l)
	{
		super(name, floor_number, classroomID);
		lt= l;
		
		System.out.println("\nA new Teacher has been created:\n"); 		
		System.out.println("Name: " + name );
		System.out.println("Floor: " + floor_number );
		System.out.println("Class: " + classroomID );
	}
	
	//Adds some tiredness to the teacher, proportionable 
	//to the hours he/she has been teaching
	public void teach(int hours) {
		super.add_tiredness(lt*hours);
	}

}
