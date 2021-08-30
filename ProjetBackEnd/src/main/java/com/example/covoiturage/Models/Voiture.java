package com.example.covoiturage.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idV;

    @Column(unique=true)
    private String Matricule;

    @NotBlank
    @Column
    private String TypeV;

    @NotBlank
    @Column
    private String color;

    @NotBlank
    @Column
    private String datExpertassurance;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
 public  Voiture()
 {

 }

    public Long getIdV() {
        return idV;
    }

    public void setIdV(Long idV) {
        this.idV = idV;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getDatExpertassurance() {
        return datExpertassurance;
    }

    public void setDatExpertassurance(String datExpertassurance) {
        this.datExpertassurance = datExpertassurance;
    }
}

