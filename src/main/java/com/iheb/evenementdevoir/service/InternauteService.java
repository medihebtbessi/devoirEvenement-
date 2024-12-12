package com.iheb.evenementdevoir.service;

import com.iheb.evenementdevoir.entite.Internaute;
import com.iheb.evenementdevoir.repository.InternauteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternauteService {
    @Autowired
    private  InternauteRepository internauteRepository;

    public Internaute ajouterInternaute (Internaute internaute) {
        return internauteRepository.save(internaute);
    }




}
