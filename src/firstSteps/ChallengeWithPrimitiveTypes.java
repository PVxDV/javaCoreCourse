package firstSteps;

public class ChallengeWithPrimitiveTypes {
    public static void main(String[] args) {
        //Challenge
        byte ByteForChallenge = 1;
        int IntForChallenge = 2;
        short ShortForChallenge = 3;
        long LongForChallenge = 50000L + (10L * (ByteForChallenge + IntForChallenge + ShortForChallenge));
        System.out.println(LongForChallenge);

        short shortTotal = (short) (1000 + 10 * (ByteForChallenge + IntForChallenge + ShortForChallenge));
    }
}
