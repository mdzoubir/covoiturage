package com.example.covoiturage.services;


import com.example.covoiturage.Models.Covoiturage;
import com.example.covoiturage.Models.User;
import com.example.covoiturage.Models.Voiture;
import com.example.covoiturage.repository.CovoiturageReposotory;
import com.example.covoiturage.repository.UserRepository;
import com.example.covoiturage.repository.VoitureReposotory;
import com.example.covoiturage.responce.CovoiturageResponce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class CovoiturageServiceImpl implements CovoiturageService{

    @Autowired
    CovoiturageReposotory covoiturageReposotory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoitureReposotory voitureReposotory;

    @Override
    public Covoiturage createCovoiturage(Covoiturage covoiturage, Long userId, String carMatricule) {
        Voiture voiture = voitureReposotory.findByMatricule(carMatricule);
        User user = userRepository.findById(userId).get();
        covoiturage.setUser(user);
        covoiturage.setVoiture(voiture);
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
    public List<CovoiturageResponce> getAllCovoiturage() {
        List<Covoiturage> covoiturages = covoiturageReposotory.findAll();
        List<CovoiturageResponce> covoiturageResponces = new ArrayList<>();
        for (Covoiturage covoiturage : covoiturages){
            CovoiturageResponce covoiturageResponce = new CovoiturageResponce();
            BeanUtils.copyProperties(covoiturage, covoiturageResponce);
            covoiturageResponce.setUsername(covoiturage.getUser().getFullName());
            covoiturageResponces.add(covoiturageResponce);
        }
        return covoiturageResponces;
    }

    @Override
    public List<CovoiturageResponce> getListCinq(int limit) {
        PageRequest pageable = PageRequest.of(0, limit);
        List<Covoiturage> logsPage = covoiturageReposotory.findListeCinq(pageable);
        List<CovoiturageResponce> covoiturageResponces = new ArrayList<>();
        for (Covoiturage covoiturage : logsPage){
            CovoiturageResponce covoiturageResponce = new CovoiturageResponce();
            BeanUtils.copyProperties(covoiturage, covoiturageResponce);
            covoiturageResponce.setUsername(covoiturage.getUser().getFullName());
            covoiturageResponces.add(covoiturageResponce);
        }
        return covoiturageResponces;
    }

    @Override
    public List<Covoiturage> getListDate() {
        Date date=new Date();
        return  covoiturageReposotory.findListDate(date);
    }

}
