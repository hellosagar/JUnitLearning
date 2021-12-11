import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class TodoBusinessImpInjectMockTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService toDoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusiness;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void retrieveTodosRelatedToSpring_usingAMock() {
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Design Patters", "Learn Data Structures and Algorithm");
        when(toDoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredToDos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(1, filteredToDos.size());
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingBDD() {
        // Given - given conditions
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Design Patters", "Learn Data Structures and Algorithm");
        given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // When - actions taken
        List<String> filteredToDos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        // Then - result of that action/ validating that action
        assertThat(filteredToDos.size(), is(1));
    }

    @Test
    public void deleteTodosNotRelatedToSpring_usingBDD() {

        // Given - given conditions
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Spring Patterns", "Learn Data Structures and Algorithm");
        given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

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

        // Given - given conditions
        List<String> todos = Arrays.asList("Learn Spring boot", "Learn Design Patterns", "Learn Data Structures and Algorithm");
        given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

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