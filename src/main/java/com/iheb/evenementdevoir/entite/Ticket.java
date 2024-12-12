package com.iheb.evenementdevoir.entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String codeTicket;
    private Double prixTicket;
    @Enumerated(value = EnumType.STRING)
    private TypeTicket typeTicket;
    @ManyToOne()
    private Evenement evenement;
    @ManyToOne
    private Internaute internaute;
}
