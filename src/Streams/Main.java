package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g62",
                "I26", "I17", "I29",
                "071"
        );

        // regular way to filter, sort and print objects in a list

        /*
        List<String> gNumbers = new ArrayList<>();
        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumbers.forEach((String s) -> System.out.println(s));
        */

        // use Stream instead

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s-> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n==================");

        // build stream from scratch
        // NOTE! we can`t do Stream with mix types
        Stream<String> ioNumberSteam = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "071");

        // we can concatenate Streams
        Stream<String> concatStream = Stream.concat(ioNumberSteam, inNumberStream);
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        System.out.println("\n==================");

        Employee john = new Employee("John Doe" , 30);
        Employee jane = new Employee("Jane Deer" , 25);
        Employee jack = new Employee("Jack Hill" , 40);
        Employee snow = new Employee("Snow White" , 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        //collect stream

        /*
        List<String> sortedGnumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .collect(Collectors.toList());
        */

        //demonstrate that Collectors.toList() accepts 3 arguments
        // 1. supplier - creates objects (ArrayList::new) - construct new ArrayList
        // 2. consumer accumulator - (ArrayList::add) - add single item in to ArrayList (in to result)
        // 3. consumer combiner - (ArrayList::addAll) - sometimes used to improve the efficiency of operation

        List<String> sortedGnumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println("\n==================");

        for(String s : sortedGnumbers) {
            System.out.println(s);
        }

        // we can grouping by age
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println("\n==================");

        // use stream to find youngest employee in company
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);



    }
}
