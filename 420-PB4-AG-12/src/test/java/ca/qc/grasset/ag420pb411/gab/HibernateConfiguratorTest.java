package ca.qc.grasset.ag420pb411.gab;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

public final class HibernateConfiguratorTest {

    public HibernateConfiguratorTest() {

        super();
    }

    @Test
    public void execute() {

        HibernateConfigurator hibernateConfigurator = new HibernateConfigurator();
        try (SessionFactory sessionFactory = hibernateConfigurator.invoke()) {
            Assert.assertNotNull(sessionFactory);
        }
    }

}
