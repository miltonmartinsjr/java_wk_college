package mediateurs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import cours.Cours;
import cours.InscriptionSemestre;
import cours.OffreDeCours;
import cours.Semestre;
import cours.StatusOffreDeCours;
import ecole.Departement;
import etudiant.Etudiant;
import etudiant.RegistreEtudiant;
import facture.Facture;
import facture.MediateurGenerationFactureOffreDeCours;
import facture.RegistreFacture;
import facture.StatusFacture;
import professeur.Professeur;
import professeur.StatutProfesseur;

public class MediateurGenerationFactureOffreDeCoursTest {

    private final RegistreEtudiant registreEtudiant = Mockito.mock(RegistreEtudiant.class);

    private final RegistreFacture registreFacture = Mockito.mock(RegistreFacture.class);

    public MediateurGenerationFactureOffreDeCoursTest() {

    }

    @Test
    public void test() {

        MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours =
            new MediateurGenerationFactureOffreDeCours(this.registreEtudiant, this.registreFacture);

        Semestre semestre = new Semestre();
        Cours cours = new Cours();
        Etudiant etudiant = new Etudiant("Marc");
        Etudiant etudiant2 = new Etudiant("Jhon");
        Etudiant etudiant3 = new Etudiant("Luca");
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(etudiant);
        etudiants.add(etudiant2);
        etudiants.add(etudiant3);

        StatusOffreDeCours statusOffreDeCours = new StatusOffreDeCours();

        Professeur profTest =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        StatusFacture statusFacture = new StatusFacture(true);

        OffreDeCours offreDeCours =
            new OffreDeCours(cours, etudiant3, etudiants, profTest, semestre, statusOffreDeCours);

        List<OffreDeCours> listOffreDeCours = new ArrayList<>();
        listOffreDeCours.add(offreDeCours);

        InscriptionSemestre inscriptionSemestre =
            new InscriptionSemestre(listOffreDeCours, semestre);

        Facture facture = new Facture(etudiant, inscriptionSemestre, statusFacture);

        Mockito.when(this.registreEtudiant.obtenir(etudiant))
            .thenReturn(etudiant);

        Mockito.when(this.registreFacture.creer(facture))
            .thenReturn(facture);

        mediateurGenerationFactureOffreDeCours.executer(offreDeCours);
    }

}
