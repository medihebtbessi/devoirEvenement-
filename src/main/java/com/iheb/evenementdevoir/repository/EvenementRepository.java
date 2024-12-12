package com.iheb.evenementdevoir.repository;

import com.iheb.evenementdevoir.entite.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {

}
