package Lambdas;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // create thread by named class impl Runnable

        /*
        new Thread(new CodeToRun()).start();
         */

        // create thread by anonymous class impl Runnable

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the anonymous Runnable");
            }
        }).start();
         */

        // create thread by lambda

        /*
        new Thread(()-> {
            System.out.println("Printing from the Lambda Runnable");
            System.out.println("Line2");
            System.out.format("This is line %d\n", 3);
        }).start();
        */

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee show = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(show);

        // sort collection by the regular way

        /*
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });
        */

        //sort collection with lambda


        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
