package br.org.serratec.olamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.org.serratec.olamundo.domain.Veiculo;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
private static List<Veiculo> lista = new ArrayList<Veiculo>();
	
	static {
		lista.add(new Veiculo(2354L, "Fiat", "uno"));
		lista.add(new Veiculo(2343L, "Fiat", "uno-escada"));
		lista.add(new Veiculo(1409L, "Fiat", "uno-trabalho"));
	}

	@GetMapping
	public List<Veiculo> listar() {
		return lista;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscar(@PathVariable Long id) {
		return lista.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	} 
	
	@DeleteMapping("/{id}") 
	public void delete (@PathVariable Long id){
		lista.removeIf(m -> m.getId().equals(id));
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		return lista.stream().filter(a -> a.getId().equals(id)).findFirst()
		.map(a -> {
			
			Veiculo novoVeiculo = new Veiculo(id, veiculo.getMarca(), veiculo.getModelo()); 
	        lista.set(lista.indexOf(a), novoVeiculo); 
	        return novoVeiculo;
	        
		}).orElse(null); 
		
	}

}
