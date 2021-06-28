package com.example.covoiturage.services;

import com.example.covoiturage.Models.Ville;

import java.util.List;

public interface VilleService {
    Ville createVille(Ville ville);
    Ville getVilleById(Long id);
    Ville updateVille(Long id,Ville ville);
    void deleteVille(Long id);
    List<Ville> getAllVille();
}
