package ca.qc.grasset.ag420pb405.gab;

public abstract class TransactionGAB {

    private final GAB guichetAutomatiqueBancaire;

    public TransactionGAB(final GAB guichetAutomatiqueBancaire_) {

        this.guichetAutomatiqueBancaire = guichetAutomatiqueBancaire_;
    }

    public final GAB getGab() {

        return this.guichetAutomatiqueBancaire;
    }

}
