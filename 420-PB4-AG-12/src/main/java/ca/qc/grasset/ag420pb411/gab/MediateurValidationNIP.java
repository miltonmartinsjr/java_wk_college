package ca.qc.grasset.ag420pb411.gab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder(builderClassName = "Builder")
@AllArgsConstructor
public final class MediateurValidationNIP {

    private JournalTransaction journalTransaction;

    private RegistreCarteBancaire registreCarteBancaire;

    private RegistreCompteCarteBancaire registreCompteCarteBancaire;

    public MediateurValidationNIP() {

        super();
    }

    List<CompteCarteBancaire> executer(
        final CarteBancaire carteBancaire_,
        final ValidationNIP validationNIP_) {

        CarteBancaire carteBancaire = this.registreCarteBancaire.obtenir(carteBancaire_);
        boolean valide = carteBancaire.validerNIP(carteBancaire_);

        if (!valide) {
            return new ArrayList<>();
        }

        List<CompteCarteBancaire> compteCarteBancaireList =
            this.registreCompteCarteBancaire.obtenir(carteBancaire);

        InfoJournalTransaction infoJournalTransaction =
            InfoJournalTransaction.builder()
                .idBanque(
                    validationNIP_.getGab()
                        .getBanque()
                        .getIdBanque())
                .idGAB(
                    validationNIP_.getGab()
                        .getPkid()
                        .toString())
                .dateTransaction(new Date())
                .typeTransaction(
                    validationNIP_.getClass()
                        .getSimpleName())
                .codeIdCarte(carteBancaire_.getIdCarte())
                .build();

        this.journalTransaction.ajouter(infoJournalTransaction);

        return compteCarteBancaireList;
    }
}
