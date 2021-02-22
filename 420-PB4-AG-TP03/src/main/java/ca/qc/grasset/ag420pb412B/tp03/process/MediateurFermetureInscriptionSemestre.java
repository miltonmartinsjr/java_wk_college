package ca.qc.grasset.ag420pb412B.tp03.process;

import ca.qc.grasset.ag420pb412B.tp03.domain.InscriptionSemestre;
import ca.qc.grasset.ag420pb412B.tp03.domain.OffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder(builderClassName = "Builder")
@AllArgsConstructor
public final class MediateurFermetureInscriptionSemestre {

    private MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours;

    private MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre;

    private MediateurFermetureOffreDeCours mediateurFermetureOffreDeCours;

    public MediateurFermetureInscriptionSemestre() {

        super();
    }

    public InscriptionSemestre executer(
        final InscriptionSemestre inscriptionSemestre_)
        throws ResourceNotFoundException {

        for (OffreDeCours offreDeCours : inscriptionSemestre_.getOffreDeCours()) {

            if (offreDeCours.getProfesseur() == null) {
                this.mediateurAnnulationOffreDeCours.executer(offreDeCours);
                continue;
            }

            if (!offreDeCours.hasNombreMiniumEtudiants()) {
                this.mediateurAnnulationOffreDeCours.executer(offreDeCours);
                continue;
            }

            this.mediateurFermetureOffreDeCours.executer(offreDeCours);
        }

        this.mediateurEnvoieFactureInscriptionSemestre.executer(inscriptionSemestre_);

        return inscriptionSemestre_;
    }
}
