package it.epicode.u5_w1_d5_gestione_prenotazioni.prenotazioni;



import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.u5_w1_d5_gestione_prenotazioni.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    Optional<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
    Optional<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}