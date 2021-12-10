import org.junit.*;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayCompareTest {

    @Test
    public void test(){
        int[] numbers = {3, 0 ,1, 2};
        int[] expected = {0, 1, 2, 3};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

}
