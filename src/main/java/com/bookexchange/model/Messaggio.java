package com.bookexchange.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Messaggio")
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

    private String testo;
    private LocalDateTime timestamp = LocalDateTime.now();
}
