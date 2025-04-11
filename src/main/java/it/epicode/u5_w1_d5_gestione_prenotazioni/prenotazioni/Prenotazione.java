package it.epicode.u5_w1_d5_gestione_prenotazioni.prenotazioni;

import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.u5_w1_d5_gestione_prenotazioni.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;

    public void confermaPrenotazione() {
        System.out.println("Prenotazione confermata per il giorno " + dataPrenotazione);
    }
}