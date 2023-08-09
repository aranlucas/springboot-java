package com.example.springbootjava.controller;

import com.example.springbootjava.domain.Todo;
import com.example.springbootjava.exceptions.TodoNotFoundException;
import com.example.springbootjava.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodosController {

    TodoRepository todoRepository;

    @Autowired
    public TodosController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public Iterable<Todo> allTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/")
    public Todo newTodo(@RequestParam Todo newTodo) {
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
