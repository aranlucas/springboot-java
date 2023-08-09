package com.example.springbootjava.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Table(name = "todos")
@Entity
@Data
public class Todo {
    private String content;
    
    @Id
    @GeneratedValue
    private Long id; 
}