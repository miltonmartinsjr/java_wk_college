package ca.qc.grasset.ag420pb412B.tp03.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
@Entity
@Table(name = "offre_de_cours")
@AllArgsConstructor
public final class OffreDeCours
    implements Serializable {

    private static final int NOMBRE_MINIUM_ETUDIANTS = 3;

    private static final long serialVersionUID = -5626156282910301136L;

    @ManyToOne
    @JoinColumn(name = "cours_pkid")
    private Cours cours;

    @OneToMany(mappedBy = "offreDeCours")
    private Set<EtudiantOffreDeCours> etudiantOffreDeCours;

    @ManyToOne
    @JoinColumn(name = "inscription_semestre_pkid")
    private InscriptionSemestre inscriptionSemestre;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    @ManyToOne
    @JoinColumn(name = "professeur_pkid")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "semestre_pkid")
    private Semestre semestre;

    @ManyToOne
    @JoinColumn(name = "statut_offre_de_cours_pkid")
    private StatutOffreDeCours statutOffreDeCours;

    public OffreDeCours() {

        super();
    }

    public boolean hasNombreMiniumEtudiants() {

        return this.etudiantOffreDeCours.size() >= OffreDeCours.NOMBRE_MINIUM_ETUDIANTS;
    }

}
