package com.rest.webservices.RESTfulservicesforAngularToDoList;

import java.util.Date;
import java.util.Objects;

public class Todo {
    private Long id;
    private String username;
    private String description;
    private Date targetDate;

    public Todo(Long id, String username, String description, Date targetDate, Boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    private Boolean isDone;

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Todo other = (Todo) obj;
        if(id != other.id) return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
}