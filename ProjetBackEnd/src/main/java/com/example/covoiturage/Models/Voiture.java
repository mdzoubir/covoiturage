package com.example.covoiturage.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idV;

    @Column(unique=true)
    private String matricule;

    @NotBlank
    @Column
    private String typeV;

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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTypeV() {
        return typeV;
    }

    public void setTypeV(String typeV) {
        this.typeV = typeV;
    }
}

