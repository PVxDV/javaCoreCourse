package StringFormatting;

public class Main {

    public static void main(String[] args) {
        String bulletIt = "Print a Bulleted List:\n" + "\t\u2022 First Point\n" + "\t\t\u2022 Sub Point";

        System.out.println(bulletIt);
        //  \" = " " ",  \\ = " \ "

        String textBlock = """
                Print a Bulleted List:
                   \u2022 First Point
                      \u2022 Sub Point """;

        System.out.println(textBlock);

        System.out.println("\n===============\n");

        int age = 30;
        System.out.printf("Your age is %d%n", age);

        int yearOfBirth = 2023 - age;
        System.out.printf("Age = %d, Birth year = %d%n", age, yearOfBirth);

        // %[argument_index$][flags][width][.precision]conversion
        // check doc about Class Formatter https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html

        System.out.printf("Your age is %.0f%n", (float)age);

        System.out.println("\n===============\n");

        for(int i=1; i<=100000; i *= 10) {
            System.out.printf("Printing %6d %n", i);
        }

        System.out.println("\n===============\n");

        String formattedString = String.format("You age is %d", age);
        System.out.println(formattedString);

        formattedString = "You age is %d".formatted(age);
        System.out.println(formattedString);
    }


}
