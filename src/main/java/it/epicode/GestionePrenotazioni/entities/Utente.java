package it.epicode.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Prenotazione> prenotazioni;

    public Utente(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
