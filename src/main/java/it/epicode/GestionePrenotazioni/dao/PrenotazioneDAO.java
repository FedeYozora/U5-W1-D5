package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Postazione;
import it.epicode.GestionePrenotazioni.entities.Prenotazione;
import it.epicode.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
    boolean existsByDataAndUtenteAndPostazione(LocalDate data, Utente utente, Postazione postazione);

    List<Prenotazione> findByData(LocalDate data);
}
