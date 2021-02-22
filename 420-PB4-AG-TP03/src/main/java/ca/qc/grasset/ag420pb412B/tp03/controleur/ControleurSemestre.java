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

import ca.qc.grasset.ag420pb412B.tp03.domain.Semestre;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.SemestreRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurSemestre {

    @Autowired
    private SemestreRepository semestreRepository;

    public ControleurSemestre() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/semestre")
    Semestre ajouter(
        @RequestBody final Semestre semestre_) {

        return this.semestreRepository.save(semestre_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/semestre/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Semestre semestre =
            this.semestreRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Semestre inexistant :: " + pkid_));

        this.semestreRepository.delete(semestre);
    }

    @GetMapping("/semestre/{id}")
    Semestre obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.semestreRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Semestre inexistant :: " + pkid_));
    }

    @GetMapping("/semestres")
    List<Semestre> obtenirListe() {

        return this.semestreRepository.findAll();
    }
}
