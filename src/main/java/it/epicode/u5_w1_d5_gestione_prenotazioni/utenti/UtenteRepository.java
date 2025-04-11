package it.epicode.u5_w1_d5_gestione_prenotazioni.utenti;



import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}