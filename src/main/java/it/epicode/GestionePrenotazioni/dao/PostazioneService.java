package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void savePostazione(Postazione postazione) {
        postazioneDAO.save(postazione);
        System.out.println("Postazione " + postazione.getDescrizione() + " salvata");
    }

    public Postazione getPostazioneById(Long id) {
        return postazioneDAO.findById(id).orElse(null);
    }

    public List<Postazione> getAllPostazioni() {
        return postazioneDAO.findAll();
    }
}
