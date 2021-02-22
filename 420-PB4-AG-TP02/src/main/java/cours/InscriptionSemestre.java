package cours;

import java.util.List;

public class InscriptionSemestre {

    private final List<OffreDeCours> listoffreDeCours;

    private final Semestre semestre;

    public InscriptionSemestre(
        final List<OffreDeCours> listoffreDeCours_,
        final Semestre semestre_) {

        super();
        this.listoffreDeCours = listoffreDeCours_;
        this.semestre = semestre_;
    }

    public final List<OffreDeCours> getListoffreDeCours() {

        return this.listoffreDeCours;
    }

    public final Semestre getSemestre() {

        return this.semestre;
    }

    @Override
    public final String toString() {

        return "InscriptionSemestre [getListoffreDeCours()="
            + getListoffreDeCours()
            + ", getSemestre()="
            + getSemestre()
            + "]";
    }

}
