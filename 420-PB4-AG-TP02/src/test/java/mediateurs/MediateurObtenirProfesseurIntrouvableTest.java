package mediateurs;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.ExceptionProfesseurIntrouvable;
import professeur.MediateurObtenirProfesseur;
import professeur.Professeur;
import professeur.RegistreProfesseur;
import professeur.StatutProfesseur;

public class MediateurObtenirProfesseurIntrouvableTest {

    private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurObtenirProfesseurIntrouvableTest() {

    }

    @Test(expected = ExceptionProfesseurIntrouvable.class)
    public void test()
        throws ExceptionProfesseurIntrouvable {

        MediateurObtenirProfesseur obtProfesseur =
            new MediateurObtenirProfesseur(this.registreProfesseur);

        Professeur profTest =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Professeur profAttendu =
            new Professeur("", "", "", new Date(), "", new Departement(), new StatutProfesseur());

        Mockito.when(this.registreProfesseur.obtenir(profTest))
            .thenReturn(profAttendu);

        Professeur profObtennu = obtProfesseur.executer(profTest);

    }

}
