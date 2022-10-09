package LambdasMore;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
        // we can`t pass suppliers th methods
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

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
