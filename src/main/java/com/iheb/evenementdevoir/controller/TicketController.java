package com.iheb.evenementdevoir.controller;

import com.iheb.evenementdevoir.entite.Ticket;
import com.iheb.evenementdevoir.entite.TypeTicket;
import com.iheb.evenementdevoir.service.TicketService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket/{idEvenement}/{idInternaute}")
    public ResponseEntity<?> ajouterTicketsEtAffecterAEvenementEtInternaut(@RequestBody List<Ticket> tickets, @PathVariable("idEvenement") Long
            idEvenement, @PathVariable("idInternaute") Long idInternaute ){
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets,idEvenement,idInternaute));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping("/montant")
    public ResponseEntity<?> montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketService.montantRecupereParEvtEtTypeTicket(nomEvt,typeTicket));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("get")
    public ResponseEntity<?> internauteLePlusActif(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketService.internauteLePlusActif());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
