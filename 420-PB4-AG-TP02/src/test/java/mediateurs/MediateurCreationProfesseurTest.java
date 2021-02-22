package mediateurs;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.MediateurCreationProfesseur;
import professeur.Professeur;
import professeur.RegistreProfesseur;
import professeur.StatutProfesseur;

public class MediateurCreationProfesseurTest {

    private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurCreationProfesseurTest() {

    }

    @Test
    public void test() {

        MediateurCreationProfesseur mediateur =
            new MediateurCreationProfesseur(this.registreProfesseur);

        Professeur professeur =
            new Professeur(
                "",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        professeur.toString();

        Professeur reponseProfesseur =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Mockito.when(this.registreProfesseur.creer(professeur))
            .thenReturn(reponseProfesseur);
        Professeur responseMock = mediateur.executer(professeur);

        // Assert.assertTrue(
        // responseMock.getIdentificateur()
        // .length() > 0);

    }
}
