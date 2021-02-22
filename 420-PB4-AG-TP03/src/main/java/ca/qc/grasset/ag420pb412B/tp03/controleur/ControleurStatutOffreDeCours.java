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

import ca.qc.grasset.ag420pb412B.tp03.domain.StatutOffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.StatutOffreDeCoursRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurStatutOffreDeCours {

    @Autowired
    private StatutOffreDeCoursRepository statutOffreDeCoursRepository;

    public ControleurStatutOffreDeCours() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cours/offre/statut")
    StatutOffreDeCours ajouter(
        @RequestBody final StatutOffreDeCours statutOffreDeCours_) {

        return this.statutOffreDeCoursRepository.save(statutOffreDeCours_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/cours/offre/statut/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        StatutOffreDeCours statutOffreDeCours =
            this.statutOffreDeCoursRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException(
                        "StatutOffreDeCours inexistant :: " + pkid_));

        this.statutOffreDeCoursRepository.delete(statutOffreDeCours);
    }

    @GetMapping("/cours/offre/statut/{id}")
    StatutOffreDeCours obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.statutOffreDeCoursRepository.findById(pkid_)
            .orElseThrow(
                () -> new ResourceNotFoundException("StatutOffreDeCours inexistant :: " + pkid_));
    }

    @GetMapping("/cours/offre/statuts")
    List<StatutOffreDeCours> obtenirListe() {

        return this.statutOffreDeCoursRepository.findAll();
    }
}
