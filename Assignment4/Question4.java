
public class Question4 {
	public static void main(String[] args) {
		Student a = new Student("a", 1);
		Student b = new Student("b", 2);
		Student c = new Student("c", 3);
		Student d = new Student("d", 4);
		Student e = new Student("e", 5);
		Student f = new Student("f", 6);
		Student g = new Student("g", 7);
		Student h = new Student("h", 8);
		Student i = new Student("i", 9);
		Student k = new Student("k", 10);
		Student l = new Student("l", 11);
		Course test = new Course();
		test.registerStudent(a);
		test.registerStudent(b);
		test.registerStudent(c);
		test.registerStudent(d);
		test.registerStudent(e);
		test.registerStudent(f);
		test.registerStudent(g);
		test.registerStudent(h);
		test.registerStudent(i);
		test.registerStudent(k);
		test.registerStudent(l);
	}
}

class Student{
	
	private String name;
	private int id;
	
	public Student() {
	}
	
	public Student(String name, int id) {
		this.setName(name);
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

class Course{
	private String title;
	private int numberOfStudent;
	private int maxNum = 10;
	private Student[] students = new Student[maxNum];
	
	public Course () {
	}
	
	public Course (String title) {
		this.setTitle(title);
	}
	
	public Student[] getStudent() {
		return students;
	}
	
	public boolean isFull() {
		return numberOfStudent >= maxNum;
	}
	
	public boolean registerStudent(Student Student) {
		if(isFull() == true) {
			System.out.println("The class is full");
			return true;
		}
		else {
			numberOfStudent = numberOfStudent + 1;
			System.out.println("Registered");
			return false;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}