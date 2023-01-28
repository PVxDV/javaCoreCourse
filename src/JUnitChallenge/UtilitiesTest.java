package JUnitChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {
    private Utilities utilities;

    @Before
    public void setup() {
        utilities = new Utilities();
    }

    @Test
    public void everyNthChar() throws Exception{
        char[] input = {'h','e','l','l', 'o'};
        assertArrayEquals(new char[]  {'e', 'l'},utilities.everyNthChar(input, 2));
        assertNull(null, utilities.everyNthChar(null, 2));
        assertArrayEquals(input,utilities.everyNthChar(input, 6));
    }

    @Test
    public void removePairs() throws Exception{
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("A", utilities.removePairs("AA"));
        assertEquals("", utilities.removePairs(""));
        assertNull(utilities.removePairs(null));
    }

    @Test
    public void converter() throws Exception{
        assertEquals(300, utilities.converter(10,5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() throws Exception {
        utilities.converter(10,0);
    }

    @Test
    public void nullIfOddLength() throws Exception{
        assertNull(utilities.nullIfOddLength("odd"));
        assertEquals("even", utilities.nullIfOddLength("even"));
        assertNotNull(utilities.nullIfOddLength("even"));
    }
}