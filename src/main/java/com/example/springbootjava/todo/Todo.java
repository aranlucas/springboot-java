package com.example.springbootjava.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "todos")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable {
    private String content;

    @Id @GeneratedValue private Long id;
}
