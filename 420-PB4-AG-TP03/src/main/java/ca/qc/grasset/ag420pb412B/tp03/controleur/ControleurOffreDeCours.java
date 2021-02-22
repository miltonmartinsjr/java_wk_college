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

import ca.qc.grasset.ag420pb412B.tp03.domain.OffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.OffreDeCoursRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurOffreDeCours {

    @Autowired
    private OffreDeCoursRepository offreDeCoursRepository;

    public ControleurOffreDeCours() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cours/offre")
    OffreDeCours ajouter(
        @RequestBody final OffreDeCours offreDeCours_) {

        return this.offreDeCoursRepository.save(offreDeCours_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/cours/offre/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        OffreDeCours offreDeCours =
            this.offreDeCoursRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("OffreDeCours inexistant :: " + pkid_));

        this.offreDeCoursRepository.delete(offreDeCours);
    }

    @GetMapping("/cours/offre/{id}")
    OffreDeCours obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.offreDeCoursRepository.findById(pkid_)
            .orElseThrow(
                () -> new ResourceNotFoundException("OffreDeCours inexistant :: " + pkid_));
    }

    @GetMapping("/cours/offres")
    List<OffreDeCours> obtenirListe() {

        return this.offreDeCoursRepository.findAll();
    }
}
