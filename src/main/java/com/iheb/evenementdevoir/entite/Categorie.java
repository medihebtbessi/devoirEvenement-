package com.iheb.evenementdevoir.entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String codeCategorie;
    private String nomCategorie;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Evenement> evenements;
}
