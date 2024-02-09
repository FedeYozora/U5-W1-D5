package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Edificio;
import it.epicode.GestionePrenotazioni.entities.Postazione;
import it.epicode.GestionePrenotazioni.entities.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;
    @Autowired
    private EdificioService edificioService;

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

    public void searchPostazioni(TipoPostazione tipo, String city) {
        Edificio edificioFound = edificioService.getEdificioByCity(city);
        List<Postazione> found = postazioneDAO.findByTypeAndEdificio(tipo, edificioFound);
        System.out.println("Postazioni di tipo " + tipo + " nella cittá di " + city + " trovate:" + found);
    }
}
