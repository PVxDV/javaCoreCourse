package LambdasMore;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee show = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);


        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(show);
        employees.add(red);
        employees.add(charming);

        /*
        System.out.println("Employees over 30:");
        System.out.println("==================");
        */

        // regular way

        /*
        for(Employee employee : employees) {
            if(employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        }
        */

        //with lambda

        /*
        employees.forEach(employee -> {
            if(employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });
        */

        /*
        System.out.println("\nEmployees 30 and younger:");
        System.out.println("=========================");
        employees.forEach(employee -> {
            if(employee.getAge() <= 30) {
                System.out.println(employee.getName());
            }
        });
        */

        // refactor with Predicate functional interface
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 abd under", employee -> employee.getAge() <= 30);

        // use anonymous Predicate instance
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        System.out.println("\n==================");

        // NOTE! To improve readability we have to use specific type of Predicate functional interface

        IntPredicate intP = i -> i > 15;
        System.out.println(intP.test(10));
        int a = 20;
        System.out.println(intP.test(a + 5));

        System.out.println("\n==================");

        // we can use chain Predicate with method .and()
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        // lambda like a nested block of code
        // just example

        /*
        {
            int i;
            return i > 15;
        }

        {
            int i;
            return i < 100;
        }
        */
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        System.out.println("\n==================");

        // regular way to print 10 random values
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(1000));
        }

        System.out.println("\n==================");

        // we can use Supplier in this scenario. Because Supplier always return a value, we have to include return keyword
        // we can`t pass suppliers in the methods
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        System.out.println("\n==================");

        // regular way to take a last name

        /*
        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last Name is: " + lastName);
        });
        */

        // get lastName by Function. 1st parameter is obj that we past, 2nd parameter is type of return value
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        // we have to use .apply method to start the Function
        // advantage of using Function -> we can pass code to the method that accepts and return a value
        // in format of lambda expression and run that code without to create an interface and a class that impl the interface
        String lastName = getLastName.apply(employees.get(2));
        System.out.println(lastName);

        // Function to get a first name
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        System.out.println("\n==================");

        String firstName = getFirstName.apply(employees.get(2));
        System.out.println(firstName);

        System.out.println("\n==================");

        // we use method to print last or first names
        Random random1 = new Random();
        for(Employee employee : employees) {
            if(random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        System.out.println("\n==================");

        // we can use chain Functions as a Predicate by method .andThen()
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstNameFunction = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstNameFunction);
        System.out.println(chainedFunction.apply(employees.get(0)));

        System.out.println("\n==================");

        // if we need 2 argument if Function, we can use BI interface
        // we can`t chain BI functions, but if BI function in the first position of the chain, it`s possible
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        System.out.println("\n==================");

        // UnaryOperator accepts and return value of the same type
        IntUnaryOperator intBy5 = i -> i + 5;
        System.out.println(intBy5.applyAsInt(10));

        System.out.println("\n==================");

        // chained version for Consumer
        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World!");


    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("==================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
