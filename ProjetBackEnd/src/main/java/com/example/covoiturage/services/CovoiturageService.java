package com.example.covoiturage.services;

import com.example.covoiturage.Models.Covoiturage;
import com.example.covoiturage.responce.CovoiturageResponce;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CovoiturageService {
    Covoiturage createCovoiturage(Covoiturage covoiturage);
    Covoiturage getCovoiturageById(Long id);
    Covoiturage updateCovoiturae(Long id,Covoiturage covoiturage);
    void deleteCovoiturage(Long id);
    List<CovoiturageResponce> getAllCovoiturage();
    List<CovoiturageResponce> getListCinq(int page);
    List<Covoiturage> getListDate();
}
