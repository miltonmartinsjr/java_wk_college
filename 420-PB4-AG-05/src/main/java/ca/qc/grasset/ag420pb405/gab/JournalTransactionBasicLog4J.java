package ca.qc.grasset.ag420pb405.gab;

import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;

public final class JournalTransactionBasicLog4J
    implements JournalTransaction {

    private static final Logger LOGGER =
        Logger.getLogger(JournalTransactionBasicLog4J.class.getName());

    public JournalTransactionBasicLog4J() {

        BasicConfigurator.configure();
    }

    @Override
    public void ecrire(
        final InfoJournalTransaction infoJournalTransaction_) {

        JournalTransactionBasicLog4J.LOGGER.info(infoJournalTransaction_.toString());

    }

}
