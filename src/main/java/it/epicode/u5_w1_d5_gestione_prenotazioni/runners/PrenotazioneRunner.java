package it.epicode.u5_w1_d5_gestione_prenotazioni.runners;

import it.epicode.u5_w1_d5_gestione_prenotazioni.edifici.Edificio;
import it.epicode.u5_w1_d5_gestione_prenotazioni.edifici.EdificioRepository;
import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.Postazione;
import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.PostazioneRepository;
import it.epicode.u5_w1_d5_gestione_prenotazioni.postazioni.TipoPostazione;
import it.epicode.u5_w1_d5_gestione_prenotazioni.services.PrenotazioneService;
import it.epicode.u5_w1_d5_gestione_prenotazioni.utenti.Utente;
import it.epicode.u5_w1_d5_gestione_prenotazioni.utenti.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    private final PrenotazioneService prenotazioneService;
    private final UtenteRepository utenteRepository;
    private final PostazioneRepository postazioneRepository;
    private final EdificioRepository edificioRepository;


    public PrenotazioneRunner(PrenotazioneService prenotazioneService, UtenteRepository utenteRepository, PostazioneRepository postazioneRepository, EdificioRepository edificioRepository) {
        this.prenotazioneService = prenotazioneService;
        this.utenteRepository = utenteRepository;
        this.postazioneRepository = postazioneRepository;
        this.edificioRepository = edificioRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Avvio test prenotazioni...");


        Utente utente1 = new Utente(null, "elijon123", "Elijon ", "Rossi", "elijon.rossi@email.com", new ArrayList<>());
        utenteRepository.save(utente1);

        Edificio edificio = new Edificio(null, "Epicode HQ", "Via Roma 123", "Roma", null);
        edificioRepository.save(edificio);

        Postazione postazione1 = new Postazione(null, "POST001", "Postazione privata con vista", TipoPostazione.PRIVATO, 2, edificio, null);
        postazioneRepository.save(postazione1);

        Utente utente2 = new Utente(null, "marco456", "Marco ", "Verdi", "marco.verdi@email.com", new ArrayList<>());
        utenteRepository.save(utente2);

        Postazione postazione2 = new Postazione(null, "POST002", "Open space collaborativo", TipoPostazione.OPENSPACE, 4, edificio, null);
        postazioneRepository.save(postazione2);


        LocalDate dataPrenotazione = LocalDate.of(2025, 4, 15);

        System.out.println(prenotazioneService.creaPrenotazione(utente1.getId(), postazione1.getId(), dataPrenotazione));
        System.out.println(prenotazioneService.creaPrenotazione(utente1.getId(), postazione2.getId(), dataPrenotazione));
        System.out.println(prenotazioneService.creaPrenotazione(utente2.getId(), postazione1.getId(), dataPrenotazione));
    }

}