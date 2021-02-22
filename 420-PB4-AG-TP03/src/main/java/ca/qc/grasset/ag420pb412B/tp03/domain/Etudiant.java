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
@Table(name = "etudiants")
@AllArgsConstructor
public final class Etudiant
    implements Serializable {

    private static final long serialVersionUID = -5626156282910301136L;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "nom")
    private String nomDeFamille;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    @Column(name = "prenom")
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "utilisateur_pkid")
    private Utilisateur utilisateur;

    public Etudiant() {

        super();
    }

}
