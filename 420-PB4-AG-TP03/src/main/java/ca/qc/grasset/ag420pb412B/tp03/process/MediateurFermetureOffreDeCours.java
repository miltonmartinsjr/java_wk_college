package ca.qc.grasset.ag420pb412B.tp03.process;

import ca.qc.grasset.ag420pb412B.tp03.domain.OffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.domain.StatutOffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.OffreDeCoursRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.StatutOffreDeCoursRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public final class MediateurFermetureOffreDeCours {

    private MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours;

    private OffreDeCoursRepository offreDeCoursRepository;

    private StatutOffreDeCoursRepository statutOffreDeCoursRepository;

    public MediateurFermetureOffreDeCours() {

        super();
    }

    public void executer(
        final OffreDeCours offreDeCours_)
        throws ResourceNotFoundException {

        fermerOffreDeCours(offreDeCours_);

        this.mediateurGenerationFactureOffreDeCours.executer(offreDeCours_);
    }

    private void fermerOffreDeCours(
        final OffreDeCours offreDeCours_)
        throws ResourceNotFoundException {

        StatutOffreDeCours statutOffreDeCours = getStatutFermetureOffreDeCours();

        offreDeCours_.setStatutOffreDeCours(statutOffreDeCours);
        this.offreDeCoursRepository.save(offreDeCours_);
    }

    private StatutOffreDeCours getStatutFermetureOffreDeCours()
        throws ResourceNotFoundException {

        final long pkid = 99;
        return this.statutOffreDeCoursRepository.findById(pkid)
            .orElseThrow(
                () -> new ResourceNotFoundException(
                    "Statut fermeture offre de cours introuvable :: " + pkid));
    }

}
