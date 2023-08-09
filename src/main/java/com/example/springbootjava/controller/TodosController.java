package com.example.springbootjava.controller;

import com.example.springbootjava.domain.Todo;
import com.example.springbootjava.exceptions.TodoNotFoundException;
import com.example.springbootjava.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodosController {

    TodoRepository todoRepository;

    @Autowired
    public TodosController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public Page<Todo> allTodos(@SortDefault(sort = "id") Pageable page) {
        return todoRepository.findAll(page);
    }

    @PostMapping("/")
    public Todo newTodo(@RequestBody Todo newTodo) {
        return todoRepository.save(newTodo);
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
