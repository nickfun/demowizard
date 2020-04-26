package demo.resources;

import demo.db.TodoDb;
import demowizard.generated.TodoList.TodoListHandler;
import demowizard.generated.definitions.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TodoListHandlerImpl implements TodoListHandler {

    private TodoDb database;

    public TodoListHandlerImpl(TodoDb db) {
        this.database = db;
    }

    @Override
    public CompletionStage<AddTodoResponse> addTodo(Todo body) {
        return CompletableFuture.supplyAsync(() -> {
            Todo inserted = database.add(body);
            return AddTodoResponse.Ok(inserted);
        });
    }

    @Override
    public CompletionStage<GetTodoListResponse> getTodoList() {
        return CompletableFuture.supplyAsync(() -> {
            return GetTodoListResponse.Ok(new ArrayList<>(database.getAll()));
        });
    }

    @Override
    public CompletionStage<DeleteAllTodosResponse> deleteAllTodos() {
        return CompletableFuture.supplyAsync(() -> {
            database.getAll().forEach((todo) -> {
                database.delete(todo.getId().orElse(""));
            });
            return DeleteAllTodosResponse.Ok;
        });
    }
}
