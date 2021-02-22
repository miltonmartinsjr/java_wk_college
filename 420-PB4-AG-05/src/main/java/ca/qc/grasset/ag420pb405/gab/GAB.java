package ca.qc.grasset.ag420pb405.gab;

public final class GAB {

    private final Banque banque;

    private final String idGAB;

    public GAB(final String idGAB_, final Banque banque_) {

        this.idGAB = idGAB_;
        this.banque = banque_;
    }

    public Banque getBanque() {

        return this.banque;
    }

    public String getIdGAB() {

        return this.idGAB;
    }

}
