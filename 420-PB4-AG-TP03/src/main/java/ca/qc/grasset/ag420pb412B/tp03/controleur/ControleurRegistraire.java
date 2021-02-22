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

import ca.qc.grasset.ag420pb412B.tp03.domain.Registraire;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.RegistraireRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurRegistraire {

    @Autowired
    private RegistraireRepository registraireRepository;

    public ControleurRegistraire() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registraire")
    Registraire ajouter(
        @RequestBody final Registraire registraire_) {

        return this.registraireRepository.save(registraire_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/registraire/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Registraire registraire =
            this.registraireRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Registraire inexistant :: " + pkid_));

        this.registraireRepository.delete(registraire);
    }

    @GetMapping("/registraire/{id}")
    Registraire obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.registraireRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Registraire inexistant :: " + pkid_));
    }

    @GetMapping("/registraires")
    List<Registraire> obtenirListe() {

        return this.registraireRepository.findAll();
    }
}
