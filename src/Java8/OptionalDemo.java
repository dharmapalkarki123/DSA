
package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static Customer getCustomerByEmailId(String email) throws Exception {

        List<Customer> customers = CustomerDataBase.getAllCustomer();

        return customers.stream()
                .filter(cust -> cust.getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new Exception("No customer present with this email"));
    }

    public static void main(String[] args) throws Exception {

        Customer customer = new Customer(
                1,
                "Ram",
                null,
                Arrays.asList("9819999999", "9820000000")
        );

        // ofNullable(): Safely handles a value that might be null
        Optional<String> emailOptional =
                Optional.ofNullable(customer.getEmail());

        // orElse(): Returns a default value if the Optional is empty
        System.out.println(emailOptional.orElse("default@example.com"));

        // orElseThrow(): Throws an exception if the value is missing
        // System.out.println(emailOptional.orElseThrow(
        //         () -> new IllegalArgumentException("Email not present")
        // ));

        // map(): Transforms the value if present
        String email = emailOptional
                .map(String::toUpperCase)
                .orElseGet(() -> "default@example.com");

        System.out.println(email);

        // findAny() + orElseThrow(): Find a customer or throw an exception
        Customer foundCustomer = getCustomerByEmailId("bikash1@gmail.com");

        System.out.println(foundCustomer);
    }
}