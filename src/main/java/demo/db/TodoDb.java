package demo.db;

import demowizard.generated.definitions.Todo;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TodoDb {

    private Map<String, Todo> database = new ConcurrentHashMap<>();

    public Todo add(Todo myTodo) {
        String id = UUID.randomUUID().toString();
        Todo withId = (new Todo.Builder(myTodo)).withId(id).build();
        database.put(id, withId);
        return withId;
    }

    public void update(String id, Todo myTodo) {
        Todo withId = (new Todo.Builder(myTodo)).withId(id).build();
        database.put(id, myTodo);
    }

    public Optional<Todo> get(String id) {
        if (database.containsKey(id)) {
            return Optional.of(database.get(id));
        }
        return Optional.empty();
    }

    public Collection<Todo> getAll() {
        return database.values();
    }

    public void delete(String id) {
        database.remove(id);
    }
}
