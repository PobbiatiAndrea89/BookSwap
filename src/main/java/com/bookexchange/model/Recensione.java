package com.bookexchange.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Recensione")
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

    private int voto;
    private String commento;
    private LocalDateTime dataRecensione = LocalDateTime.now();
}
