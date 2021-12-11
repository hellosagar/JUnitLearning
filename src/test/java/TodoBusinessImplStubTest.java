import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {

    @Test
    public void retrieveTodosRelatedToSpring_usingAStub() {
        TodoService toDoServiceStub = new ToDoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(toDoServiceStub);
        List<String> filteredToDos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(1, filteredToDos.size());
    }

}