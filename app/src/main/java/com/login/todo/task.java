package com.login.todo;

public class task {
    int id;
    String title;

    public task(String title){
        this.title = title;
    }

    public  task(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public task(int id, String title){
        this.id = id;
        this.title = title;
    }
}
