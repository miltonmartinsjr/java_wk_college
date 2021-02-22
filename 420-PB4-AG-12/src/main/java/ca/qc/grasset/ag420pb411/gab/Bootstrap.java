package ca.qc.grasset.ag420pb411.gab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//CSOFF: HideUtilityClassConstructor
@SpringBootApplication
public class Bootstrap {

    public Bootstrap() {

        super();
    }

    public static void main(
        final String[] args_) {

        SpringApplication.run(Bootstrap.class, args_);
    }
}
