package com.mvc.todo.dao;

import com.mvc.todo.model.Todo;

import java.util.List;

public interface TodoDao {

    int addTodo(Todo todo);

    void updateTodo(Todo todo);

    List<Todo> getAllTodos();

    Todo getTodoById(int id);

    void removeTodo(int id);

}
