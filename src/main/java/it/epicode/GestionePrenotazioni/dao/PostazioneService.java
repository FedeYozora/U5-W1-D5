package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void savePostazione(Postazione postazione) {
        postazioneDAO.save(postazione);
        System.out.println("Postazione " + postazione.getDescrizione() + " salvata");
    }
}
