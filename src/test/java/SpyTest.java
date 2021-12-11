import org.junit.*;

import org.mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;


/**
 * Stub - It's a sample implementation of class which we have to maintain. Its also called Partial Mock
 * Spy -  Retains all the logic of class, and we can override any specific behaviour [Avoid Spy] because of its behaviour it's harder to maintain
 * Mock - Here we have to dynamically stub every functionality otherwise default value will return. There is no logic behind the mock for it to use [Dummy implementation]
 */
public class SpyTest {

    @Test
    public void test(){
        ArrayList<Integer> arrayListMock = spy(ArrayList.class);
        arrayListMock.add(1);
        Assert.assertThat(arrayListMock.size(), is(1));
        given(arrayListMock.size()).willReturn(5);
        Assert.assertThat(arrayListMock.size(), is(5));

    }

}
