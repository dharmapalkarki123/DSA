package OppsCONCEPT;

// Encapsulation:
// Encapsulation means wrapping data (variables) and methods together
// inside a single class.
// It also means restricting direct access to some data and controlling
// access through methods (getter and setter).

class account {

    // Public variable:
    // It can be accessed from anywhere in the program.
    // Anyone can directly read or modify this variable.
    public String name;


    // Protected variable:
    // It can be accessed:
    // 1. Inside the same class
    // 2. Inside the same package
    // 3. By child classes (inheritance)
    protected String email;


    // Private variable:
    // It cannot be accessed directly from outside this class.
    // This is the main purpose of encapsulation:
    // hiding sensitive data.
    //
    // Example:
    // We don't want anyone to directly change the password like:
    // account1.password = "12345";  (Not allowed)
    //
    // Instead, we use setter and getter methods.
    private String password;



    // Getter Method:
    // Getter is used to READ the value of a private variable.
    //
    // Since password is private, we cannot access it directly.
    // This method provides controlled access to get the password value.
    public String getPassword() {

        // "this" keyword refers to the current object.
        // Here, this.password means the password variable
        // belonging to this particular account object.
        return this.password;
    }



    // Setter Method:
    // Setter is used to MODIFY or SET the value of a private variable.
    //
    // Instead of directly changing password:
    // account1.password = "abcd";  // Not possible
    //
    // We use:
    // account1.setPassword("abcd");
    //
    public void setPassword(String pass) {

        // Assigning the value received from parameter "pass"
        // to the object's password variable.
        //
        // this.password --> class variable
        // pass          --> method parameter
        //
        // Example:
        // pass = "abcd"
        // this.password = "abcd"
        this.password = pass;
    }

}




public class Bank {

    public static void main(String[] args) {


        // Creating an object of account class.
        //
        // account1 is an object that contains:
        // name
        // email
        // password
        account account1 = new account();



        // Accessing public variable directly.
        // Because name is public, we can modify it directly.
        account1.name = "putali";



        // Accessing protected variable.
        // Bank class is in the same package,
        // so protected variable can be accessed.
        account1.email = "putali@gmail.com";



        // Setting password using setter method.
        //
        // We cannot do:
        // account1.password = "abcd";
        //
        // because password is private.
        //
        // Setter provides controlled access.
        account1.setPassword("abcd");



        // Reading values:
        //
        // name:
        // Directly accessed because it is public.
        //
        // email:
        // Directly accessed because it is protected and
        // Bank class belongs to the same package.
        //
        // password:
        // Accessed using getter method because it is private.
        System.out.println(
            "1 " + account1.name +
            " 2 " + account1.email +
            " 3 " + account1.getPassword()
        );


    }

}