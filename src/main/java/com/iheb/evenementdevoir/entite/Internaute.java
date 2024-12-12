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
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternaute;
    private Long identifiant;
    @Enumerated(value = EnumType.STRING)
    private TrancheAge trancheAge;
    @OneToMany(mappedBy = "internaute")
    private List<Ticket> tickets;
}
