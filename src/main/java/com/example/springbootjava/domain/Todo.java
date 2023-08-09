package com.example.springbootjava.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "todos")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String content;

    @Id @GeneratedValue private Long id;
}
