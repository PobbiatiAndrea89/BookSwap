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
@RequestMapping("/")
public class MainController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private LibroService libroService;

    @Autowired
    private AnnuncioService annuncioService;

    // Home Page
    @GetMapping("/")
    public String homePage() {
        return "index"; // Restituisce il template index.html
    }

    // Pagina di registrazione
    @GetMapping("/registrazione")
    public String registrationPage() {
        return "registrazione"; // Restituisce il template registrazione.html
    }

    @PostMapping("/registrazione")
    public String registerUser(@RequestParam String nome,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam(required = false) String citta,
                               @RequestParam(required = false) String scuola,
                               RedirectAttributes redirectAttributes) {
        Optional<Utente> existingUtente = utenteService.findByEmail(email);
        if (existingUtente.isPresent()) {
            redirectAttributes.addFlashAttribute("error", "Email già in uso");
            return "redirect:/registrazione";
        }

        Utente nuovoUtente = new Utente();
        nuovoUtente.setNome(nome);
        nuovoUtente.setEmail(email);
        nuovoUtente.setPassword(password); // La password viene salvata in chiaro
        nuovoUtente.setCitta(citta);
        nuovoUtente.setScuola(scuola);
        nuovoUtente.setDataRegistrazione(new Timestamp(System.currentTimeMillis()));
        utenteService.saveUtente(nuovoUtente);

        redirectAttributes.addFlashAttribute("message", "Registrazione completata con successo!");
        return "redirect:/"; // Reindirizza alla home page
    }


    // Pagina di login
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Restituisce il template login.html
    }

    // Gestione del login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {
        Optional<Utente> utenteOpt = utenteService.findByEmail(email);
        if (utenteOpt.isEmpty() || !utenteOpt.get().getPassword().equals(password)) { // Considera di usare il confronto con password hashata
            model.addAttribute("error", "Email o password errati");
            return "login";
        }

        // Imposta la sessione utente o il token qui
        model.addAttribute("message", "Login avvenuto con successo");
        return "area_riservata"; // Reindirizza alla home page o alla dashboard utente
    }

    @RequestMapping("/area_riservata")
    public String areaRiservata(Model model) {
        return "area_riservata";
    }

    // Lista dei libri (mostrata nella home page)
    @GetMapping("/libri")
    public String viewLibri(Model model) {
        List<Libro> libri = libroService.getAllLibri();
        model.addAttribute("libri", libri); // Passa la lista dei libri al template
        return "index"; // Mostra la home con i libri elencati
    }

    // Ricerca dei libri
    @GetMapping("/libri/search")
    public String searchLibri(@RequestParam String titolo, Model model) {
        List<Libro> risultati = libroService.findByTitolo(titolo);
        model.addAttribute("libri", risultati);
        return "index"; // Mostra i risultati sulla home
    }

    // Aggiungi un nuovo libro
    @PostMapping("/libri")
    public String addLibro(@RequestParam String titolo,
                           @RequestParam String autore,
                           @RequestParam String materia,
                           @RequestParam String stato,
                           @RequestParam Double prezzo,
                           @RequestParam String descrizione,
                           Model model) {
        Libro nuovoLibro = new Libro();
        nuovoLibro.setTitolo(titolo);
        nuovoLibro.setAutore(autore);
        nuovoLibro.setMateria(materia);
        nuovoLibro.setStato(Libro.StatoLibro.valueOf(stato));
        nuovoLibro.setPrezzo(BigDecimal.valueOf(prezzo));
        nuovoLibro.setDescrizione(descrizione);
        libroService.saveLibro(nuovoLibro);
        model.addAttribute("message", "Libro aggiunto con successo!");
        return "index"; // Reindirizza alla home
    }

    // Dettaglio di un libro
    @GetMapping("/libri/{id}")
    public String getLibroById(@PathVariable Long id, Model model) {
        Libro libro = libroService.findById(id);
        model.addAttribute("libro", libro);
        return "dettaglio-libro"; // Restituisce un template con i dettagli del libro
    }

    // Aggiungi Annuncio
    @PostMapping("/annunci")
    public String addAnnuncio(@RequestParam Long libroId,
                              @RequestParam String statoAnnuncio,
                              Model model) {
        Annuncio nuovoAnnuncio = new Annuncio();
        Libro libro = libroService.findById(libroId);
        nuovoAnnuncio.setLibro(libro);
        nuovoAnnuncio.setStatoAnnuncio(Annuncio.StatoAnnuncio.valueOf(statoAnnuncio));
        annuncioService.saveAnnuncio(nuovoAnnuncio);
        model.addAttribute("message", "Annuncio creato con successo!");
        return "redirect:/annunci"; // Reindirizza alla pagina annunci
    }

    // Visualizza Annunci
    @GetMapping("/annunci")
    public String viewAnnunci(Model model) {
        List<Annuncio> annunci = annuncioService.getAllAnnunci();
        model.addAttribute("annunci", annunci);
        return "annunci"; // Visualizza il template annunci.html
    }

    @GetMapping("/catalogo")
    public String catalogoPage(
            @RequestParam(required = false) String titolo,
            @RequestParam(required = false) String materia,
            @RequestParam(required = false) Libro.StatoLibro stato,
            @RequestParam(required = false) BigDecimal prezzoMax,
            Model model) {

        List<Libro> libri;

        if (titolo != null || materia != null || stato != null || prezzoMax != null) {
            libri = libroService.filtraLibri(titolo, materia, stato, prezzoMax);
        } else {
            libri = libroService.getAllLibri();
        }

        model.addAttribute("libri", libri);
        return "catalogo";
    }

    @RequestMapping("annunci")
    public String annunci(){
        return "annunci";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}