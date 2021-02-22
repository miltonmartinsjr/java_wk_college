package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Cours {

    private final List<Eleves> eleves = new ArrayList<>();

    private final int idCours;

    private final String titre;

    private final int unite;

    public Cours(final Cours idCours, final String titre, final int unite) {

        this.idCours = idCours;
        this.titre = titre;
        this.unite = unite;
    }

    public final List<Eleves> getEleves() {

        return this.eleves;
    }

    public final int getIdCours() {

        return this.idCours;
    }

    public final String getTitre() {

        return this.titre;
    }

    public final int getUnite() {

        return this.unite;
    }

}
