package dalmeida.ariane.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class Todo implements Serializable {

    private String nom;
    private boolean done;

    public Todo(String name)
    {
        this.nom=name;
    }

    public String getNom()
    {
        return nom;
    }
    public void setName(String name)
    {
        this.nom=name;
    }

}