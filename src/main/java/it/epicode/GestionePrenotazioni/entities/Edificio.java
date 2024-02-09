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
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String indirizzo;
    private String city;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Postazione> postazioni;

    public Edificio(String nome, String indirizzo, String city) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.city = city;
    }
}
