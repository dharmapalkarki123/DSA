
package Java8;

public class EmployeeRunAsy {

    private int id;
    private String name;
    private int age;
    private String department;
    private String designation;
    private double salary;
    private boolean isActive;

    // No-argument constructor
    public EmployeeRunAsy() {
    }

    // All-argument constructor
    public EmployeeRunAsy(int id, String name, int age,
                    String department, String designation,
                    double salary, boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.isActive = isActive;
    }

    // Getters and setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "EmployeeRunAsy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", isActive=" + isActive +
                '}';
    }
}


