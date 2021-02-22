package mediateurs;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.Professeur;
import professeur.StatutProfesseur;
import utilisateur.MediateurOuvertureSessionUtilisateur;
import utilisateur.RegistreSessionUtilisateur;
import utilisateur.RegistreUtilisateur;
import utilisateur.SessionUtilisateur;

public class MediateurOuvertureSessionProfesseurTest {

    private final RegistreSessionUtilisateur registreSessionUtilisateur =
        Mockito.mock(RegistreSessionUtilisateur.class);

    private final RegistreUtilisateur registreUtilisateur = Mockito.mock(RegistreUtilisateur.class);

    public MediateurOuvertureSessionProfesseurTest() {

    }

    @Test
    public void test() {

        MediateurOuvertureSessionUtilisateur mediateur =
            new MediateurOuvertureSessionUtilisateur(

                this.registreUtilisateur,
                this.registreSessionUtilisateur);

        Professeur professeur =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Professeur reponseObtenir =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(professeur);

        Mockito.when(this.registreUtilisateur.obtenir(professeur))
            .thenReturn(reponseObtenir);
        Mockito.when(this.registreSessionUtilisateur.creer(reponseObtenir))
            .thenReturn(sessionUtilisateur);
        SessionUtilisateur reponseSession = mediateur.executer(professeur);

        Assert.assertTrue(
            reponseSession.getUtilisateur()
                .getIdentificateur()
                .equalsIgnoreCase("ProfPablo"));
        Assert.assertNotNull(reponseSession);
    }

}
