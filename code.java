import java.util.LinkedHashMap;
class Main {
	public static void main (String[] args) {
	  //Record book for students
		RecordBook<Student, Integer> gradeBook = new RecordBook<>();
		Student student1 = new Student("Bob", 1); //initializes name and id
		Student student2 = new Student("Angel", 2);
		Student student3 = new Student("Mark", 3);

		gradeBook.addRecord(student1, 95); //passes object as a key and grade as value
		gradeBook.addRecord(student2, 90);
		gradeBook.addRecord(student3, 85);

		gradeBook.updateRecord(student2, 88);
		gradeBook.printAllRecord();
        
    //Record book for graduate students
		RecordBook<Student, String> gradBook = new RecordBook<>();
		GraduateStudent grad1 = new GraduateStudent("Mary", 101, "Research1"); //Initializes name, id, and research title
		GraduateStudent grad2 = new GraduateStudent("Elle", 201, "Research2");
		GraduateStudent grad3 = new GraduateStudent("John", 301, "Research3");
		
		gradBook.addRecord(grad1, grad1.getThesisTitle()); //passes object as a key and string as a value
		gradBook.addRecord(grad2, grad2.getThesisTitle());
		gradBook.addRecord(grad3, grad3.getThesisTitle());
		
		gradBook.updateRecord(grad2, "Research5");
		gradBook.printAllRecord();
	}
}

//Generic class which is compatible with different data types
class RecordBook<T extends Student, U> { //(T extends Student) ensures that it will always be a Student or subclass kinda like restriction
	private LinkedHashMap<T, U> record = new LinkedHashMap<>();
    
  //add record
	public void addRecord(T student, U info) {
		record.put(student, info);
	}
    
  //get record
	public U getInfo(T student) {
		return record.get(student);
	}

  //update record
	public void updateRecord(T student, U newInfo) {
		record.replace(student, newInfo);
	}

  //display all records
	public void printAllRecord() {
		System.out.println("\nBook Records:");
		for (T student : record.keySet()) {
			System.out.println(student.getName() + " (ID: " + student.getIdNumber() + ") - " + record.get(student));
		}
	}
}

class Student { //class for students
	private String name;
	private int idNumber;

	Student(String name, int idNumber) {
		this.name = name;
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public int getIdNumber() {
		return idNumber;
	}
}

class GraduateStudent extends Student { // class for graduate student that extends Student class
    private String thesisTitle;

    public GraduateStudent(String name, int idNumber, String thesisTitle) {
        super(name, idNumber);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }
}
