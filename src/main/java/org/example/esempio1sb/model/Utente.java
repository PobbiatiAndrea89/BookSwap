package org.example.esempio1sb.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String citta;

    private String scuola;

    private BigDecimal rating;

    @Column(name = "data_registrazione", nullable = false, updatable = false)
    private Timestamp dataRegistrazione;

    // Costruttori, Getter e Setter

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getScuola() {
        return scuola;
    }

    public void setScuola(String scuola) {
        this.scuola = scuola;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Timestamp getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(Timestamp dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

}
