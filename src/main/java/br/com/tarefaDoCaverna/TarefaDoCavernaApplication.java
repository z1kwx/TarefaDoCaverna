package br.com.tarefaDoCaverna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TarefaDoCavernaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TarefaDoCavernaApplication.class, args);
	}

}
