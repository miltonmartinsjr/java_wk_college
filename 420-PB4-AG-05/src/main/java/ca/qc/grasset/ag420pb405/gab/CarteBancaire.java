package ca.qc.grasset.ag420pb405.gab;

import java.util.Date;

public final class CarteBancaire {

    private final Banque banque;

    private final Date dateActivation;

    private final Date dateExpiration;

    private final String idCarte;

    private final String numeroIdentificationPersonnel;

    public CarteBancaire(
        final Banque banque_,
        final String idCarte_,
        final Date dateActivation_,
        final Date dateExpiration_,
        final String numeroIdentificationPersonnel_) {

        this.banque = banque_;
        this.dateActivation = dateActivation_;
        this.dateExpiration = dateExpiration_;
        this.idCarte = idCarte_;
        this.numeroIdentificationPersonnel = numeroIdentificationPersonnel_;
    }

    public Banque getBanque() {

        return this.banque;
    }

    public String getIdCarte() {

        return this.idCarte;
    }

    public boolean validerNIP(
        final CarteBancaire carteBancaire_) {

        if (this.numeroIdentificationPersonnel == null) {
            return false;
        }

        if (carteBancaire_ == null) {
            return false;
        }

        return this.numeroIdentificationPersonnel
            .equals(carteBancaire_.numeroIdentificationPersonnel);
    }

}
