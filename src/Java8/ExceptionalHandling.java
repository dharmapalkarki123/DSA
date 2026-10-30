
package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionalHandling {

    public static void main(String[] args) {

        // A list of String values.
        // Three values are valid integers, but "xys" is not.
        // Integer.parseInt("xys") will generate NumberFormatException.

        List<String> list = Arrays.asList("44", "347", "123", "xys");


        // A list containing zero and one.
        // Dividing 10 by zero will generate ArithmeticException.

        List<Integer> list2 = Arrays.asList(1, 0);


        // A list containing two integer values.
        // We will use these values with Thread.sleep().
        // Thread.sleep() is a checked-exception method because
        // it can throw InterruptedException.

        List<Integer> list3 = Arrays.asList(10, 20);


        // =========================================================
        // APPROACH 1: Normal method reference
        // =========================================================

        // forEach() takes one element at a time from the list.
        // Each element is passed to the printList() method.
        //
        // printList() handles the exception internally using try-catch.

        // list.forEach(ExceptionalHandling::printList);


        // =========================================================
        // APPROACH 2: Exception handling using Consumer
        // =========================================================

        // handleExceptionIfAny() accepts a Consumer as an argument.
        //
        // The lambda expression converts String into Integer.
        //
        // Integer.parseInt(s) converts a String into an integer.
        // If conversion fails, NumberFormatException occurs.
        //
        // Our handleExceptionIfAny() method catches that exception
        // and prints the exception message.

        // list.forEach(
        //     handleExceptionIfAny(s ->
        //         System.out.println(Integer.parseInt(s))
        //     )
        // );


        // =========================================================
        // APPROACH 3: Generic exception handling
        // =========================================================

        // handleGenericException() is a generic method.
        //
        // First argument:
        // Lambda expression containing the actual operation.
        //
        // Second argument:
        // The exception class that we specifically want to handle.
        //
        // Here, ArithmeticException is the exception we want to handle.
        //
        // For list2:
        // 10 / 1 = 10
        // 10 / 0 = ArithmeticException
        //
        // The method handles ArithmeticException and prints its message.
        // Other exception types are passed on as unchecked exceptions.

        // list2.forEach(
        //     handleGenericException(
        //         s -> System.out.println(10 / s),
        //         ArithmeticException.class
        //     )
        // );


        // =========================================================
        // APPROACH 4: Traditional try-catch inside forEach()
        // =========================================================

        /*
        list3.forEach(i -> {

            try {

                // Thread.sleep() pauses the current thread
                // for the specified number of milliseconds.
                //
                // i = 10 means sleep for 10 milliseconds.
                // i = 20 means sleep for 20 milliseconds.

                Thread.sleep(i);

                System.out.println(i);

            } catch (InterruptedException e) {

                // Handles the checked InterruptedException.

                e.printStackTrace();
            }
        });
        */


        // =========================================================
        // APPROACH 5: Handling checked exceptions using a wrapper
        // =========================================================

        // Problem:
        //
        // Thread.sleep() throws InterruptedException.
        //
        // However, Consumer<T> does not allow its accept() method
        // to declare checked exceptions.
        //
        // Therefore, we cannot directly write:
        //
        // list3.forEach(i -> Thread.sleep(i));
        //
        // Solution:
        //
        // We create our own functional interface that allows
        // checked exceptions.
        //
        // handleCheckedExceptionConsumer() converts the checked
        // exception into an unchecked RuntimeException.
        //
        // This makes it possible to use Thread.sleep() inside
        // the forEach() lambda.

        list3.forEach(
            handleCheckedExceptionConsumer(i -> {

                Thread.sleep(i);

                System.out.println(i);

            })
        );


        System.out.println("///////////////");


        // =========================================================
        // APPROACH 6: Generic exception handler with String parsing
        // =========================================================

        // Here, we specifically want to handle NumberFormatException.
        //
        // "44", "347" and "123" can be converted successfully.
        //
        // "xys" cannot be converted into an integer.
        //
        // The generic handler catches NumberFormatException.

        // list.forEach(
        //     handleGenericException(
        //         s -> Integer.parseInt(s),
        //         NumberFormatException.class
        //     )
        // );


        // =========================================================
        // APPROACH 7: Using Stream API with map()
        // =========================================================

        // map() transforms each String into an Integer.
        //
        // Integer::parseInt is a method reference.
        //
        // collect() collects all converted values into a List.
        //
        // IMPORTANT:
        // If "xys" is present, NumberFormatException occurs.
        // The stream operation terminates because no exception
        // handler is provided here.

        // List<Integer> inList = list.stream()
        //     .map(Integer::parseInt)
        //     .collect(Collectors.toList());
        //
        // System.out.println(inList);


        // =========================================================
        // APPROACH 8: Direct try-catch inside Stream/forEach
        // =========================================================

        /*
        list.stream().forEach(s -> {

            try {

                // Convert String into Integer and print it.

                System.out.println(Integer.parseInt(s));

            } catch (Exception e) {

                // Handle the exception directly inside lambda.

                System.out.println("Exception: " + e.getMessage());
            }
        });
        */

        // This approach works, but repeating try-catch inside
        // every lambda makes code lengthy.
        //
        // A reusable exception handler is cleaner when the
        // same exception-handling logic is needed in multiple places.

    }


    // =============================================================
    // METHOD 1: Normal exception handling using Consumer
    // =============================================================

    /*
     * Consumer<String> means:
     * This method accepts a String as input and returns nothing.
     *
     * payload:
     * Represents the actual operation that we want to execute.
     *
     * The method returns another Consumer<String>.
     *
     * The returned Consumer:
     * 1. Accepts a String.
     * 2. Executes the original Consumer.
     * 3. Handles any Exception using try-catch.
     */

    static Consumer<String> handleExceptionIfAny(
            Consumer<String> payload) {

        return obj -> {

            try {

                // Execute the actual operation.
                //
                // For example:
                // Integer.parseInt(obj)

                payload.accept(obj);

            } catch (Exception e) {

                // If an exception occurs, handle it here.
                // The program can continue with the next element.

                System.out.println("Exception: " + e.getMessage());
            }
        };
    }


    // =============================================================
    // METHOD 2: Generic exception handling
    // =============================================================

    /*
     * <Target, ExObj extends Exception>
     *
     * Target:
     * Represents the type of input.
     *
     * ExObj:
     * Represents the exception class that we want to handle.
     *
     * ExObj extends Exception means:
     * ExObj must be Exception or one of its subclasses.
     *
     * targetConsumer:
     * Contains the actual operation that we want to execute.
     *
     * exObjClass:
     * Contains the exception class that we specifically want
     * to handle.
     *
     * Example:
     * ArithmeticException.class
     * NumberFormatException.class
     *
     * This method returns Consumer<Target>.
     */

    static <Target, ExObj extends Exception>
    Consumer<Target> handleGenericException(
            Consumer<Target> targetConsumer,
            Class<ExObj> exObjClass) {

        return obj -> {

            try {

                // Execute the actual operation.
                targetConsumer.accept(obj);

            } catch (Exception e) {

                // Check whether the exception that occurred
                // matches the exception class provided by the caller.
                //
                // isInstance() checks the actual exception object
                // against the requested exception class.

                if (exObjClass.isInstance(e)) {

                    // Convert the exception into the requested
                    // exception type.

                    ExObj exObj = exObjClass.cast(e);

                    // Handle the matching exception.

                    System.out.println(
                        "Exception: " + exObj.getMessage()
                    );

                } else {

                    // If the exception is not the expected type,
                    // do not silently ignore it.
                    //
                    // Consumer cannot throw checked exceptions,
                    // so rethrow it as an unchecked exception.

                    if (e instanceof RuntimeException) {
                        throw (RuntimeException) e;
                    }

                    throw new RuntimeException(e);
                }
            }
        };
    }


    // =============================================================
    // METHOD 3: Handling checked exceptions in Consumer
    // =============================================================

    /*
     * <Target>
     * Represents the type of input.
     *
     * CheckedExceptionalHandlerConsumer:
     * Our own functional interface.
     *
     * Unlike Java's Consumer, its accept() method can declare
     * a checked exception.
     *
     * Here, Exception is used as the allowed exception type.
     *
     * The method returns a normal Consumer<Target>.
     *
     * Why?
     *
     * Because forEach() accepts Consumer, not our custom
     * checked-exception functional interface.
     *
     * Therefore, we wrap our custom interface inside Consumer.
     */

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

                // Java Consumer cannot throw checked exceptions.
                //
                // Therefore, convert the checked exception
                // into an unchecked RuntimeException.

                throw new RuntimeException(e);
            }
        };
    }


    // =============================================================
    // METHOD 4: Normal method to print String as Integer
    // =============================================================

    /*
     * This is an alternative to handleExceptionIfAny().
     *
     * It accepts a String, converts it into Integer,
     * and handles any exception internally.
     */

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

    /*
     * Java's Consumer interface does not allow checked exceptions.
     *
     * So we create our own functional interface.
     *
     * @FunctionalInterface means:
     * This interface must have exactly one abstract method.
     *
     * Target:
     * Represents the input type.
     *
     * Ex:
     * Represents the checked exception type.
     *
     * extends Exception:
     * Ensures that Ex is an exception class.
     *
     * throws Ex:
     * Allows the accept() method to throw a checked exception.
     */

  

}
