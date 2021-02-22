package ca.qc.grasset.ag420pb405.gab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public final class MediateurValidationNIPTest {

    private final BatisseurInfoJournalTransaction batisseurInfoJournalTransaction =
        Mockito.mock(BatisseurInfoJournalTransaction.class);

    private final JournalTransaction journalTransaction = Mockito.mock(JournalTransaction.class);

    private final RegistreCarteBancaire registreCarteBancaire =
        Mockito.mock(RegistreCarteBancaire.class);

    private final RegistreCompteCarteBancaire registreCompteCarteBancaire =
        Mockito.mock(RegistreCompteCarteBancaire.class);

    public MediateurValidationNIPTest() {

        super();
    }

    @Test
    public void execute() {

        MediateurValidationNIP mediateurValidationNIP =
            new MediateurValidationNIP(
                this.batisseurInfoJournalTransaction,
                this.journalTransaction,
                this.registreCarteBancaire,
                this.registreCompteCarteBancaire);

        Banque banque = getBanque();
        GAB guichetAutomatiqueBancaire = getGAB(banque);
        CarteBancaire carteBancaire = getCarteBancaire(banque);
        configurerMockObjects(banque, guichetAutomatiqueBancaire, carteBancaire);

        ValidationNIP validationNIP = getValidationNIP(guichetAutomatiqueBancaire);

        List<CompteCarteBancaire> compteCarteBancaireList =
            mediateurValidationNIP.executer(carteBancaire, validationNIP);

        Assert.assertNotNull(compteCarteBancaireList);
        Assert.assertNotEquals(0, compteCarteBancaireList.size());
    }

    private void configurerMockObjects(
        final Banque banque_,
        final GAB guichetAutomatiqueBancaire_,
        final CarteBancaire carteBancaire_) {

        Mockito.when(this.registreCarteBancaire.obtenir(carteBancaire_))
            .thenReturn(carteBancaire_);

        List<CompteCarteBancaire> compteCarteBancaireList = getCompteCarteBancaireList();
        Mockito.when(this.registreCompteCarteBancaire.obtenir(carteBancaire_))
            .thenReturn(compteCarteBancaireList);

        InfoJournalTransaction infoJournalTransaction =
            getInfoJournalTransaction(banque_, guichetAutomatiqueBancaire_, carteBancaire_);

        Mockito
            .when(
                this.batisseurInfoJournalTransaction.idBanque(infoJournalTransaction.getIdBanque()))
            .thenReturn(this.batisseurInfoJournalTransaction);
        Mockito.when(this.batisseurInfoJournalTransaction.idGAB(infoJournalTransaction.getIdGAB()))
            .thenReturn(this.batisseurInfoJournalTransaction);
        Mockito.when(
            this.batisseurInfoJournalTransaction.dateTransaction(ArgumentMatchers.any(Date.class)))
            .thenReturn(this.batisseurInfoJournalTransaction);
        Mockito
            .when(
                this.batisseurInfoJournalTransaction
                    .typeTransaction(infoJournalTransaction.getTypeTransaction()))
            .thenReturn(this.batisseurInfoJournalTransaction);
        Mockito
            .when(
                this.batisseurInfoJournalTransaction
                    .codeIdCarte(infoJournalTransaction.getCodeIdCarte()))
            .thenReturn(this.batisseurInfoJournalTransaction);
        Mockito.when(this.batisseurInfoJournalTransaction.batir())
            .thenReturn(infoJournalTransaction);
    }

    private Banque getBanque() {

        Banque banque = new Banque("banque.001");

        return banque;
    }

    private CarteBancaire getCarteBancaire(
        final Banque banque_) {

        final String idCarte = "carte.001";
        final Date dateActivation = new Date();
        final Date dateExpiration = new Date();
        final String numeroIdentificationPersonnel = "0123456789ABCDEF";
        CarteBancaire carteBancaire =
            new CarteBancaire(banque_, idCarte, dateActivation, dateExpiration, numeroIdentificationPersonnel);

        return carteBancaire;
    }

    private List<CompteCarteBancaire> getCompteCarteBancaireList() {

        List<CompteCarteBancaire> compteCarteBancaireList = new ArrayList<>();

        for (int index = 0; index <= 2; index++) {
            compteCarteBancaireList.add(new CompteCarteBancaire());
        }

        return compteCarteBancaireList;
    }

    private GAB getGAB(
        final Banque banque_) {

        String idGAB = "gab.001";
        GAB guichetAutomatiqueBancaire = new GAB(idGAB, banque_);

        return guichetAutomatiqueBancaire;
    }

    private InfoJournalTransaction getInfoJournalTransaction(
        final Banque banque_,
        final GAB guichetAutomatiqueBancaire_,
        final CarteBancaire carteBancaire_) {

        InfoJournalTransaction infoJournalTransaction = new InfoJournalTransaction();
        infoJournalTransaction.setCodeIdCarte(carteBancaire_.getIdCarte());
        infoJournalTransaction.setDateTransaction(new Date());
        infoJournalTransaction.setIdBanque(banque_.getIdBanque());
        infoJournalTransaction.setIdGAB(guichetAutomatiqueBancaire_.getIdGAB());
        infoJournalTransaction.setTypeTransaction(ValidationNIP.class.getSimpleName());

        return infoJournalTransaction;
    }

    private ValidationNIP getValidationNIP(
        final GAB guichetAutomatiqueBancaire_) {

        ValidationNIP validationNIP = new ValidationNIP(guichetAutomatiqueBancaire_);

        return validationNIP;
    }

}
