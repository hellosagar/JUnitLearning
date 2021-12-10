import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();

    String input;
    String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data() {
        String[][] expectedOutputs = {
                {"AACD", "CD"},
                {"ACD", "CD"}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void truncateAInFirst2Positions() {
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }

}
