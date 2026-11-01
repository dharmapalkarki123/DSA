
package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionalHandling {

    public static void main(String[] args) {

        // String list containing valid and invalid integer values.
        // "xys" will generate NumberFormatException during parsing.

        List<String> list = Arrays.asList("44", "347", "123", "xys");


        // Integer list containing zero and one.
        // Dividing a number by zero will generate ArithmeticException.

        List<Integer> list2 = Arrays.asList(1, 0);


        // Integer list used for Thread.sleep().
        // Thread.sleep() throws checked InterruptedException.

        List<Integer> list3 = Arrays.asList(10, 20);


        // =========================================================
        // APPROACH 1: Normal Method Reference
        // =========================================================

        // forEach() passes each element to the printList() method.
        // printList() handles exceptions internally using try-catch.

        /*
        list.forEach(ExceptionalHandling::printList);
        */


        // =========================================================
        // APPROACH 2: Exception Handling Using Consumer
        // =========================================================

        // handleExceptionIfAny() accepts a Consumer as an argument.
        // Integer.parseInt() converts String into Integer.
        // Invalid String values generate NumberFormatException.
        // The exception is handled inside handleExceptionIfAny().

        /*
        list.forEach(
            handleExceptionIfAny(s ->
                System.out.println(Integer.parseInt(s))
            )
        );
        */


        // =========================================================
        // APPROACH 3: Generic Exception Handling
        // =========================================================

        // handleGenericException() is a generic method.
        // First argument contains the actual operation.
        // Second argument specifies the exception class to handle.
        // ArithmeticException is handled by this example.
        // Other exception types are rethrown.

        /*
        list2.forEach(
            handleGenericException(
                s -> System.out.println(10 / s),
                ArithmeticException.class
            )
        );
        */


        // =========================================================
        // APPROACH 4: Traditional Try-Catch Inside forEach()
        // =========================================================

        // Thread.sleep() pauses the current thread.
        // i = 10 means sleep for 10 milliseconds.
        // i = 20 means sleep for 20 milliseconds.
        // InterruptedException is handled using catch.

        /*
        list3.forEach(i -> {

            try {

                Thread.sleep(i);

                System.out.println(i);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        });
        */


        // =========================================================
        // APPROACH 5: Handling Checked Exceptions Using Wrapper
        // =========================================================

        // Problem:
        // Consumer<T> does not allow its accept() method to declare
        // checked exceptions using the throws keyword.
        //
        // Thread.sleep() throws InterruptedException.
        //
        // Solution:
        // Create a custom functional interface that supports checked
        // exceptions and wrap it inside a normal Consumer.
        //
        // handleCheckedExceptionConsumer() converts the checked
        // exception into an unchecked RuntimeException.

        list3.forEach(
            handleCheckedExceptionConsumer(i -> {

                Thread.sleep(i);

                System.out.println(i);

            })
        );


        System.out.println("///////////////");


        // =========================================================
        // APPROACH 6: Generic Exception Handler With String Parsing
        // =========================================================

        // NumberFormatException is the exception we want to handle.
        // Valid String values are converted into Integer.
        // Invalid String "xys" generates NumberFormatException.
        // The generic handler handles the specified exception.

        /*
        list.forEach(
            handleGenericException(
                s -> Integer.parseInt(s),
                NumberFormatException.class
            )
        );
        */


        // =========================================================
        // APPROACH 7: Using Stream API With map()
        // =========================================================

        // map() transforms each String into an Integer.
        // Integer::parseInt is a method reference.
        // collect() collects the converted values into a List.
        // Invalid String values generate NumberFormatException.
        // No exception handling is provided in this example.

        /*
        List<Integer> inList = list.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        System.out.println(inList);
        */


        // =========================================================
        // APPROACH 8: Direct Try-Catch Inside Stream/forEach
        // =========================================================

        // Exception handling is written directly inside the lambda.
        // This works, but repeating try-catch makes code lengthy.
        // A reusable exception handler makes the code cleaner.

        /*
        list.stream().forEach(s -> {

            try {

                System.out.println(Integer.parseInt(s));

            } catch (Exception e) {

                System.out.println("Exception: " + e.getMessage());

            }

        });
        */

    }


    // =============================================================
    // METHOD 1: Normal Exception Handling Using Consumer
    // =============================================================

    // Consumer<String> accepts String input and returns nothing.
    // payload represents the original operation passed by the caller.
    // This method returns another Consumer<String>.
    // The returned Consumer executes the original operation.
    // If an exception occurs, the catch block handles it.

    static Consumer<String> handleExceptionIfAny(
            Consumer<String> payload) {

        return obj -> {

            try {

                // Execute the original Consumer operation.

                payload.accept(obj);

            } catch (Exception e) {

                // Handle the exception and print its message.

                System.out.println("Exception: " + e.getMessage());

            }

        };
    }


    // =============================================================
    // METHOD 2: Generic Exception Handling
    // =============================================================

    // Target represents the input data type.
    // ExObj represents the exception type.
    // ExObj extends Exception restricts it to exception classes.
    //
    // targetConsumer contains the actual operation.
    // exObjClass represents the exception class we want to handle.
    //
    // Example:
    // ArithmeticException.class
    // NumberFormatException.class
    //
    // This method returns Consumer<Target>.

    static <Target, ExObj extends Exception>
    Consumer<Target> handleGenericException(
            Consumer<Target> targetConsumer,
            Class<ExObj> exObjClass) {

        return obj -> {

            try {

                // Execute the actual operation.

                targetConsumer.accept(obj);

            } catch (Exception e) {

                // isInstance() checks whether the actual exception
                // matches the exception class provided by the caller.

                if (exObjClass.isInstance(e)) {

                    // cast() converts the exception into the requested
                    // exception type.

                    ExObj exObj = exObjClass.cast(e);

                    // Handle the matching exception.

                    System.out.println(
                        "Exception: " + exObj.getMessage()
                    );

                } else {

                    // If the exception does not match the requested type,
                    // do not silently ignore it.
                    //
                    // Runtime exceptions can be rethrown directly.
                    // Other exceptions are wrapped in RuntimeException.

                    if (e instanceof RuntimeException) {

                        throw (RuntimeException) e;

                    }

                    throw new RuntimeException(e);

                }

            }

        };
    }


    // =============================================================
    // METHOD 3: Handling Checked Exceptions Inside Consumer
    // =============================================================

    // Target represents the input data type.
    // CheckedExceptionalHandlerConsumer is our custom functional interface.
    //
    // Unlike Java's Consumer, this custom interface allows its accept()
    // method to declare checked exceptions.
    //
    // This method returns a normal Consumer<Target>.
    // forEach() accepts Consumer, so we wrap our custom interface
    // inside the Consumer implementation.
    //
    // Checked exceptions are converted into RuntimeException.

    static <Target>
    Consumer<Target> handleCheckedExceptionConsumer(
            CheckedExceptionalHandlerConsumer<Target, Exception>
                    handleConsumer) {

        return obj -> {

            try {

                // Execute the operation that may throw
                // a checked exception.

                handleConsumer.accept(obj);

            } catch (Exception e) {

                // Convert checked exception into unchecked exception.

                throw new RuntimeException(e);

            }

        };
    }


    // =============================================================
    // METHOD 4: Normal Method to Print String as Integer
    // =============================================================

    // This method is an alternative to handleExceptionIfAny().
    // It accepts String, converts it into Integer and prints the result.
    // If conversion fails, the exception is handled internally.

    /*
    public static void printList(String s) {

        try {

            System.out.println(Integer.parseInt(s));

        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());

        }

    }
    */


    // =============================================================
    // CUSTOM FUNCTIONAL INTERFACE
    // =============================================================

    // Java's built-in Consumer does not support checked exceptions.
    // Therefore, we create our own functional interface.
    //
    // @FunctionalInterface ensures that the interface has exactly
    // one abstract method.
    //
    // Target represents the input data type.
    // Ex represents the checked exception type.
    // Ex extends Exception restricts Ex to exception classes.
    //
    // throws Ex allows the accept() method to throw a checked exception.

    

}
