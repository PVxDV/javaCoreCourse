package Lambdas;

import org.w3c.dom.ls.LSOutput;

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

        System.out.println("============================");

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
        // if we want to reuse lambda expression we have to save it in a variable
        // or we can pass it inside a method

        /*
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
        */

        // if we have more than one expression in lambda, we have to use curly braces and return keyword
        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        System.out.println("============================");

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        System.out.println("============================");

        // there is new instance of Employee each iteration of for loop, so it`s effectively final

        /*
        for (Employee employee : employees) {
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

        System.out.println("============================");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        }
        */


        //more effective code
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);

    }
}

class AnotherClass {
    public String doSomething() {
        int i = 0;

        // regular way

        /*
        System.out.println("The AnotherClass class`s name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class`s name is: " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
         */

        // with lambda

        /*
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression`s class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class`s name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1", "String2");

         */

        //  local variables referenced from a lambda expression must be final or effectively final
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression`s class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class`s name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}

