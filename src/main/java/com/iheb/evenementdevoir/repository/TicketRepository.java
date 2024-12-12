package com.iheb.evenementdevoir.repository;

import com.iheb.evenementdevoir.entite.Ticket;
import com.iheb.evenementdevoir.entite.TrancheAge;
import com.iheb.evenementdevoir.entite.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Long countByInternauteTrancheAgeAndEvenementDateEvenementBetween(
            TrancheAge trancheAge,
            LocalDate dateMin,
            LocalDate dateMax
    );

    @Query("select sum (t.prixTicket) from Ticket t where t.typeTicket= :typeTicket and t.evenement.nomEvenement=:nomEvt" )
    Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket);

    @Query("SELECT t.internaute.idInternaute " +
            "FROM Ticket t " +
            "GROUP BY t.internaute.identifiant " +
            "ORDER BY COUNT(t) DESC LIMIT 1")
    Long internauteLePlusActif();

}
