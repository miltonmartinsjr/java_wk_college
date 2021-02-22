package ca.qc.grasset.ag420pb411.gab;

import java.io.Serializable;

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
@Table(name = "compte_carte_bancaires")
@AllArgsConstructor
public final class CompteCarteBancaire
    implements Serializable {

    private static final long serialVersionUID = -1083295514516746216L;

    @ManyToOne
    @JoinColumn(name = "carte_bancaire_pkid")
    private CarteBancaire carteBancaire;

    @ManyToOne
    @JoinColumn(name = "compte_pkid")
    private Compte compte;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    public CompteCarteBancaire() {

        super();
    }
}
