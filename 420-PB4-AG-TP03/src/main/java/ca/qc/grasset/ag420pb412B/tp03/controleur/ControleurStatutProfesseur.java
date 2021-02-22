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

import ca.qc.grasset.ag420pb412B.tp03.domain.StatutProfesseur;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.StatutProfesseurRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurStatutProfesseur {

    @Autowired
    private StatutProfesseurRepository statutProfesseurRepository;

    public ControleurStatutProfesseur() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/professeur/statut")
    StatutProfesseur ajouter(
        @RequestBody final StatutProfesseur statutProfesseur_) {

        return this.statutProfesseurRepository.save(statutProfesseur_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/professeur/statut/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        StatutProfesseur statutProfesseur =
            this.statutProfesseurRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("StatutProfesseur inexistant :: " + pkid_));

        this.statutProfesseurRepository.delete(statutProfesseur);
    }

    @GetMapping("/professeur/statut/{id}")
    StatutProfesseur obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.statutProfesseurRepository.findById(pkid_)
            .orElseThrow(
                () -> new ResourceNotFoundException("StatutProfesseur inexistant :: " + pkid_));
    }

    @GetMapping("/professeur/statuts")
    List<StatutProfesseur> obtenirListe() {

        return this.statutProfesseurRepository.findAll();
    }
}
