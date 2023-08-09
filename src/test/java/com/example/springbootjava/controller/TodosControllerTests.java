package com.example.springbootjava.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.springbootjava.domain.Todo;
import com.example.springbootjava.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TodosControllerTests {
    @Mock private TodoRepository repository;

    private TodosController controller;

    @BeforeEach
    void setup() {
        controller = new TodosController(repository);
    }

    @Test
    void testGetAll() {
        List<Todo> response = new ArrayList<>();
        when(repository.findAll()).thenReturn(response);

        assertThat(controller.allTodos()).isEmpty();
    }
}
