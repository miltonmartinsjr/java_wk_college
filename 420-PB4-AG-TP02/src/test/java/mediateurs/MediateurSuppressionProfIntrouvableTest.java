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

public class MediateurSuppressionProfIntrouvableTest {

    private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurSuppressionProfIntrouvableTest() {

    }

    @Test(expected = ExceptionProfesseurIntrouvable.class)
    public void test()
        throws ExceptionProfesseurIntrouvable {

        MediateurSupressionProfesseur profSupression =
            new MediateurSupressionProfesseur(this.registreProfesseur);

        Professeur proftest =
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

        Mockito.when(this.registreProfesseur.obtenir(proftest))
            .thenReturn(profAttendu);

        profSupression.executer(proftest);

    }

}
