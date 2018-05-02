package com.utn.tssi.lab5.Trabajo_Practico_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "")
@EnableJpaRepositories
@SpringBootApplication
public class TrabajoPractico4Application {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoPractico4Application.class, args);
		
	}

	/* Este metodo solo rediccionara al usuario a la ControladoraUsuario en el metodo readme (el que tiene definido /usuario como mapeo)
	 * y este cambio lo detecta la URL.
	 */
	@RequestMapping(value = "")
    public String index() {
        return "redirect:/user";
    }
}
