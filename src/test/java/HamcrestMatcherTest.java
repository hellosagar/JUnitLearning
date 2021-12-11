import org.junit.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

public class HamcrestMatcherTest {

    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 106);

        assertThat(scores, hasItems(99, 100, 106));
        // Has scores > 90 and less than 200
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(200)));

        // String
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());

        // Arrays
        Integer[] marks = {1,2,3};

        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1, 2, 3));
        assertThat(marks, arrayContainingInAnyOrder(2, 1, 3));


    }

}
