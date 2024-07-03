package farc.buildrun.desafioms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DesafiomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiomsApplication.class, args);
	}

}
