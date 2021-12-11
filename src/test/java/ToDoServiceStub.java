import java.util.ArrayList;
import java.util.List;

public class ToDoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        ArrayList<String> todos = new ArrayList<>();
        todos.add("Learn Spring boot");
        todos.add("Learn Design Patters");
        todos.add("Learn Data Structures and Algorithm");
        return todos;
    }

    @Override
    public void deleteTodo(String todo) {
        // Do nothing
    }
}
