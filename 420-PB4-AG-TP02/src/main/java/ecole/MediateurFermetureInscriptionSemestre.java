package ecole;

import cours.InscriptionSemestre;
import cours.MediateurFermertureOffreDeCours;
import cours.OffreDeCours;
import cours.RegistreOffreDeCours;
import facture.MediateurEnvoieFactureInscriptionSemestre;

public class MediateurFermetureInscriptionSemestre {

    private final MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre;

    private final MediateurFermertureOffreDeCours mediateurFermertureOffreDeCours;

    private final RegistreOffreDeCours registreOffreDeCours;

    public MediateurFermetureInscriptionSemestre(
        final MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre_,
        final MediateurFermertureOffreDeCours mediateurFermertureOffreDeCours_,
        final RegistreOffreDeCours registreOffreDeCours_) {

        super();
        this.mediateurEnvoieFactureInscriptionSemestre = mediateurEnvoieFactureInscriptionSemestre_;
        this.mediateurFermertureOffreDeCours = mediateurFermertureOffreDeCours_;
        this.registreOffreDeCours = registreOffreDeCours_;
    }

    public final void executer(
        final InscriptionSemestre inscriptionSemestre_) {

        for (OffreDeCours listOffreDeCours : inscriptionSemestre_.getListoffreDeCours()) {
            OffreDeCours reponse = this.registreOffreDeCours.obtenir(listOffreDeCours);

            this.mediateurFermertureOffreDeCours.executer(reponse);

        }
        this.mediateurEnvoieFactureInscriptionSemestre.executer(inscriptionSemestre_);
    }
}
