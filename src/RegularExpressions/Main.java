package RegularExpressions;

public class Main {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        // first parameter is a regular expression (regex), second parameter is a replacement
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        System.out.println("======================\n");

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";

        //regex boundary matches
        // "^" - beginning of a line
        // "$" - end of a line
        // "\b" - a word boundary


        // "." means any character
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        // "^" matches only in beginning of the String
        System.out.println(alphanumeric.replaceAll("^abcDee", "YYY"));

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDee", "YYY"));
        System.out.println(secondString.replaceAll("abcDee", "YYY"));

        System.out.println("======================\n");

        // .matches() returns true if whole string matches the regex
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijkl99z"));

        System.out.println("======================\n");

        // "$" - matches only in the end of a line
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));

        System.out.println("======================\n");

        // "[aei]" means "a | e | i"
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));

        // replacement one of the three letters "a" or "e" or "i" if the followed by "F" or "j"
        // !NOTE both characters will replace
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("======================\n");

        // [Hh]arry equals Harry or harry
        System.out.println("Harry".replaceAll("[Hh]arry", "Bob"));
        System.out.println("harry".replaceAll("[Hh]arry", "Bob"));

        System.out.println("======================\n");

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";

        // [^ej] means all except "e" or "j"
        // [^.] - character class
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));

        System.out.println("======================\n");


        // we can use "-" [abcdef345678] equals [a-f3-8]
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]", "X"));

        System.out.println("======================\n");

        // regular expressions are case sensitive
        // we can add (?i) to ignore case sensitive
        // (?iu) - for unicode
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        System.out.println("======================\n");

        // "\\d" means all digits
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));

        // "\\D" means all non digits
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-z]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        System.out.println("======================\n");

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        // "\\s" means whitespace
        System.out.println(hasWhitespace.replaceAll("\\s", "X"));
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        System.out.println(hasWhitespace.replaceAll("\n", "X"));

        // "\\S" means non whitespace
        System.out.println(hasWhitespace.replaceAll("\\S", "X"));

        System.out.println("======================\n");

        // "\\w" a world character [a-zA-Z0-9]
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        // "\\w" a non world character [^\w]
        System.out.println(newAlphanumeric.replaceAll("\\W", "X"));


        System.out.println("======================\n");

        // "\b" word boundary
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));
        // "\B" non word boundary
        System.out.println(hasWhitespace.replaceAll("\\B", "X"));

        System.out.println("======================\n");

        String thirdAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";

        // quantify - "{}", "+", "*", ""
        // e{3} - "e" can occur three times
        // e{2,5} - "e" can occur two, three, four or five times
        // e+ - "e" can occur one or more times
        // e* - "e" can occur any times (zero or more)
        System.out.println(thirdAlphanumeric.replaceAll("^abcDeee", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));



































    }
}
