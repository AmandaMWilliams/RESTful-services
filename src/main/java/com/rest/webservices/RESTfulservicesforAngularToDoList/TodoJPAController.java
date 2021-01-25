package com.rest.webservices.RESTfulservicesforAngularToDoList;

import com.rest.webservices.RESTfulservicesforAngularToDoList.Todo;
import com.rest.webservices.RESTfulservicesforAngularToDoList.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoJPAController {

    @Autowired
    private TodoHardcodedService todoService;

    @Autowired
    private TodoJPARepository todoJPARepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoJPARepository.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoJPARepository.findById(id).get();
    }

    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.deleteById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //edit/update a Todo
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
        Todo todoUpdated = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    //create a new Todo
    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(
            @PathVariable String username, @RequestBody Todo todo){
        Todo createdToDo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdToDo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
