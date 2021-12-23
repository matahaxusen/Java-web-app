package tiw.clients.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Bank80IApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(Bank80IApplication.class, args);
	}

}
