package fr.sii.register.model;

import jakarta.persistence.*;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullname;
    @JsonManagedReference
    @OneToMany(mappedBy = "manager") // Cette annotation crée la liaison avec la table "Register"
    private List<Register> registers;

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

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }
}