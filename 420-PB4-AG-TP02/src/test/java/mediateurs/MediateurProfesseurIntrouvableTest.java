package mediateurs;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.MediateurCreationProfesseur;
import professeur.Professeur;
import professeur.RegistreProfesseur;
import professeur.StatutProfesseur;

public class MediateurProfesseurIntrouvableTest {

    private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurProfesseurIntrouvableTest() {

        super();
    }

    @Test
    public void test() {

        MediateurCreationProfesseur creerProfesseur =
            new MediateurCreationProfesseur(this.registreProfesseur);

        Professeur profTest =
            new Professeur(
                "",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Professeur profAttendu =
            new Professeur("", "", "", new Date(), "", new Departement(), new StatutProfesseur());

        Mockito.when(this.registreProfesseur.creer(profTest))
            .thenReturn(profAttendu);

        Professeur profObtennu = creerProfesseur.executer(profTest);

        Assert.assertTrue(
            profObtennu.getIdentificateur()
                .equalsIgnoreCase(profAttendu.getIdentificateur()));

    }

}
