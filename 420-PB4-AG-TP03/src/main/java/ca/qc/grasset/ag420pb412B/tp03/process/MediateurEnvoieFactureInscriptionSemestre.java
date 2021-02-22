package ca.qc.grasset.ag420pb412B.tp03.process;

import ca.qc.grasset.ag420pb412B.tp03.diffuseur.DiffuseurFacture;
import ca.qc.grasset.ag420pb412B.tp03.domain.InscriptionSemestre;
import ca.qc.grasset.ag420pb412B.tp03.repository.FactureRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public final class MediateurEnvoieFactureInscriptionSemestre {

    @SuppressWarnings("unused")
    private DiffuseurFacture diffuseurFacture;

    @SuppressWarnings("unused")
    private FactureRepository factureRepository;

    public MediateurEnvoieFactureInscriptionSemestre() {

        super();
    }

    public void executer(
        @SuppressWarnings("unused") final InscriptionSemestre inscriptionSemestre_) {

        return;
    }

}
