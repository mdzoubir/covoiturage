package com.example.covoiturage.services;

import com.example.covoiturage.Models.Voiture;

import java.util.List;


public interface VoitureService {
    Voiture createVoiture(Voiture voiture, Long userId);
    Voiture getVoitureById(Long id);
    Voiture updateVoiture(Long id,Voiture voiture);
    void deleteVoiture (Long id);
    List<Voiture> geteAllVoiture();
}
