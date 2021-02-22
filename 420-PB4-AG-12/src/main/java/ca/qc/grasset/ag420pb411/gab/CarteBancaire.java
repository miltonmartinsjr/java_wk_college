package ca.qc.grasset.ag420pb411.gab;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "carte_bancaires")
@AllArgsConstructor
public final class CarteBancaire
    implements Serializable {

    private static final long serialVersionUID = 8190402503464837647L;

    @ManyToOne
    @JoinColumn(name = "banque_pkid")
    private Banque banque;

    @ManyToOne
    @JoinColumn(name = "compte_client_pkid")
    private CompteClient compteClient;

    @Column(name = "date_activation")
    private Date dateActivation;

    @Column(name = "date_expiration")
    private Date dateExpiration;

    @Column(name = "id_carte")
    private String idCarte;

    @Column(name = "numero_identification_personnel")
    private String numeroIdentificationPersonnel;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    public CarteBancaire() {

        super();
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
