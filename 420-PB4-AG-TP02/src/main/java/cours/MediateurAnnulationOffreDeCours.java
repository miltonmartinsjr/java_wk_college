package cours;

public class MediateurAnnulationOffreDeCours {

    private final RegistreOffreDeCours registreOffreDeCours;

    public MediateurAnnulationOffreDeCours(final RegistreOffreDeCours registreOffreDeCours_) {

        super();
        this.registreOffreDeCours = registreOffreDeCours_;
    }

    public final void executer(
        final OffreDeCours offreDeCours_) {

        OffreDeCours reponse = this.registreOffreDeCours.modifier(offreDeCours_);

        System.out.println(reponse.toString());
    }

}
