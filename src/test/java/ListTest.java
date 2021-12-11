import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void letsMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        System.out.println();
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet() {
        List listMock = mock(List.class);
        // Argument matcher
        when(listMock.get(anyInt())).thenReturn("666");
        System.out.println();
        assertEquals("666", listMock.get(0));
        assertEquals("666", listMock.get(1));
    }

    @Test
    public void letsMockListGet_throwException() {
        List listMock = mock(List.class);
        // Argument matcher
//        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something fails"));
        System.out.println(when(listMock.subList(anyInt(), anyInt())).thenReturn(Arrays.asList("sd","sd")));
//        assertEquals("666", listMock.get(0));
//        assertEquals("666", listMock.get(1));
    }


}
