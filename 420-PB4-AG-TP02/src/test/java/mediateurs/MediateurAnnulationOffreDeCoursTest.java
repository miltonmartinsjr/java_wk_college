package mediateurs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import cours.Cours;
import cours.MediateurAnnulationOffreDeCours;
import cours.OffreDeCours;
import cours.RegistreOffreDeCours;
import cours.Semestre;
import cours.StatusOffreDeCours;
import ecole.Departement;
import etudiant.Etudiant;
import professeur.Professeur;
import professeur.StatutProfesseur;

public class MediateurAnnulationOffreDeCoursTest {

    private final RegistreOffreDeCours registreOffreDeCours =
        Mockito.mock(RegistreOffreDeCours.class);

    public MediateurAnnulationOffreDeCoursTest() {

    }

    @Test
    public void test() {

        MediateurAnnulationOffreDeCours mediateurAnnulationOffreDeCours =
            new MediateurAnnulationOffreDeCours(this.registreOffreDeCours);

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

        Mockito.when(this.registreOffreDeCours.obtenir(offreDeCours))
            .thenReturn(offreDeCours);

        Mockito.when(this.registreOffreDeCours.modifier(offreDeCours))
            .thenReturn(offreDeCours);

        mediateurAnnulationOffreDeCours.executer(offreDeCours);
    }

}
