package ca.qc.grasset.ag420pb405.gab;

import java.util.Date;

public interface BatisseurInfoJournalTransaction {

    InfoJournalTransaction batir();

    BatisseurInfoJournalTransaction codeIdCarte(
        String codeIdCarte_);

    BatisseurInfoJournalTransaction dateTransaction(
        Date dateTransaction_);

    BatisseurInfoJournalTransaction idBanque(
        String idBanque_);

    BatisseurInfoJournalTransaction idGAB(
        String idGAB_);

    BatisseurInfoJournalTransaction typeTransaction(
        String typeTransaction_);
}
