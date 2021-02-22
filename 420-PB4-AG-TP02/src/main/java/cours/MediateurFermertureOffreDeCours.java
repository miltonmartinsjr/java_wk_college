package cours;

import facture.MediateurGenerationFactureOffreDeCours;

public class MediateurFermertureOffreDeCours {

    private final MediateurGenerationFactureOffreDeCours generationFactureOffreDeCours;

    private final MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours;

    private final RegistreOffreDeCours registreOffreDeCours;

    public MediateurFermertureOffreDeCours(
        final MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours_,
        final MediateurGenerationFactureOffreDeCours generationFactureOffreDeCours_,
        final RegistreOffreDeCours registreOffreDeCours_) {

        super();
        this.mediateurAnnulationOffreDeCours = mediateurAnnulationOffreDeCours_;
        this.generationFactureOffreDeCours = generationFactureOffreDeCours_;
        this.registreOffreDeCours = registreOffreDeCours_;
    }

    public final void executer(
        final OffreDeCours offreDeCours_) {

        OffreDeCours registre = this.registreOffreDeCours.obtenir(offreDeCours_);

        if (!registre.estValide()) {
            this.mediateurAnnulationOffreDeCours.executer(offreDeCours_);
        } else {
            this.generationFactureOffreDeCours.executer(offreDeCours_);
        }
    }

}
