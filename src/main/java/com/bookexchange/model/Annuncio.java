package com.bookexchange.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Annuncio")
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

    private LocalDateTime dataPubblicazione = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatoAnnuncio statoAnnuncio = StatoAnnuncio.ATTIVO;
}

enum StatoAnnuncio {
    ATTIVO, CHIUSO, SCADUTO;
}
