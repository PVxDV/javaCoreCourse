package ExpressionsStatementsCodeBloksMethods;

public class MethodOverload {
    public static void main(String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();
/*        System.out.println("There is " + cacFeetAndInchesToCentimeters(63,0) +
                " cm");
        System.out.println("There is " + cacFeetAndInchesToCentimeters(-6) +
                " cm");*/
        cacFeetAndInchesToCentimeters(6, 0);
        double centimeters = cacFeetAndInchesToCentimeters(6, 13);
        if(centimeters <0.0) {
            System.out.println("Invalid parameters");
        }

        cacFeetAndInchesToCentimeters(157);

    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score +
                " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score +
                " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score.");
        return 0;
    }

    /*public static double cacFeetAndInchesToCentimeters (double feet, double inches) {
        if(feet >= 0 && inches >= 0 && inches <= 12) {
            return ((feet * 12d + inches) * 2.54d);
        } else {
            return -1;
        }
    }

    public static double cacFeetAndInchesToCentimeters (double inches) {
        if(inches >= 0 && inches <= 12) {
            return ( inches * 2.54d);
        } else {
            return -1;
        }*/
    public static double cacFeetAndInchesToCentimeters (double feet, double inches) {

        if((feet < 0) || ((inches < 0) || (inches > 12))) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }
        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters +
                " cm");
        return centimeters;
    }

    public static double cacFeetAndInchesToCentimeters(double inches) {

        if(inches < 0) {
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + "inches is equal to " + feet + " feet and " +
                remainingInches + " inches");
        return  cacFeetAndInchesToCentimeters(feet, remainingInches);
    }
}
