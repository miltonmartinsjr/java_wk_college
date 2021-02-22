package ca.qc.grasset.ag420pb411.gab;

public abstract class TransactionGAB {

    private final GuichetAutomatiqueBancaire guichetAutomatiqueBancaire;

    public TransactionGAB(final GuichetAutomatiqueBancaire guichetAutomatiqueBancaire_) {

        this.guichetAutomatiqueBancaire = guichetAutomatiqueBancaire_;
    }

    public final GuichetAutomatiqueBancaire getGab() {

        return this.guichetAutomatiqueBancaire;
    }

}
