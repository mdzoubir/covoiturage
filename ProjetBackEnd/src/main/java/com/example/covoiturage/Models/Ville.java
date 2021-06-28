package com.example.covoiturage.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVille;

    @NotBlank
    @Column
    private String nameVile;


    @ManyToOne
    @JoinColumn(columnDefinition = "idC")
    private  Covoiturage covoiturage;

    public Ville()
    {

    }

    public Long getIdVille() {
        return idVille;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public String getNameVile() {
        return nameVile;
    }

    public void setNameVile(String nameVile) {
        this.nameVile = nameVile;
    }

    public Covoiturage getCovoiturage() {
        return covoiturage;
    }

    public void setCovoiturage(Covoiturage covoiturage) {
        this.covoiturage = covoiturage;
    }
}
