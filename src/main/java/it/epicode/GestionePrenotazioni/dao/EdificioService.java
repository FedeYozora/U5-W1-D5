package it.epicode.GestionePrenotazioni.dao;

import it.epicode.GestionePrenotazioni.entities.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioDAO edificioDAO;

    public void saveEdificio(Edificio edificio) {
        edificioDAO.save(edificio);
        System.out.println("Edificio " + edificio.getNome() + " salvato");
    }

    public Edificio getEdificioById(Long id) {
        return edificioDAO.findById(id).orElse(null);
    }

    public List<Edificio> getAllEdifici() {
        return edificioDAO.findAll();
    }

    public void getEdificioByName(String name) {
        Edificio found = edificioDAO.findByNome(name);
        System.out.println("Edificio trovato: " + found);
    }

    public Edificio getEdificioByCity(String citta) {
        return edificioDAO.findByCity(citta);
    }
}
