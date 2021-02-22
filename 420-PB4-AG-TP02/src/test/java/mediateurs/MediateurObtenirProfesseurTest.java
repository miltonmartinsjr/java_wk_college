package mediateurs;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.ExceptionProfesseurIntrouvable;
import professeur.MediateurObtenirProfesseur;
import professeur.Professeur;
import professeur.RegistreProfesseur;
import professeur.StatutProfesseur;

public class MediateurObtenirProfesseurTest {

    private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurObtenirProfesseurTest() {

        super();
    }

    @Test
    public void test()
        throws ExceptionProfesseurIntrouvable {

        MediateurObtenirProfesseur obtenirProfesseur =
            new MediateurObtenirProfesseur(this.registreProfesseur);

        Professeur professeurTest =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Professeur professeurAttendu =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Mockito.when(this.registreProfesseur.obtenir(professeurTest))
            .thenReturn(professeurAttendu);

        Professeur professeurObtennu = obtenirProfesseur.executer(professeurTest);

        Assert.assertTrue(
            professeurObtennu.getIdentificateur()
                .equalsIgnoreCase(professeurAttendu.getIdentificateur()));
    }

}
