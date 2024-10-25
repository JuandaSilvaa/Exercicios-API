package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploController {

	@GetMapping
	public String teste() {
		return "Teste Serratec";
	}
	
	@GetMapping("/oi")
	public String oi() {
		return "oi";
	}
	
	@GetMapping("/maiuscula")
	public String maiuscula(@RequestParam String valor, @RequestParam String valor2) {
		return valor.toUpperCase().concat(valor2);
	}
	
	@GetMapping("/somar")
	public Double somar(@RequestParam Double valor, @RequestParam Double valor2) {
		double result = valor + valor2;
		return result;
	}
	
	@GetMapping("/multiplicar")
	public Double multiplicar(@RequestParam Double valor, @RequestParam Double valor2) {
		double result = valor * valor2;
		return result;
	}
	
	@GetMapping("/dividir")
	public Double dividir(@RequestParam Double valor, @RequestParam Double valor2) {
		double result = valor / valor2;
		return result;
	}
	
	@GetMapping("/subtrair")
	public Double subtrair(@RequestParam Double valor, @RequestParam Double valor2) {
		double result = valor - valor2;
		return result;
	}
	
}
