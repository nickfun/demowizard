package demo.resources;


import demowizard.generated.TodoInstance.TodoInstanceHandler;
import demowizard.generated.definitions.Todo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TodoInstanceHandlerImpl implements TodoInstanceHandler {

    public Todo getTodo(String id) {
        Todo.Builder b = new Todo.Builder();
        return b.withId(id).withTitle("Learn Java").withOrder(100).build();
    }

    @Override
    public CompletionStage<GetTodoByIdResponse> getTodoById(String todoId) {
        CompletionStage<GetTodoByIdResponse> resp =
                CompletableFuture.supplyAsync(() -> GetTodoByIdResponse.Ok(getTodo(todoId)));
        return resp;
    }

    @Override
    public CompletionStage<UpdateTodoByIdResponse> updateTodoById(String todoId, Todo body) {
        return CompletableFuture.supplyAsync(() -> {
            return UpdateTodoByIdResponse.Ok(getTodo("Updated " + todoId));
        });
    }

    @Override
    public CompletionStage<DeleteTodoByIdResponse> deleteTodoById(String todoId) {
        return CompletableFuture.supplyAsync(() -> {
            return DeleteTodoByIdResponse.Ok;
        });
    }
}
