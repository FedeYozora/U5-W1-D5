package it.epicode.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione type;
    private int maxPartecipanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, TipoPostazione type, int maxPartecipanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.type = type;
        this.maxPartecipanti = maxPartecipanti;
        this.edificio = edificio;
    }
}
