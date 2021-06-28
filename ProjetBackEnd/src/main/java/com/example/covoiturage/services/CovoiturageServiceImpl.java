package com.example.covoiturage.services;


import com.example.covoiturage.Models.Covoiturage;
import com.example.covoiturage.repository.CovoiturageReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovoiturageServiceImpl implements CovoiturageService{

    @Autowired
    CovoiturageReposotory covoiturageReposotory;

    @Override
    public Covoiturage createCovoiturage(Covoiturage covoiturage) {
        return covoiturageReposotory.save(covoiturage);
    }

    @Override
    public Covoiturage getCovoiturageById(Long id) {
        return covoiturageReposotory.findByIdC(id);
    }

    @Override
    public Covoiturage updateCovoiturae(Long id, Covoiturage covoiturage) {
        covoiturage.setIdC(id);
        return covoiturageReposotory.findByIdC(id);
    }

    @Override
    public void deleteCovoiturage(Long id) {

        try {
            Covoiturage covoiturage=covoiturageReposotory.findByIdC(id);
            covoiturageReposotory.delete(covoiturage);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Covoiturage> getAllCovoiturage() {
        return covoiturageReposotory.findAll();
    }
}
