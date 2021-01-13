package com.rest.webservices.RESTfulservicesforAngularToDoList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static{
        todos.add(new Todo((long) ++idCounter, "amandaw", "Learn REST", new Date(), false));
        todos.add(new Todo((long) ++idCounter, "amandaw", "Learn Angular", new Date(), false));
        todos.add(new Todo((long) ++idCounter, "amandaw", "Get a job", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }
}
