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

        /*
        Collections.sort(employees, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));
         */

        // because objects in the same type, we can remove type og objects from first part of the lambda expression

        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        //pass the anonymous class as a parameter

        /*
        String sillyString = doStringStuff(new UpperConcat()  {
                                               @Override
                                               public String upperAndConcat(String s1, String s2) {
                                                   return s1.toUpperCase() + s2.toUpperCase();
                                               }
                                           },
                employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
         */

        // use lambda instead pass the anonymous class as a parameter
        // when we use the lambda expression, we don`t need use return keyword because it`s assumed

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);


    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);

    }
}

