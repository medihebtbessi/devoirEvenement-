package com.iheb.evenementdevoir.service;

import com.iheb.evenementdevoir.entite.Categorie;
import com.iheb.evenementdevoir.entite.Evenement;
import com.iheb.evenementdevoir.entite.TrancheAge;
import com.iheb.evenementdevoir.repository.CategorieRepository;
import com.iheb.evenementdevoir.repository.EvenementRepository;
import com.iheb.evenementdevoir.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public Evenement ajouterEvenement(Evenement evenement){
        return evenementRepository.save(evenement);
    }

    @Scheduled(fixedRate = 30000)
    public void listeEvenementsParCategorie() {
        List<Categorie> categorieList = categorieRepository.findAll();
        List<Evenement> evenementList =evenementRepository.findAll();
        for (Categorie cat:categorieList){
            log.info(cat.getNomCategorie());
            for (Evenement eve:cat.getEvenements()){
                log.info(eve.getNomEvenement());
            }
        }
    }

    public Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate
            dateMin, LocalDate dateMax){
        return ticketRepository.countByInternauteTrancheAgeAndEvenementDateEvenementBetween(trancheAge,dateMin,dateMax);
    }

}
