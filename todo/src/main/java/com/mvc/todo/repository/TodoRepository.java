package com.mvc.todo.repository;

import com.mvc.todo.dao.TodoDao;
import com.mvc.todo.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TodoRepository implements TodoDao {

    @Autowired
    SessionFactory factory;

    @Override
    public int addTodo(Todo todo) {
        Session session = factory.getCurrentSession();
        int id = (int) session.save(todo);
        return id;
    }

    @Override
    public void updateTodo(Todo todo) {
        Session session = factory.getCurrentSession();
        Todo todo1 = (Todo) session.get(Todo.class, todo.getId());
        todo1.setDescription(todo.getDescription());
        todo1.setDone(todo.isDone());
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<Todo>();
        Session session = factory.getCurrentSession();
        todos = session.createQuery("from Todo").getResultList();
        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        Session session = factory.getCurrentSession();
        Todo todo = session.get(Todo.class, id);
        return todo;
    }

    @Override
    public void removeTodo(int id) {
        Session session = factory.getCurrentSession();
        Todo todo = session.get(Todo.class, id);
        session.delete(todo);
    }
}
