package ca.qc.grasset.ag420pb412B.tp03.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.qc.grasset.ag420pb412B.tp03.domain.Utilisateur;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.UtilisateurRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurUtilisateur {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public ControleurUtilisateur() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/utilisateur")
    Utilisateur ajouter(
        @RequestBody final Utilisateur utilisateur_) {

        return this.utilisateurRepository.save(utilisateur_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/utilisateur/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Utilisateur utilisateur =
            this.utilisateurRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Utilisateur inexistant :: " + pkid_));

        this.utilisateurRepository.delete(utilisateur);
    }

    @GetMapping("/utilisateur/{id}")
    Utilisateur obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.utilisateurRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur inexistant :: " + pkid_));
    }

    @GetMapping("/utilisateurs")
    List<Utilisateur> obtenirListe() {

        return this.utilisateurRepository.findAll();
    }
}
