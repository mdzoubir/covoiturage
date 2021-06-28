package com.example.covoiturage.services;


import com.example.covoiturage.Models.Ville;
import com.example.covoiturage.repository.VilleReposptory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImpl implements VilleService{

    @Autowired
    VilleReposptory villeReposptory;

    @Override
    public Ville createVille(Ville ville) {
        return villeReposptory.save(ville);
    }

    @Override
    public Ville getVilleById(Long id) {
        return villeReposptory.findVilleByIdVille(id);
    }

    @Override
    public Ville updateVille(Long id, Ville ville) {
        ville.setIdVille(id);
        return villeReposptory.save(ville);
    }

    @Override
    public void deleteVille(Long id) {
        try {
            Ville ville=villeReposptory.findVilleByIdVille(id);
            villeReposptory.delete(ville);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<Ville> getAllVille() {
        return villeReposptory.findAll();
    }
}
