package mediateurs;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.ExceptionProfesseurIntrouvable;
import professeur.MediateurModificationProfesseur;
import professeur.Professeur;
import professeur.RegistreProfesseur;
import professeur.StatutProfesseur;

public class MediateurModificationProfesseurTest {

    private final RegistreProfesseur resgistreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurModificationProfesseurTest() {

    }

    @Test
    public void test()
        throws ExceptionProfesseurIntrouvable {

        MediateurModificationProfesseur mediateur =
            new MediateurModificationProfesseur(this.resgistreProfesseur);
        Professeur professeur =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Professeur modifierProfesseur =
            new Professeur(
                "ProfFefito",
                "Fefito",
                "Silva",
                new Date(),
                "303132",
                new Departement(),
                new StatutProfesseur());

        Mockito.when(this.resgistreProfesseur.obtenir(professeur))
            .thenReturn(modifierProfesseur);

        Mockito.when(this.resgistreProfesseur.modifier(professeur))
            .thenReturn(modifierProfesseur);
        Professeur reponseProfesseur = mediateur.executer(professeur);

        Assert.assertTrue(
            reponseProfesseur.getNumeroAssuranceSocial()
                .equalsIgnoreCase(modifierProfesseur.getNumeroAssuranceSocial()));
    }

}
