import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper = new StringHelper();

    @Test
    public void truncateAInFirst2Positions_AInFirstTwoPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void truncateAInFirst2Positions_AInFirstPosition() {
        assertEquals("D", helper.truncateAInFirst2Positions("AD"));
    }

    @Test
    public void truncateAInFirst2Positions_NoAInWord() {
        assertEquals("CD", helper.truncateAInFirst2Positions("CD"));
    }

    @Test
    public void truncateAInFirst2Positions_AInLastTwoPosition() {
        assertEquals("DAA", helper.truncateAInFirst2Positions("ADAA"));
    }


    @Test
    public void areFirstAndLastTwoCharactersTheSame_OneCharacter() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
    }

    @Test
    public void areFirstAndLastTwoCharactersTheSame_TwoCharacter() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
    }

    @Test
    public void areFirstAndLastTwoCharactersTheSame_IdealCase() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABCCCCCVAB"));
    }

    @Test
    public void areFirstAndLastTwoCharactersTheSame_AllDifferentCharacter() {
        assertFalse("Dummy String is fine",helper.areFirstAndLastTwoCharactersTheSame("ABC"));
    }

}