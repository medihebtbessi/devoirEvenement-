package com.iheb.evenementdevoir.controller;

import com.iheb.evenementdevoir.entite.Internaute;
import com.iheb.evenementdevoir.service.InternauteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InternauteController {

    @Autowired
    private  InternauteService internauteService;

    @PostMapping("/inter")
    public ResponseEntity<?> ajouterInternaute(@RequestBody Internaute internaute){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(internauteService.ajouterInternaute(internaute));
        }catch (Exception e){
            throw new RuntimeException("Erreur ");
        }
    }
}
