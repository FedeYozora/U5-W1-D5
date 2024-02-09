package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.dao.EdificioService;
import it.epicode.GestionePrenotazioni.dao.PostazioneService;
import it.epicode.GestionePrenotazioni.dao.PrenotazioneService;
import it.epicode.GestionePrenotazioni.dao.UtenteService;
import it.epicode.GestionePrenotazioni.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(String... args) throws Exception {
        Utente utente = new Utente("Federico", "Bonfiglio", "test@mail.com");
        utenteService.saveUtente(utente);
    }
}
