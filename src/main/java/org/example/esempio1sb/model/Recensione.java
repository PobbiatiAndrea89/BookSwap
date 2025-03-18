package org.example.esempio1sb.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Recensione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recensore_id", nullable = false)
    private Utente recensore;

    @ManyToOne
    @JoinColumn(name = "recensito_id", nullable = false)
    private Utente recensito;

    private int voto; // Valori da 1 a 5

    @Lob
    private String commento;

    private Timestamp dataRecensione;

    // Costruttori, Getter e Setter
}
