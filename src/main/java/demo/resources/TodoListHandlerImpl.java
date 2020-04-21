package demo.resources;

import demowizard.generated.TodoList.TodoListHandler;
import demowizard.generated.definitions.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TodoListHandlerImpl implements TodoListHandler {

    public Todo getTodo() {
        return (new Todo.Builder())
                .withId("xyz")
                .withTitle("learn things")
                .withCompleted(false)
                .build();
    }

    public List<Todo> todoList() {
        List<Todo> myList = new ArrayList<>();
        myList.add(getTodo());
        myList.add(getTodo());
        myList.add(getTodo());
        return myList;
    }

    @Override
    public CompletionStage<AddTodoResponse> addTodo(Todo body) {
        return CompletableFuture.supplyAsync(() -> {
            return AddTodoResponse.Ok(body);
        });
    }

    @Override
    public CompletionStage<GetTodoListResponse> getTodoList() {
        return CompletableFuture.supplyAsync(() -> {
            return GetTodoListResponse.Ok(todoList());
        });
    }

    @Override
    public CompletionStage<DeleteAllTodosResponse> deleteAllTodos() {
        return CompletableFuture.supplyAsync(() -> {
            return DeleteAllTodosResponse.Ok;
        });
    }
}
