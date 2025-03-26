package Functions;

//Class with private data members
class Person {
 private String name;  // Private variable
 private int age;      // Private variable

 // Public getter method for name
 public String getName() {
     return name;
 }

 // Public setter method for name
 public void setName(String name) {
     this.name = name;
 }

 // Public getter method for age
 public int getAge() {
     return age;
 }

 // Public setter method for age
 public void setAge(int age) {
     if (age > 0) { // Ensuring age is valid
         this.age = age;
     } else {
         System.out.println("Age must be positive!");
     }
 }
}

//Main class to test encapsulation
public class Encapsulation {
 public static void main(String[] args) {
     Person p = new Person();  // Creating an object

     // Setting values using setter methods
     p.setName("John");
     p.setAge(25);

     // Getting values using getter methods
     System.out.println("Name: " + p.getName());
     System.out.println("Age: " + p.getAge());
 }
}

