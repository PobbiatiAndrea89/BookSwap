package com.bookexchange.controller;
import com.bookexchange.model.Annuncio;
import com.bookexchange.model.Libro;
import com.bookexchange.model.Utente;
import com.bookexchange.service.AnnuncioService;
import com.bookexchange.service.LibroService;
import com.bookexchange.service.UtenteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/annunci")
public class AnnuncioController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AnnuncioService annuncioService;

    // Visualizza il form per creare un annuncio
    @GetMapping("/crea")
    public String creaAnnuncioPage() {
        return "crea_annuncio";  // Restituisce il template crea_annuncio.html
    }

    // Gestione della creazione dell'annuncio
    @PostMapping
    public String creaAnnuncio(@RequestParam String titolo,
                               @RequestParam String autore,
                               @RequestParam String materia,
                               @RequestParam BigDecimal prezzo,
                               @RequestParam String stato,
                               Model model) {
        // Crea il nuovo libro
        Libro nuovoLibro = new Libro();
        nuovoLibro.setTitolo(titolo);
        nuovoLibro.setAutore(autore);
        nuovoLibro.setMateria(materia);
        nuovoLibro.setPrezzo(prezzo);
        nuovoLibro.setStato(Libro.StatoLibro.valueOf(stato));
        libroService.saveLibro(nuovoLibro);

        // Crea l'annuncio per il libro
        Annuncio nuovoAnnuncio = new Annuncio();
        nuovoAnnuncio.setLibro(nuovoLibro);
        nuovoAnnuncio.setStatoAnnuncio(Annuncio.StatoAnnuncio.ATTIVO);
        annuncioService.saveAnnuncio(nuovoAnnuncio);

        // Aggiungi il messaggio di successo
        model.addAttribute("message", "Annuncio creato con successo!");

        return "redirect:/annunci"; // Reindirizza alla pagina degli annunci
    }
}
