package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.dao.*;
import it.epicode.GestionePrenotazioni.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    UtenteService utenteService;
    @Autowired
    EdificioService edificioService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    private EdificioDAO edificioDAO;

    @Override
    public void run(String... args) {
        //-------------------------------------UTENTI-------------------------------------
        Utente utente1 = new Utente("Yozora", "Federico Bonfiglio", "test@mail.com");
        utenteService.saveUtente(utente1);
        Utente utente2 = new Utente("Pocho", "Thomas Barbato", "thomas.b@mail.com");
        utenteService.saveUtente(utente2);
        //-------------------------------------EDIFICI-------------------------------------
        Edificio edificio = new Edificio("MafiaInternational", "Via Roma 13", "Napoli");
        edificioService.saveEdificio(edificio);
        //-------------------------------------POSTAZIONI-------------------------------------
        Postazione postazione1 = new Postazione("Postazione privata per un massimo di 4 persone", TipoPostazione.PRIVATO, 4, edificio);
        postazioneService.savePostazione(postazione1);
        Postazione postazione2 = new Postazione("Zona open space con un massimo di 10 partecipanti", TipoPostazione.OPENSPACE, 10, edificio);
        postazioneService.savePostazione(postazione2);
        Postazione postazione3 = new Postazione("Sala Riunioni con un massimo di 20 partecipanti", TipoPostazione.SALA_RIUNIONI, 20, edificio);
        postazioneService.savePostazione(postazione3);
        //-------------------------------------PRENOTAZIONI-------------------------------------
        Prenotazione prenotazione = new Prenotazione(LocalDate.now(), utente1, postazione1);
        prenotazioneService.savePrenotazione(prenotazione);
        //Test per verificare che non é possibile far effettuare allo stesso utente due prenotazioni alla stessa postazione nello stesso giorno
        Prenotazione prenotazione2 = new Prenotazione(LocalDate.now(), utente1, postazione1);
        prenotazioneService.savePrenotazione(prenotazione2);
        //Prenotazione di una postazione tra 5 giorni
        Prenotazione prenotazione3 = new Prenotazione(LocalDate.now().plusDays(5), utente2, postazione2);
        prenotazioneService.savePrenotazione(prenotazione3);
        //Ricerca di un Edificio per nome
        edificioService.getEdificioByName("MafiaInternational");
        //Ricerca di una prenotazione in basa alla data
        prenotazioneService.findPrenotazioniByData(LocalDate.parse("2024-02-14"));
        //
        postazioneService.searchPostazioni(TipoPostazione.valueOf("PRIVATO"), "Napoli");
    }
}
