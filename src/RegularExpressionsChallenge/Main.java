package RegularExpressionsChallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Challenge1
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        System.out.println("===============\n");
        //Challenge2
        String challenge2 = "I want a ball.";
        String regExpForChallenge2_1 = "I want a b[ia][kl][el].";
        String regExpForChallenge2_2 = "I want a \\w+.";
        String regExpForChallenge2_3 = "I want a (ball|bike).";

        System.out.println(challenge1.matches(regExpForChallenge2_1));
        System.out.println(challenge2.matches(regExpForChallenge2_1));
        System.out.println(challenge1.matches(regExpForChallenge2_2));
        System.out.println(challenge2.matches(regExpForChallenge2_2));
        System.out.println(challenge1.matches(regExpForChallenge2_3));
        System.out.println(challenge2.matches(regExpForChallenge2_3));

        System.out.println("===============\n");

        //Challenge3 Use the Matcher.matches() method
        Pattern patternForChallenge3 = Pattern.compile(regExpForChallenge2_1);
        Matcher matcherForChallenge3 = patternForChallenge3.matcher(challenge1);

        System.out.println(matcherForChallenge3.matches());

        matcherForChallenge3 = patternForChallenge3.matcher(challenge2);

        System.out.println(matcherForChallenge3.matches());

        System.out.println("===============\n");
        //Challenge4 Replace all occurrences of blank with an underscore for the following string
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));
        System.out.println(challenge4.replaceAll(" ", "_"));

        System.out.println("===============\n");
        //Challenge5
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("a+bc+d+ef+g"));
        System.out.println(challenge5.matches("a{3}bc{8}d{3}ef{3}g"));
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        System.out.println("===============\n");
        //Challenge6
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        System.out.println("===============\n");
        //Challenge7
        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[A-Za-z]+\\.\\d+$"));

        System.out.println("===============\n");
        //Challenge8
        String challenge8 = "abcd.135uvqz.7tzik.999";
        String regExpForChallenge8 = "[A-Za-z]+\\.(\\d+)";
        Pattern patternForChallenge8 = Pattern.compile(regExpForChallenge8);
        Matcher matcherForChallenge8 = patternForChallenge8.matcher(challenge8);
        while(matcherForChallenge8.find()){
            System.out.println("Occurrence: " + matcherForChallenge8.group(1));
        }

        System.out.println("===============\n");
        //Challenge9
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String regExpForChallenge9 = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern patternForChallenge9 = Pattern.compile(regExpForChallenge9);
        Matcher matcherForChallenge9 = patternForChallenge9.matcher(challenge9);
        while(matcherForChallenge9.find()){
            System.out.println("Occurrence: " + matcherForChallenge9.group(1));
        }

        System.out.println("===============\n");
        //Challenge10
        String regExpForChallenge10 = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern patternForChallenge10 = Pattern.compile(regExpForChallenge10);
        Matcher matcherForChallenge10 = patternForChallenge10.matcher(challenge9);
        while(matcherForChallenge10.find()){
            System.out.println("Occurrence: " + matcherForChallenge10.start(1) + " to " + (matcherForChallenge10.end(1)-1));
        }

        System.out.println("===============\n");
        //Challenge11
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {666, 436}, {11, 12}";
        String rexExpForChallenge11 = "\\{(\\d+, \\d+)\\}";
        Pattern patternForChallenge11 = Pattern.compile(rexExpForChallenge11);
        Matcher matcherForChallenge11 = patternForChallenge11.matcher(challenge11);
        while(matcherForChallenge11.find()) {
            System.out.println("Occurrence: " + matcherForChallenge11.group(1));
        }

        System.out.println("===============\n");
        //Challenge12 testing ZIP code
        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        System.out.println("===============\n");
        //Challenge13 testing ZIP code
        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
    }
}
