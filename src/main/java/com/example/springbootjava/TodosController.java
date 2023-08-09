package com.example.springbootjava;

import com.example.springbootjava.domain.Todo;
import com.example.springbootjava.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    
    @PostMapping("/create")
    public Todo createTodo(@RequestParam String content) {
        Todo newTodo = new Todo(content);
        todoRepository.save(newTodo);
        return newTodo;
    }

    @PostMapping("/delete")
    public void deleteTodo(@RequestParam Long id) {
        todoRepository.deleteById(id);
    }
}
