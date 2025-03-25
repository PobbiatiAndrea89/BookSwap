package com.bookexchange.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Messaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mittente_id", nullable = false)
    private Utente mittente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id", nullable = false)
    private Utente destinatario;

    @Lob
    private String testo;

    @Column(nullable = false)
    private Timestamp timestamp;

    // Costruttori, Getter e Setter
}