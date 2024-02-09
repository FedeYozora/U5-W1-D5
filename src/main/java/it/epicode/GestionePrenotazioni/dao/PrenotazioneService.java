package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione) {

        boolean checkPrenotazione = prenotazioneDAO.existsByDataAndUtenteAndPostazione(prenotazione.getData(), prenotazione.getUtente(), prenotazione.getPostazione());

        if (checkPrenotazione) {
            System.err.println("ERROR " + prenotazione.getUtente().getName() + ", hai già una prenotazione in questa data e in questa postazione!");
        } else {
            prenotazioneDAO.save(prenotazione);
            System.out.println("Prenotazione in data: " + prenotazione.getData() + " effettuata");
        }
    }
}
