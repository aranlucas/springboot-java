package com.example.springbootjava.controller;

import com.example.springbootjava.todo.Todo;
import com.example.springbootjava.todo.TodoService;
import com.example.springbootjava.todo.TodosController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TodosControllerTests {
    @Mock private TodoService repository;

    private TodosController controller;

    @BeforeEach
    void setup() {
        controller = new TodosController(repository);
    }

    @Test
    void testGetAll() {
        Pageable pageable = PageRequest.of(0, 5);

        List<Todo> list = new ArrayList<>();

        Page<Todo> result = new PageImpl<>(list);
        when(repository.findAll(any(Pageable.class))).thenReturn(result);

        assertThat(controller.allTodos(pageable)).isEmpty();
    }
}
