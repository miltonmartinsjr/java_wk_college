package mediateurs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import cours.Cours;
import cours.InscriptionSemestre;
import cours.MediateurAnnulationOffreDeCours;
import cours.MediateurFermertureOffreDeCours;
import cours.OffreDeCours;
import cours.RegistreOffreDeCours;
import cours.Semestre;
import cours.StatusOffreDeCours;
import ecole.Departement;
import ecole.MediateurFermetureInscriptionSemestre;
import etudiant.Etudiant;
import etudiant.RegistreEtudiant;
import facture.DiffuserFacture;
import facture.Facture;
import facture.MediateurEnvoieFactureInscriptionSemestre;
import facture.MediateurGenerationFactureOffreDeCours;
import facture.RegistreFacture;
import facture.StatusFacture;
import professeur.Professeur;
import professeur.StatutProfesseur;

public class MediateurFermetureInscriptionSemestreTest {

    private final DiffuserFacture diffuserFacture = Mockito.mock(DiffuserFacture.class);

    private final RegistreEtudiant registreEtudiant = Mockito.mock(RegistreEtudiant.class);

    private final RegistreFacture registreFacture = Mockito.mock(RegistreFacture.class);

    private final RegistreOffreDeCours registreOffreDeCours =
        Mockito.mock(RegistreOffreDeCours.class);

    public MediateurFermetureInscriptionSemestreTest() {

    }

    @Test
    public void test() {

        MediateurGenerationFactureOffreDeCours mediateurGenerationFactureOffreDeCours =
            new MediateurGenerationFactureOffreDeCours(this.registreEtudiant, this.registreFacture);
        MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours =
            new MediateurAnnulationOffreDeCours(this.registreOffreDeCours);
        MediateurFermertureOffreDeCours mediateurFermertureOffreDeCours =
            new MediateurFermertureOffreDeCours(
                mediateurAnnulationOffreDeCours,
                mediateurGenerationFactureOffreDeCours,
                this.registreOffreDeCours);
        MediateurEnvoieFactureInscriptionSemestre mediateurEnvoieFactureInscriptionSemestre =
            new MediateurEnvoieFactureInscriptionSemestre(
                this.diffuserFacture,
                this.registreFacture);
        MediateurFermetureInscriptionSemestre mediateurFermetureInscriptionSemestre =
            new MediateurFermetureInscriptionSemestre(
                mediateurEnvoieFactureInscriptionSemestre,
                mediateurFermertureOffreDeCours,
                this.registreOffreDeCours);
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
        OffreDeCours offreDeCours =
            new OffreDeCours(cours, etudiant3, etudiants, profTest, semestre, statusOffreDeCours);
        List<OffreDeCours> listOffreDeCours = new ArrayList<>();
        listOffreDeCours.add(offreDeCours);
        InscriptionSemestre inscriptionSemestre =
            new InscriptionSemestre(listOffreDeCours, semestre);
        StatusFacture statusFacture = new StatusFacture(true);
        Facture facture = new Facture(etudiant, inscriptionSemestre, statusFacture);
        Mockito.when(this.registreEtudiant.obtenir(etudiant))
            .thenReturn(etudiant);
        Mockito.when(this.registreOffreDeCours.obtenir(offreDeCours))
            .thenReturn(offreDeCours);
        Mockito.when(this.registreOffreDeCours.modifier(offreDeCours))
            .thenReturn(offreDeCours);
        Mockito.when(this.diffuserFacture.diffuser(ArgumentMatchers.any(Facture.class)))
            .thenReturn(facture);
        Mockito.when(this.registreFacture.creer(facture))
            .thenReturn(facture);
        Mockito.when(this.registreFacture.obtenir(ArgumentMatchers.any(Facture.class)))
            .thenReturn(facture);
        mediateurFermetureInscriptionSemestre.executer(inscriptionSemestre);
    }

}
