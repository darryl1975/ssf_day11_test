package sg.edu.iss.nus.d11wkshp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class D11wkshpApplication {

	public static void main(String[] args) {
		// SpringApplication.run(D11wkshpApplication.class, args);

		SpringApplication app = new SpringApplication(D11wkshpApplication.class);

		String port = "8080";
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		if (cliOpts.containsOption("port"))
			port = cliOpts.getOptionValues("port").get(0);

		app.setDefaultProperties(
				Collections.singletonMap("server.port", port));

		System.out.printf("D11 Workshop Application started on port %s\n", port);
		app.run(args);
	}

	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	}

}
