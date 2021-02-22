package mediateurs;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.ExceptionProfesseurIntrouvable;
import professeur.MediateurSupressionProfesseur;
import professeur.Professeur;
import professeur.RegistreProfesseur;
import professeur.StatutProfesseur;

public class MediateurSupressionProfesseurTest {

    private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurSupressionProfesseurTest() {

    }

    @Test
    public void test()
        throws ExceptionProfesseurIntrouvable {

        MediateurSupressionProfesseur suppression =
            new MediateurSupressionProfesseur(this.registreProfesseur);

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
                " ",
                " ",
                " ",
                new Date(),
                " ",
                new Departement(),
                new StatutProfesseur());

        Mockito.when(this.registreProfesseur.obtenir(professeurTest))
            .thenReturn(professeurAttendu);

        suppression.executer(professeurTest);

        Mockito.verify(this.registreProfesseur)
            .suprimer(professeurAttendu);

    }
}
