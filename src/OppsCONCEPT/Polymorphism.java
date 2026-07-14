package OppsCONCEPT;

// Compile-time polymorphism = Method Overloading
// Same method name, but different parameters

class Student {

    int age;
    String name;

    // Method 1 → only age
    public void printInfo(int age) {
        System.out.println("Student Age: " + age);
    }

    // Method 2 → only name
    public void printInfo(String name) {
        System.out.println("Student Name: " + name);
    }

    // Method 3 → both age and name
    public void printInfo(int age, String name) {
        System.out.println("Student Details: Name = " + name + ", Age = " + age);
    }

    // Extra method → no parameter (for better understanding)
    public void printInfo() {
        System.out.println("No information provided.");
    }
}

public class Polymorphism {

    public static void main(String[] args) {

        // Creating object of Student class
        Student s1 = new Student();

        // Assigning values
        s1.name = "Rameshwor";
        s1.age = 24;

        // Calling different overloaded methods

        s1.printInfo();                     // No parameter
        s1.printInfo(s1.age);               // Only age
        s1.printInfo(s1.name);              // Only name
        s1.printInfo(s1.age, s1.name);      // Both age and name
    }
}