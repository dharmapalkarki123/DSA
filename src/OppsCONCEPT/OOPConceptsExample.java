package OppsCONCEPT;

//Interface
interface Payable {
 void calculateSalary();
}

//Abstract class (Abstraction)
abstract class Employee {
 // Encapsulation (private variables)
 private int id;
 private String name;

 // Constructor
 public Employee(int id, String name) {
     this.id = id;
     this.name = name;
 }

 // Encapsulation using getters
 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 // Abstract method
 public abstract void work();
}

//Inheritance + Polymorphism
class Developer extends Employee implements Payable {

 public Developer(int id, String name) {
     super(id, name);
 }

 @Override
 public void work() {
     System.out.println(getName() + " is writing Java code.");
 }

 @Override
 public void calculateSalary() {
     System.out.println("Developer salary: 80,000");
 }
}

//Inheritance + Polymorphism
class Tester extends Employee implements Payable {

 public Tester(int id, String name) {
     super(id, name);
 }

 @Override
 public void work() {
     System.out.println(getName() + " is testing the application.");
 }

 @Override
 public void calculateSalary() {
     System.out.println("Tester salary: 60,000");
 }
}

//Main class
public class OOPConceptsExample {

 public static void main(String[] args) {

     // Polymorphism
     Employee emp1 = new Developer(1, "Dharmapal");
     Employee emp2 = new Tester(2, "Rahul");

     emp1.work();
     emp2.work();

     // Interface reference
     Payable p1 = new Developer(3, "Amit");
     Payable p2 = new Tester(4, "Suman");

     p1.calculateSalary();
     p2.calculateSalary();
 }
}

