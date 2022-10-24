package JavaSimulation;

public final class Classroom extends Operating_Room {

	private String classroomID;
	private int c_class;
	private int students_counter;
	private Teacher teacher;
	private Student[] students;
	
	//Constructor for Classroom, initializes its data members, prints a message
	Classroom(String classromID, int c_cl)
	{
		classroomID= classromID;
		c_class= c_cl;
		teacher= null;
		students_counter= 0;
	    students= new Student[c_class]; // Allocates memory for the
	                                      // maximum capacity of students
	    System.out.println("A New Class has been created!\n"); 
	}

	//Prints a message and the people in the classroom
	void print(){
		System.out.println("\nPeople in class " + classroomID + " are:\n\n");
		for (int i=0 ; i < students_counter ; i++) {
			students[i].print();
		}
		System.out.println("\n");
		teacher.print();
	}

	//Places the teacher in the classroom
	void place(Teacher teache) {
	    teacher= teache;
	    teacher.change_status();//Makes the teacher aware he/she is in classroom
	}

	//Places the new student in the students array
	//Also updates the students_counter and the student's location
	void enter(Student new_student) {
	    students[students_counter]= new_student;
	    students[students_counter].get_in_your_classroom();
		System.out.println(new_student.get_name() + " enters classroom !\n");
	    students_counter++;
	}

	//Accessor for data member "classroomID"
	String get_classroomID() {
	    return classroomID;
	}

	//Makes the teacher teach and the students attend a lesson
	//for a duration of some hours, which has as a result
	//their tiredness to be increased
	void operate(int hours) {
		int i;

		for (i=0 ; i < students_counter ; i++) {
			students[i]. attend(hours);
		}
		teacher.teach(hours);
	}
	
	//Returns true if the classroom is empty
	//Returns false if there are still students 
	//(even if there is only one) in the classroom
	boolean is_empty() {
		if (students_counter > 0) {
			return false;
		} else {return true;}
	}
	
	//Takes a student out of the classroom
	//Doesn't make any emptiness/fullness checks
	//Returns the exiting student
	Student exit() {
		String name;
		students_counter--;
		students[students_counter].change_status();
		name= students[students_counter].get_name();
		System.out.println("\n" + name +  " starts exiting!\n");
		System.out.println(name +  " exits classroom!\n");
		return students[students_counter];
	}
	
	//Takes the teacher out of his/her classroom
	void teacher_out() {
		String name, classID;
		
		this.teacher.change_status();
		name= this.teacher.get_name();
		classID= this.teacher.get_classroomID();
		System.out.println("The teacher " + name + " of classroom " + classID + " is out!\n");
	}

}
