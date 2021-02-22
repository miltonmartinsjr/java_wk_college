package facture;

import java.util.ArrayList;
import java.util.List;

import cours.InscriptionSemestre;
import cours.OffreDeCours;
import cours.Semestre;
import etudiant.Etudiant;
import etudiant.RegistreEtudiant;

public class MediateurGenerationFactureOffreDeCours {

    private final RegistreEtudiant registreEtudiant;

    private final RegistreFacture registreFacture;

    public MediateurGenerationFactureOffreDeCours(
        final RegistreEtudiant registreEtudiant_,
        final RegistreFacture registreFacture_) {

        super();
        this.registreEtudiant = registreEtudiant_;
        this.registreFacture = registreFacture_;
    }

    public final void executer(
        final OffreDeCours offreDeCours_) {

        for (Etudiant registre : offreDeCours_.getListEtudiant()) {
            Etudiant reponse = this.registreEtudiant.obtenir(registre);
            Semestre semestre = new Semestre();
            List<OffreDeCours> listOffreDeCours1 = new ArrayList<>();
            listOffreDeCours1.add(offreDeCours_);
            StatusFacture statusFacture = new StatusFacture(false);
            InscriptionSemestre inscriptionSem =
                new InscriptionSemestre(listOffreDeCours1, semestre);
            Facture gerationFacture = new Facture(reponse, inscriptionSem, statusFacture);

            gerationFacture = this.registreFacture.creer(gerationFacture);
        }
    }

}
