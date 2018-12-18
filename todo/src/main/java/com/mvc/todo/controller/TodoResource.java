package com.mvc.todo.controller;

import com.mvc.todo.model.Todo;
import com.mvc.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class TodoResource {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoRepository.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return todoRepository.getTodoById(id);
    }

    @PostMapping("/todos")
    public int saveTodo(@RequestBody Todo todo) {
        return todoRepository.addTodo(todo);
    }

    @PutMapping("/todos/")
    public void updateTodo(@RequestBody Todo todo) {
        todoRepository.updateTodo(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoRepository.removeTodo(id);
    }
}
