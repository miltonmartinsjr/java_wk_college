package ca.qc.grasset.ag420pb412B.tp03.domain;

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
@Table(name = "factures")
@AllArgsConstructor
public final class Facture
    implements Serializable {

    private static final long serialVersionUID = -5626156282910301136L;

    @ManyToOne
    @JoinColumn(name = "etudiant_pkid")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "inscription_semestre_pkid")
    private InscriptionSemestre inscriptionSemestre;

    @Column(name = "numero")
    private String numero;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    @ManyToOne
    @JoinColumn(name = "statut_facture_pkid")
    private StatutFacture statutFacture;

    public Facture() {

        super();
    }

}
