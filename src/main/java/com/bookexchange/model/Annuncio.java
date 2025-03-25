package com.bookexchange.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Annuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "libro_id", nullable = false, unique = true)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @Column(name = "data_pubblicazione", nullable = false)
    private Timestamp dataPubblicazione;

    @Enumerated(EnumType.STRING)
    private StatoAnnuncio statoAnnuncio;

    // Costruttori, Getter e Setter

    public enum StatoAnnuncio {
        ATTIVO, CHIUSO, SCADUTO
    }
    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Timestamp getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(Timestamp dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public StatoAnnuncio getStatoAnnuncio() {
        return statoAnnuncio;
    }

    public void setStatoAnnuncio(StatoAnnuncio statoAnnuncio) {
        this.statoAnnuncio = statoAnnuncio;
    }
}
