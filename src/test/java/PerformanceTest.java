import org.junit.Test;

import java.util.Arrays;

public class PerformanceTest {

    @Test(timeout = 20)
    public void testSort_Performance(){
        int[] numbers = {12,125456,34534645};
        for (int i = 0; i <100000 ; i++) {
            numbers[0] = i;
            Arrays.sort(numbers);
        }
    }

}