package org.example.esempio1sb.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
public class Libro {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull

    private String titolo;

    @NotNull

    private String autore;

    @NotNull
    private String materia;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatoLibro stato;

    @NotNull
    private BigDecimal prezzo;

    @Lob
    private String descrizione;

    private String immagine;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public enum StatoLibro {
        NUOVO, USATO, MOLTO_USATO
    }
    // Getters and Setters
}


