package ca.qc.grasset.ag420pb405.gab;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class InfoJournalTransaction {

    private String codeIdCarte;

    private Date dateTransaction;

    private String idBanque;

    private String idGAB;

    private String typeTransaction;

    public InfoJournalTransaction() {

        super();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("idBanque", getIdBanque())
            .append("idGAB", getIdGAB())
            .append("dateTransaction", getDateTransaction())
            .append("typeTransaction", getTypeTransaction())
            .append("codeIdCarte", getCodeIdCarte())
            .toString();
    }

    String getCodeIdCarte() {

        return this.codeIdCarte;
    }

    Date getDateTransaction() {

        return this.dateTransaction;
    }

    String getIdBanque() {

        return this.idBanque;
    }

    String getIdGAB() {

        return this.idGAB;
    }

    String getTypeTransaction() {

        return this.typeTransaction;
    }

    void setCodeIdCarte(
        final String codeIdCarte_) {

        this.codeIdCarte = codeIdCarte_;
    }

    void setDateTransaction(
        final Date dateTransaction_) {

        this.dateTransaction = dateTransaction_;
    }

    void setIdBanque(
        final String idBanque_) {

        this.idBanque = idBanque_;
    }

    void setIdGAB(
        final String idGAB_) {

        this.idGAB = idGAB_;
    }

    void setTypeTransaction(
        final String typeTransaction_) {

        this.typeTransaction = typeTransaction_;
    }

}
