package com.iheb.evenementdevoir.entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;
    private String nomEvenement;
    private Long nbPlacesRestaurant;
    private LocalDate dateEvenement;
    @ManyToMany(mappedBy = "evenements")
    private List<Categorie> categories;
    @OneToMany(mappedBy = "evenement")
    private List<Ticket> tickets;
}
