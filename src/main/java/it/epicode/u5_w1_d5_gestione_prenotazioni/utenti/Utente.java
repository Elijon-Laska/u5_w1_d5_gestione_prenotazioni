package it.epicode.u5_w1_d5_gestione_prenotazioni.utenti;

import it.epicode.u5_w1_d5_gestione_prenotazioni.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cognome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(Long id, String username, String nomeCompleto, String email, List<Prenotazione> prenotazioni) {
        this.id = id;
        this.username = username;
        this.nome= nome;
        this.cognome= cognome;
        this.email = email;
        this.prenotazioni = prenotazioni;
    }
}