package com.example.covoiturage.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Voiture {
    @Id
    private String Matricule;

    @NotBlank
    @Column
    private String TypeV;

    @NotBlank
    @Column
    private String color;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
 public  Voiture()
 {

 }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public String getTypeV() {
        return TypeV;
    }

    public void setTypeV(String typeV) {
        TypeV = typeV;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
