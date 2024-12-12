package com.iheb.evenementdevoir.service;

import com.iheb.evenementdevoir.entite.Evenement;
import com.iheb.evenementdevoir.entite.Internaute;
import com.iheb.evenementdevoir.entite.Ticket;
import com.iheb.evenementdevoir.entite.TypeTicket;
import com.iheb.evenementdevoir.repository.EvenementRepository;
import com.iheb.evenementdevoir.repository.InternauteRepository;
import com.iheb.evenementdevoir.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private InternauteRepository internauteRepository;


    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute ){
        Evenement evenement=evenementRepository.findById(idEvenement).orElseThrow(()->new EntityNotFoundException("Evenement not found"));
        Internaute internaute=internauteRepository.findById(idInternaute).orElseThrow(()->new EntityNotFoundException("Internaute not found"));
        if (tickets.size()>evenement.getNbPlacesRestaurant()){
            throw new UnsupportedOperationException("nombre de places demandées indisponibe");
        }else {
            evenement.setNbPlacesRestaurant(evenement.getNbPlacesRestaurant()-tickets.size());
            for (Ticket tik :tickets){
                tik.setEvenement(evenement);
                tik.setInternaute(internaute);
            }
        }

        return ticketRepository.saveAll(tickets);
    }

    public Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket){
        return ticketRepository.montantRecupereParEvtEtTypeTicket(nomEvt,typeTicket);
    }
    public Long internauteLePlusActif(){
        return ticketRepository.internauteLePlusActif();
    }

}
