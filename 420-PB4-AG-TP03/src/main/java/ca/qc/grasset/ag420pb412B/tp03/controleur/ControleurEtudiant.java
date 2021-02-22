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

import ca.qc.grasset.ag420pb412B.tp03.domain.Etudiant;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.EtudiantRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurEtudiant {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public ControleurEtudiant() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/etudiant")
    Etudiant ajouter(
        @RequestBody final Etudiant etudiant_) {

        return this.etudiantRepository.save(etudiant_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/etudiant/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Etudiant etudiant =
            this.etudiantRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Etudiant inexistant :: " + pkid_));

        this.etudiantRepository.delete(etudiant);
    }

    @GetMapping("/etudiant/{id}")
    Etudiant obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.etudiantRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Etudiant inexistant :: " + pkid_));
    }

    @GetMapping("/etudiants")
    List<Etudiant> obtenirListe() {

        return this.etudiantRepository.findAll();
    }
}
