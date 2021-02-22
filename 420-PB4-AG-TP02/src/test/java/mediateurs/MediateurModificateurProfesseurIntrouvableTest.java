package mediateurs;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import ecole.Departement;
import professeur.ExceptionProfesseurIntrouvable;
import professeur.MediateurModificationProfesseur;
import professeur.Professeur;
import professeur.RegistreProfesseur;
import professeur.StatutProfesseur;

public class MediateurModificateurProfesseurIntrouvableTest {

    private final RegistreProfesseur registreProfesseur = Mockito.mock(RegistreProfesseur.class);

    public MediateurModificateurProfesseurIntrouvableTest() {

    }

    @Test(expected = ExceptionProfesseurIntrouvable.class)
    public void test()
        throws ExceptionProfesseurIntrouvable {

        MediateurModificationProfesseur modifProf =
            new MediateurModificationProfesseur(this.registreProfesseur);

        Professeur profAttendu =
            new Professeur("", "", "", new Date(), "", new Departement(), new StatutProfesseur());

        Professeur profModif =
            new Professeur(
                "ProfPablo",
                "Pablo",
                "Vitar",
                new Date(),
                "242424",
                new Departement(),
                new StatutProfesseur());

        Mockito.when(this.registreProfesseur.obtenir(profModif))
            .thenReturn(profAttendu);

        Mockito.when(this.registreProfesseur.modifier(profModif))
            .thenReturn(profModif);

        Professeur obtProf = modifProf.executer(profModif);

    }

}
