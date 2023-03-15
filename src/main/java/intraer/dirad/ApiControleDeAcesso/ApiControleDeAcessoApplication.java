package intraer.dirad.ApiControleDeAcesso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class ApiControleDeAcessoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiControleDeAcessoApplication.class, args);
	
	}



}
