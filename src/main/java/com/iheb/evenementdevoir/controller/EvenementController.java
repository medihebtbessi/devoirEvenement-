package com.iheb.evenementdevoir.controller;

import com.iheb.evenementdevoir.entite.Evenement;
import com.iheb.evenementdevoir.entite.TrancheAge;
import com.iheb.evenementdevoir.service.EvenementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @PostMapping
    public ResponseEntity<?>  ajouterEvenement( @RequestBody Evenement evenement){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(evenementService.ajouterEvenement(evenement));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> nbInternauteParTrancheAgeEtDateEvenement(@RequestParam TrancheAge trancheAge,@RequestParam LocalDate
            dateMin,@RequestParam LocalDate dateMax){
        try {
            return ResponseEntity.status(
                    HttpStatus.OK
            ).body(evenementService.nbInternauteParTrancheAgeEtDateEvenement(trancheAge, dateMin, dateMax));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
