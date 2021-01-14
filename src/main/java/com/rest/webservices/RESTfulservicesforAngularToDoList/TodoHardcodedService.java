package com.rest.webservices.RESTfulservicesforAngularToDoList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo((long) ++idCounter, "amandaw", "Learn REST", new Date(), false));
        todos.add(new Todo((long) ++idCounter, "amandaw", "Learn Angular", new Date(), false));
        todos.add(new Todo((long) ++idCounter, "amandaw", "Get a job", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) return null;
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
