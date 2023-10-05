package fr.sii.register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Manager {
    @Id
    private int id;
    private String fullname;
    public Manager() {
    }


    public Manager(int id, String fullname){
        super();
        this.id = id;
        this.fullname = fullname;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}