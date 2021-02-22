package mediateurs;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import etudiant.Etudiant;
import utilisateur.MediateurOuvertureSessionUtilisateur;
import utilisateur.RegistreSessionUtilisateur;
import utilisateur.RegistreUtilisateur;
import utilisateur.SessionUtilisateur;

public class MediateurOuvertureSessionEtudiantTest {

    private final RegistreSessionUtilisateur registreSessionUtilisateur =
        Mockito.mock(RegistreSessionUtilisateur.class);

    private final RegistreUtilisateur registreUtilisateur = Mockito.mock(RegistreUtilisateur.class);

    public MediateurOuvertureSessionEtudiantTest() {

    }

    @Test
    public void test() {

        MediateurOuvertureSessionUtilisateur mediateur =
            new MediateurOuvertureSessionUtilisateur(

                this.registreUtilisateur,
                this.registreSessionUtilisateur);

        Etudiant etudiant = new Etudiant("Test");
        Etudiant reponseObtenir = new Etudiant("Reponse");
        SessionUtilisateur sessionUtilisateur = new SessionUtilisateur(etudiant);

        Mockito.when(this.registreUtilisateur.obtenir(etudiant))
            .thenReturn(reponseObtenir);
        Mockito.when(this.registreSessionUtilisateur.creer(reponseObtenir))
            .thenReturn(sessionUtilisateur);
        SessionUtilisateur reponseSession = mediateur.executer(etudiant);

        Assert.assertTrue(
            reponseSession.getUtilisateur()
                .getIdentificateur()
                .equalsIgnoreCase("Test"));
        Assert.assertNotNull(reponseSession);
    }

}
