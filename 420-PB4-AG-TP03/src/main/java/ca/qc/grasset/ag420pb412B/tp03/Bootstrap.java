package ca.qc.grasset.ag420pb412B.tp03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//CSOFF: HideUtilityClassConstructor
@SpringBootApplication
@EnableJpaAuditing
public class Bootstrap {

    public Bootstrap() {

        super();
    }

    public static void main(
        final String[] args_) {

        SpringApplication.run(Bootstrap.class, args_);
    }
}
