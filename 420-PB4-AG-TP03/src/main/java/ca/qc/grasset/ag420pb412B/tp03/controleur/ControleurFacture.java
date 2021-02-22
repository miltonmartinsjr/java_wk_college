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

import ca.qc.grasset.ag420pb412B.tp03.domain.Facture;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.FactureRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurFacture {

    @Autowired
    private FactureRepository factureRepository;

    public ControleurFacture() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/facture")
    Facture ajouter(
        @RequestBody final Facture facture_) {

        return this.factureRepository.save(facture_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/facture/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        Facture facture =
            this.factureRepository.findById(pkid_)
                .orElseThrow(() -> new ResourceNotFoundException("Facture inexistant :: " + pkid_));

        this.factureRepository.delete(facture);
    }

    @GetMapping("/facture/{id}")
    Facture obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.factureRepository.findById(pkid_)
            .orElseThrow(() -> new ResourceNotFoundException("Facture inexistant :: " + pkid_));
    }

    @GetMapping("/factures")
    List<Facture> obtenirListe() {

        return this.factureRepository.findAll();
    }
}
