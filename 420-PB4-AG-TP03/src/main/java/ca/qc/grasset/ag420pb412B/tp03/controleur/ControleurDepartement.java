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

import ca.qc.grasset.ag420pb412B.tp03.domain.Departement;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.DepartementRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurDepartement {

    @Autowired
    private DepartementRepository departementRepository;

    public ControleurDepartement() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/departement")
    Departement ajouter(
        @RequestBody final Departement departement_) {

        return this.departementRepository.save(departement_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/departement/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Departement departement =
            this.departementRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Departement inexistant :: " + pkid_));

        this.departementRepository.delete(departement);
    }

    @GetMapping("/departement/{id}")
    Departement obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.departementRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Departement inexistant :: " + pkid_));
    }

    @GetMapping("/departements")
    List<Departement> obtenirListe() {

        return this.departementRepository.findAll();
    }
}
