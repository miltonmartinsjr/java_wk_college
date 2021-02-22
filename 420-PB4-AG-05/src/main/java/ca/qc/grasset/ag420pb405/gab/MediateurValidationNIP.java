package ca.qc.grasset.ag420pb405.gab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class MediateurValidationNIP {

    private final BatisseurInfoJournalTransaction batisseurInfoJournalTransaction;

    private CarteBancaire carteBancaire;

    private final JournalTransaction journalTransaction;

    private final RegistreCarteBancaire registreCarteBancaire;

    private final RegistreCompteCarteBancaire registreCompteCarteBancaire;

    public MediateurValidationNIP(
        final BatisseurInfoJournalTransaction batisseurInfoJournalTransaction_,
        final JournalTransaction journalTransaction_,
        final RegistreCarteBancaire registreCarteBancaire_,
        final RegistreCompteCarteBancaire registreCompteCarteBancaire_) {

        this.batisseurInfoJournalTransaction = batisseurInfoJournalTransaction_;
        this.journalTransaction = journalTransaction_;
        this.registreCarteBancaire = registreCarteBancaire_;
        this.registreCompteCarteBancaire = registreCompteCarteBancaire_;
    }

    List<CompteCarteBancaire> executer(
        final CarteBancaire carteBancaire_,
        final ValidationNIP validationNIP_) {

        this.carteBancaire = this.registreCarteBancaire.obtenir(carteBancaire_);
        boolean valide = this.carteBancaire.validerNIP(carteBancaire_);

        if (!valide) {
            return new ArrayList<>();
        }

        List<CompteCarteBancaire> compteCarteBancaireList =
            this.registreCompteCarteBancaire.obtenir(this.carteBancaire);

        InfoJournalTransaction infoJournalTransaction =
            this.batisseurInfoJournalTransaction.idBanque(
                validationNIP_.getGab()
                    .getBanque()
                    .getIdBanque())
                .idGAB(
                    validationNIP_.getGab()
                        .getIdGAB())
                .dateTransaction(new Date())
                .typeTransaction(
                    validationNIP_.getClass()
                        .getSimpleName())
                .codeIdCarte(carteBancaire_.getIdCarte())
                .batir();

        this.journalTransaction.ecrire(infoJournalTransaction);

        return compteCarteBancaireList;
    }
}
