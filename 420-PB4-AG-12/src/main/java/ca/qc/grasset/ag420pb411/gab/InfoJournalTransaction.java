package ca.qc.grasset.ag420pb411.gab;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "info_journal_transactions")
@AllArgsConstructor
public final class InfoJournalTransaction
    implements Serializable {

    private static final long serialVersionUID = 1295884519491400793L;

    @Column(name = "code_id_carte")
    private String codeIdCarte;

    @Column(name = "date_transaction")
    private Date dateTransaction;

    @Column(name = "id_banque")
    private String idBanque;

    @Column(name = "id_gab")
    private String idGAB;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    @Column(name = "type_transaction")
    private String typeTransaction;

    public InfoJournalTransaction() {

        super();
    }
}
