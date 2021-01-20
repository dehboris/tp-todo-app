package com.example.contactsbyvicodart;

public class Contact {
    int id;
    String num;

    public Contact(int id,String num) {
        this.id = id;

        this.num = num;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }



    public Contact( String num) {

        this.num = num;

    }


    public Contact(){

    }
}
