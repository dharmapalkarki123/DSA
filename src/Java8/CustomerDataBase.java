package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDataBase {

    public static List<Customer> getAllCustomer() {

        return Stream.of(
                new Customer(101, "Ram", "ram@gmail.com",
                        Arrays.asList("728243252", "327530547")),

                new Customer(102, "Shyam", "shyam@gmail.com",
                        Arrays.asList("9841234567", "9812345678")),

                new Customer(103, "Hari", "hari@gmail.com",
                        Arrays.asList("9801234567", "9821234567")),

                new Customer(104, "Sita", "sita@gmail.com",
                        Arrays.asList("9811111111", "9822222222")),

                new Customer(105, "Gita", "gita@gmail.com",
                        Arrays.asList("9803333333", "9844444444")),

                new Customer(106, "Ramesh", "ramesh@gmail.com",
                        Arrays.asList("9815555555", "9826666666")),

                new Customer(107, "Suresh", "suresh@gmail.com",
                        Arrays.asList("9807777777", "9848888888")),

                new Customer(108, "Bikash", "bikash@gmail.com",
                        Arrays.asList("9819999999", "9820000000")),

                new Customer(109, "Anita", "anita@gmail.com",
                        Arrays.asList("9801112222", "9843334444")),

                new Customer(110, "Nabin", "nabin@gmail.com",
                        Arrays.asList("9812223333", "9824445555"))
        ).collect(Collectors.toList());
    }
}