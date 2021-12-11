import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    public void retrieveTodosRelatedToSpring_usingAMock() {
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Design Patters", "Learn Data Structures and Algorithm");
        TodoService toDoServiceMock = mock(TodoService.class);
        when(toDoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(toDoServiceMock);
        List<String> filteredToDos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(1, filteredToDos.size());
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingBDD() {
        // Given - given conditions
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Design Patters", "Learn Data Structures and Algorithm");
        TodoService toDoServiceMock = mock(TodoService.class);
        given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(toDoServiceMock);

        // When - actions taken
        List<String> filteredToDos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        // Then - result of that action/ validating that action
        assertThat(filteredToDos.size(), is(1));
    }

    @Test
    public void deleteTodosNotRelatedToSpring_usingBDD() {

        // Declare argument captor
        // Define argument captor on specific method call
        // Capture the argument
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);


        // Given - given conditions
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Spring Patterns", "Learn Data Structures and Algorithm");
        TodoService toDoServiceMock = mock(TodoService.class);
        given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(toDoServiceMock);

        // When - actions taken
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        // Then - result of that action/ validating that action
//        verify(toDoServiceMock).deleteTodo("Learn Design Patters");
//        verify(toDoServiceMock, atLeastOnce()).deleteTodo("Learn Data Structures and Algorithm");
//
//        verify(toDoServiceMock, never()).deleteTodo("Learn swimming");

        // BBD style
        then(toDoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue(), is("Learn Data Structures and Algorithm"));
    }

    @Test
    public void deleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {

        // Declare argument captor
        // Define argument captor on specific method call
        // Capture the argument
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);


        // Given - given conditions
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Design Patterns", "Learn Data Structures and Algorithm");
        TodoService toDoServiceMock = mock(TodoService.class);
        given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(toDoServiceMock);

        // When - actions taken
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        // Then - result of that action/ validating that action
        verify(toDoServiceMock).deleteTodo("Learn Design Patterns");
        verify(toDoServiceMock, atLeastOnce()).deleteTodo("Learn Data Structures and Algorithm");
        verify(toDoServiceMock, never()).deleteTodo("Learn swimming");

        then(toDoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }

}