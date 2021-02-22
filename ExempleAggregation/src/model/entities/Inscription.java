package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inscription {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    private Cours cours;

    private final Date date;

    private final Double notesFinal = -1.0;

    public Inscription(final Cours cours, final Date date) {

        this.cours = cours;
        this.date = date;
    }

    public final Cours getCours() {

        return this.cours;
    }

    public final Double getNotesFinal() {

        return this.notesFinal;
    }

    public final void setCours(
        final Cours cours) {

        this.cours = cours;
    }

}
