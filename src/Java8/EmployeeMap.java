package Java8;

public class EmployeeMap {

	
	private int id;
	private String name;
	private String grade;
	private double Salary;
	
	public EmployeeMap(int id,String name,String grade,double Salary) {
		this.id=id;
		this.name=name;
		this.Salary=Salary;
	}
	@Override
	public String toString() {
		return "EmployeeMap [id=" + id + ", name=" + name + ", grade=" + grade + ", Salary=" + Salary + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	
}
