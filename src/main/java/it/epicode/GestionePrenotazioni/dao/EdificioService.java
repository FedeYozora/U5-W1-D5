package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioDAO edificioDAO;

    public void saveEdificio(Edificio edificio) {
        edificioDAO.save(edificio);
        System.out.println("Edificio " + edificio.getNome() + " salvato");
    }
}
