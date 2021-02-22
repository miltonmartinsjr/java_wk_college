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

import ca.qc.grasset.ag420pb412B.tp03.domain.Professeur;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.ProfesseurRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurProfesseur {

    @Autowired
    private ProfesseurRepository professeurRepository;

    public ControleurProfesseur() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/professeur")
    Professeur ajouter(
        @RequestBody final Professeur professeur_) {

        return this.professeurRepository.save(professeur_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/professeur/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Professeur professeur =
            this.professeurRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Professeur inexistant :: " + pkid_));

        this.professeurRepository.delete(professeur);
    }

    @GetMapping("/professeur/{id}")
    Professeur obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.professeurRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Professeur inexistant :: " + pkid_));
    }

    @GetMapping("/professeurs")
    List<Professeur> obtenirListe() {

        return this.professeurRepository.findAll();
    }
}
