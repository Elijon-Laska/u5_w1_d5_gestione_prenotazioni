package it.epicode.u5_w1_d5_gestione_prenotazioni.services;


import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.PostazioneRepository;
import it.epicode.u5_w1_d5_gestione_prenotazioni.prenotazioni.Prenotazione;
import it.epicode.u5_w1_d5_gestione_prenotazioni.prenotazioni.PrenotazioneRepository;
import it.epicode.u5_w1_d5_gestione_prenotazioni.utenti.Utente;
import it.epicode.u5_w1_d5_gestione_prenotazioni.utenti.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final UtenteRepository utenteRepository;
    private final PostazioneRepository postazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, UtenteRepository utenteRepository, PostazioneRepository postazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.utenteRepository = utenteRepository;
        this.postazioneRepository = postazioneRepository;
    }

    @Transactional
    public String creaPrenotazione(Long utenteId, Long postazioneId, LocalDate dataPrenotazione) {
        Optional<Utente> utenteOpt = utenteRepository.findById(utenteId);
        Optional<Postazione> postazioneOpt = postazioneRepository.findById(postazioneId);

        if (utenteOpt.isEmpty() || postazioneOpt.isEmpty()) {
            return "Errore: Utente o Postazione non esistenti.";
        }

        Utente utente = utenteOpt.get();
        Postazione postazione = postazioneOpt.get();


        if (prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, dataPrenotazione).isPresent()) {
            return "Errore: L'utente ha già una prenotazione per questa data.";
        }


        if (prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione).isPresent()) {
            return "Errore: La postazione è già occupata in questa data.";
        }


        Prenotazione nuovaPrenotazione = new Prenotazione();
        nuovaPrenotazione.setUtente(utente);
        nuovaPrenotazione.setPostazione(postazione);
        nuovaPrenotazione.setDataPrenotazione(dataPrenotazione);
        prenotazioneRepository.save(nuovaPrenotazione);

        return "Prenotazione effettuata con successo per il " + dataPrenotazione + "!";
    }

}
