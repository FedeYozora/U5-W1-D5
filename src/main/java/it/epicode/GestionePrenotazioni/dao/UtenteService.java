package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    public void saveUtente(Utente utente) {
        utenteDAO.save(utente);
        System.out.println("Utente " + utente.getName() + " salvato");
    }
}
