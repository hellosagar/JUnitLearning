import org.junit.Test;

import java.util.Arrays;

public class ExceptionsTest {

    @Test(expected = NullPointerException.class)
    public void test_NullArray() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

}
