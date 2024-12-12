package com.iheb.evenementdevoir.repository;

import com.iheb.evenementdevoir.entite.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
