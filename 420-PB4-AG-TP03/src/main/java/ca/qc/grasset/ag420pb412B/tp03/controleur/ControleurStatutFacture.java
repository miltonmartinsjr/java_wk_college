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

import ca.qc.grasset.ag420pb412B.tp03.domain.StatutFacture;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.StatutFactureRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurStatutFacture {

    @Autowired
    private StatutFactureRepository statutFactureRepository;

    public ControleurStatutFacture() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/facture/statut")
    StatutFacture ajouter(
        @RequestBody final StatutFacture statutFacture_) {

        return this.statutFactureRepository.save(statutFacture_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/facture/statut/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        StatutFacture statutFacture =
            this.statutFactureRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException("StatutFacture inexistant :: " + pkid_));

        this.statutFactureRepository.delete(statutFacture);
    }

    @GetMapping("/facture/statut/{id}")
    StatutFacture obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.statutFactureRepository.findById(pkid_)
            .orElseThrow(
                () -> new ResourceNotFoundException("StatutFacture inexistant :: " + pkid_));
    }

    @GetMapping("/facture/statuts")
    List<StatutFacture> obtenirListe() {

        return this.statutFactureRepository.findAll();
    }
}
