package fr.limayrac.declarationFrais.declarationFrais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DeclarationFraisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeclarationFraisApplication.class, args);
	}

}
