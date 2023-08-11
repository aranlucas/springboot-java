package com.example.app.todo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Page<Todo> findAll(Pageable page) {
        return todoRepository.findAll(page);
    }

    @CachePut(value = "todos", key = "#todo.id")
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Cacheable(value = "todos", key = "#id")
    public Optional<Todo> findById(String id) {
        return todoRepository.findById(Long.valueOf(id));
    }

    @CacheEvict(value = "todos", allEntries = true)
    public void deleteById(String id) {
        todoRepository.deleteById(Long.valueOf(id));
    }
}
