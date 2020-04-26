package demo.resources;


import demo.db.TodoDb;
import demowizard.generated.TodoInstance.TodoInstanceHandler;
import demowizard.generated.definitions.Todo;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TodoInstanceHandlerImpl implements TodoInstanceHandler {

    private TodoDb database;

    public TodoInstanceHandlerImpl(TodoDb db) {
        this.database = db;
    }

    @Override
    public CompletionStage<GetTodoByIdResponse> getTodoById(String todoId) {
        CompletionStage<GetTodoByIdResponse> resp =
                CompletableFuture.supplyAsync(() -> {
                    Optional<Todo> myTodo = database.get(todoId);
                    if (myTodo.isPresent()) {
                        return GetTodoByIdResponse.Ok(myTodo.get());
                    } else {
                        return GetTodoByIdResponse.NotFound;
                    }
                });
        return resp;
    }

    @Override
    public CompletionStage<UpdateTodoByIdResponse> updateTodoById(String todoId, Todo body) {
        return CompletableFuture.supplyAsync(() -> {
            database.update(todoId, body);
            return UpdateTodoByIdResponse.Ok(body);
        });
    }

    @Override
    public CompletionStage<DeleteTodoByIdResponse> deleteTodoById(String todoId) {
        return CompletableFuture.supplyAsync(() -> {
            database.delete(todoId);
            return DeleteTodoByIdResponse.Ok;
        });
    }
}
