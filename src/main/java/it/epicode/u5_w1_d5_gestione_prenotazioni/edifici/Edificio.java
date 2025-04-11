package it.epicode.u5_w1_d5_gestione_prenotazioni.edifici;

import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.Postazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "edifici")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 150)
    private String indirizzo;

    @Column(nullable = false, length = 50)
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
}