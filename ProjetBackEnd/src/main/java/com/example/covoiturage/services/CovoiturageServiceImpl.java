package com.example.covoiturage.services;


import com.example.covoiturage.Models.Covoiturage;
import com.example.covoiturage.repository.CovoiturageReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

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

    @Override
    public List<Covoiturage> getListCinq(int limit) {
        PageRequest pageable = PageRequest.of(0, limit);
        List<Covoiturage> logsPage = covoiturageReposotory.findListeCinq(pageable);
        System.out.println(logsPage.size());
        return logsPage;
    }

    @Override
    public List<Covoiturage> getListDate() {
        Date date=new Date();
        return  covoiturageReposotory.findListDate(date);
    }


}
