package com.example.app.todo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@Tag(name = "Todos", description = "Todo management APIs")
public class TodosController {

    TodoService todoService;

    @Autowired
    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    @Operation(summary = "Retrieve all todos", description = "Retrieve all todos")
    public Page<Todo> allTodos(
            @SortDefault(sort = "id") Pageable page, @AuthenticationPrincipal OidcUser principal) {
        return todoService.findAll(principal.getEmail(), page);
    }

    @PostMapping
    @Operation(summary = "Create a new todo", description = "Create todo")
    public Todo newTodo(@RequestBody Todo newTodo, @AuthenticationPrincipal OidcUser principal) {
        newTodo.setEmail(principal.getEmail());
        return todoService.save(newTodo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a todo", description = "Get todo")
    public Todo getTodo(@PathVariable String id, @AuthenticationPrincipal OidcUser principal) {
        return todoService
                .findById(id)
                .filter(u -> u.getEmail().equals(principal.getEmail()))
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a todo", description = "Delete todo")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteById(id);
    }
}
