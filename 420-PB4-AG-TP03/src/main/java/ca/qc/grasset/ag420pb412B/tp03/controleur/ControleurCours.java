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

import ca.qc.grasset.ag420pb412B.tp03.domain.Cours;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.CoursRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurCours {

    @Autowired
    private CoursRepository coursRepository;

    public ControleurCours() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cours")
    Cours ajouter(
        @RequestBody final Cours cours_) {

        return this.coursRepository.save(cours_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/cours/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Cours cours =
            this.coursRepository.findById(pkid_)
                .orElseThrow(() -> new ResourceNotFoundException("Cours inexistant :: " + pkid_));

        this.coursRepository.delete(cours);
    }

    @GetMapping("/cours/{id}")
    Cours obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.coursRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Cours inexistant :: " + pkid_));
    }

    @GetMapping("/cours")
    List<Cours> obtenirListe() {

        return this.coursRepository.findAll();
    }
}
