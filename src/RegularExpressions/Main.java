package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println(thirdAlphanumeric.replaceAll("h+i*j", "YYY"));

        System.out.println("======================\n");

        // We use the regular expression h2 as a tag
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        //String h2Pattern = ".*<h2>.*";
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count =0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ":" + matcher.start() + " to " + matcher.end()); // matcher.end return index (!)AFTER the match
        }

        System.out.println("======================\n");

        String h2GroupPattern = "(<h2>.*?</h2>)"; // use group, keep in mind that parentheses aren`t part of the pattern
        // when we work with a groups, we access them using the group method in the matcher class
        // (<h2>.*</h2>) greed quantifier
        // (<h2>.*?</h2>) lazy quantifier
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        System.out.println("======================\n");

        String h2TextGroups = "(<h2>)(.+?)(</h2p>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        System.out.println("======================\n");

        // "abc" means "a" and "b" and "c"
        // [Hh]arry
        System.out.println("harry".replaceAll("[Hh]arry", "Larry"));
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        System.out.println("======================\n");

        //[^abs] means all character except "a" and "b" and "c"
        String tvTest = "tstvtkt";
        //String tNotVRegExp = "t[^v]"; // will not wind third result "t" because after "t" must be following any character
        String tNotVRegExp = "t(?!v)"; // t(?=v) positive regExp
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence: " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("======================\n");
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$ simple US phone number (800) 123-4567
        String phone1 = "1234567890"; // shouldn`t match
        String phone2 = "(123) 456-7890"; //match
        String phone3 = "123 456-7890"; //shouldn`t match
        String phone4 = "(123)456-7890"; //should`t match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        System.out.println("======================\n");
        // ^4[0-9]{12}([0-9]{3})?$ validate VISA card

        String visa1 = "444444444444444"; // shouldn`t match
        String visa2 = "544444444444444"; // shouldn`t match
        String visa3 = "444444444444444444"; // shouldn`t match
        String visa4 = "44444"; // shouldn`t match
        String visa5 = "4444444444444"; // match
        String visa6 = "4444444444444444"; // match

        System.out.println("visa1 = " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 = " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 = " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 = " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa5 = " + visa5.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa6 = " + visa6.matches("^4[0-9]{12}([0-9]{3})?$"));


    }
}
