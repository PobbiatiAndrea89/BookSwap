package com.bookexchange.model;

import jakarta.persistence.*;

@Entity
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    private String materiaPreferita;

    private String titoloPreferito;

    // Costruttori, Getter e Setter
}
