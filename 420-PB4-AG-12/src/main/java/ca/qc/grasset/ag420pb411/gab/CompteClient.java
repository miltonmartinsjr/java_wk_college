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
@Table(name = "compte_clients")
@AllArgsConstructor
public final class CompteClient
    implements Serializable {

    private static final long serialVersionUID = -6249260486218438991L;

    @ManyToOne
    @JoinColumn(name = "client_pkid")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "compte_pkid")
    private Compte compte;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkid")
    private Long pkid;

    public CompteClient() {

        super();
    }
}
