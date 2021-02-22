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

import ca.qc.grasset.ag420pb412B.tp03.diffuseur.DiffuseurFacture;
import ca.qc.grasset.ag420pb412B.tp03.domain.Facture;
import ca.qc.grasset.ag420pb412B.tp03.domain.InscriptionSemestre;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.process.MediateurAnnulationOffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.process.MediateurEnvoieFactureInscriptionSemestre;
import ca.qc.grasset.ag420pb412B.tp03.process.MediateurFermetureInscriptionSemestre;
import ca.qc.grasset.ag420pb412B.tp03.process.MediateurFermetureOffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.process.MediateurGenerationFactureOffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.repository.EtudiantRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.FactureRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.InscriptionSemestreRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.OffreDeCoursRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.StatutFactureRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.StatutOffreDeCoursRepository;

@RequestMapping("/ag420pb412B/tp03")
@RestController
public final class ControleurInscriptionSemestre {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private InscriptionSemestreRepository inscriptionSemestreRepository;

    @Autowired
    private OffreDeCoursRepository offreDeCoursRepository;

    @Autowired
    private StatutFactureRepository statutFactureRepository;

    @Autowired
    private StatutOffreDeCoursRepository statutOffreDeCoursRepository;

    public ControleurInscriptionSemestre() {

        super();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/semestre/inscription")
    InscriptionSemestre ajouter(
        @RequestBody final InscriptionSemestre inscriptionSemestre_) {

        return this.inscriptionSemestreRepository.save(inscriptionSemestre_);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/semestre/inscription/{id}")
    void effacer(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        InscriptionSemestre inscriptionSemestre =
            this.inscriptionSemestreRepository.findById(pkid_)
                .orElseThrow(
                    () -> new ResourceNotFoundException(
                        "InscriptionSemestre inexistant :: " + pkid_));

        this.inscriptionSemestreRepository.delete(inscriptionSemestre);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/semestre/inscription/transaction/fermeture")
    InscriptionSemestre fermer(
        @RequestBody final InscriptionSemestre inscriptionSemestre_)
        throws ResourceNotFoundException {

        MediateurFermetureInscriptionSemestre mediateurFermetureInscriptionSemestre =
            getMediateurFermetureInscriptionSemestre();

        return mediateurFermetureInscriptionSemestre.executer(inscriptionSemestre_);
    }

    @GetMapping("/semestre/inscription/{id}")
    InscriptionSemestre obtenir(
        @PathVariable("id") final Long pkid_)
        throws ResourceNotFoundException {

        return this.inscriptionSemestreRepository.findById(pkid_)
            .orElseThrow(
                () -> new ResourceNotFoundException("InscriptionSemestre inexistant :: " + pkid_));
    }

    @GetMapping("/semestre/inscriptions")
    List<InscriptionSemestre> obtenirListe() {

        return this.inscriptionSemestreRepository.findAll();
    }

    private DiffuseurFacture getDiffuseurFacture() {

        return new DiffuseurFacture() {

            @Override
            public Facture diffuser(
                final Facture facture_) {

                return null;
            }
        };
    }

    private MediateurFermetureInscriptionSemestre getMediateurFermetureInscriptionSemestre() {

        MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours =
            MediateurAnnulationOffreDeCours.builder()
                .offreDeCoursRepository(this.offreDeCoursRepository)
                .build();

        MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre =
            MediateurEnvoieFactureInscriptionSemestre.builder()
                .factureRepository(this.factureRepository)
                .diffuseurFacture(getDiffuseurFacture())
                .build();

        MediateurFermetureOffreDeCours mediateurFermetureOffreDeCours =
            getMediateurFermetureOffreDeCours();

        MediateurFermetureInscriptionSemestre mediateurFermetureInscriptionSemestre =
            MediateurFermetureInscriptionSemestre.builder()
                .mediateurAnnulationOffreDeCours(mediateurAnnulationOffreDeCours)
                .mediateurEnvoieFactureInscriptionSemestre(
                    mediateurEnvoieFactureInscriptionSemestre)
                .mediateurFermetureOffreDeCours(mediateurFermetureOffreDeCours)
                .build();

        return mediateurFermetureInscriptionSemestre;
    }

    private MediateurFermetureOffreDeCours getMediateurFermetureOffreDeCours() {

        MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours =
            MediateurGenerationFactureOffreDeCours.builder()
                .etudiantRepository(this.etudiantRepository)
                .factureRepository(this.factureRepository)
                .statutFactureRepository(this.statutFactureRepository)
                .build();

        MediateurFermetureOffreDeCours mediateurFermetureOffreDeCours =
            MediateurFermetureOffreDeCours.builder()
                .offreDeCoursRepository(this.offreDeCoursRepository)
                .statutOffreDeCoursRepository(this.statutOffreDeCoursRepository)
                .mediateurGenerationFactureOffreDeCours(mediateurGenerationFactureOffreDeCours)
                .build();
        return mediateurFermetureOffreDeCours;
    }
}
