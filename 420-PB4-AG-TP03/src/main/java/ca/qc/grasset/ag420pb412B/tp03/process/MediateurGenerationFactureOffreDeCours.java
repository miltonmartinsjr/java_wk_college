package ca.qc.grasset.ag420pb412B.tp03.process;

import ca.qc.grasset.ag420pb412B.tp03.domain.EtudiantOffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.domain.Facture;
import ca.qc.grasset.ag420pb412B.tp03.domain.OffreDeCours;
import ca.qc.grasset.ag420pb412B.tp03.domain.StatutFacture;
import ca.qc.grasset.ag420pb412B.tp03.exception.ResourceNotFoundException;
import ca.qc.grasset.ag420pb412B.tp03.repository.EtudiantRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.FactureRepository;
import ca.qc.grasset.ag420pb412B.tp03.repository.StatutFactureRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public final class MediateurGenerationFactureOffreDeCours {

    private EtudiantRepository etudiantRepository;

    private FactureRepository factureRepository;

    private StatutFactureRepository statutFactureRepository;

    public MediateurGenerationFactureOffreDeCours() {

        super();
    }

    public void executer(
        final OffreDeCours offreDeCours_)
        throws ResourceNotFoundException {

        for (EtudiantOffreDeCours etudiantOffreDeCours : offreDeCours_.getEtudiantOffreDeCours()) {

            StatutFacture statutFacture = getStatutNouvelleFacture();

            Facture facture =
                Facture.builder()
                    .etudiant(etudiantOffreDeCours.getEtudiant())
                    .inscriptionSemestre(offreDeCours_.getInscriptionSemestre())
                    .numero(getNumeroFacture())
                    .statutFacture(statutFacture)
                    .build();

            facture = this.factureRepository.save(facture);
        }
    }

    private String getNumeroFacture() {

        return String.valueOf(System.currentTimeMillis());
    }

    private StatutFacture getStatutNouvelleFacture()
        throws ResourceNotFoundException {

        final long pkid = 0;
        return this.statutFactureRepository.findById(pkid)
            .orElseThrow(
                () -> new ResourceNotFoundException(
                    "Statut nouvelle facture introuvable :: " + pkid));
    }
}
