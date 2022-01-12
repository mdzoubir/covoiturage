package com.example.covoiturage.services;

import com.example.covoiturage.Models.User;
import com.example.covoiturage.Models.Voiture;
import com.example.covoiturage.repository.UserRepository;
import com.example.covoiturage.repository.VoitureReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements  VoitureService{


    @Autowired
    VoitureReposotory voitureReposotory;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Voiture createVoiture(Voiture voiture, Long userId) {
        User user = userRepository.findById(userId).get();
        voiture.setUser(user);
        return voitureReposotory.save(voiture);
    }

    @Override
    public Voiture getVoitureById(Long id) {
        return voitureReposotory.findVoitureByIdV(id);
    }

    @Override
    public Voiture updateVoiture(Long id, Voiture voiture) {
        voiture.setIdV(id);
        return voitureReposotory.save(voiture);
    }

    @Override
    public void deleteVoiture(Long id) {
        try {
            Voiture voiture=voitureReposotory.findVoitureByIdV(id);
            voitureReposotory.delete(voiture);
        }
        catch(Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    public List<Voiture> geteAllVoiture() {
        return voitureReposotory.findAll();
    }
}
