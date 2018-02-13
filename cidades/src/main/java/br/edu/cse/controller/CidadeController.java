package br.edu.cse.controller;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.Cidade;
import br.edu.cse.service.CidadeService;

@RestController
public class CidadeController {

	@Autowired
	private CidadeService service;
	
	@GetMapping("/cidades")
	public Collection<Cidade> obtemCidades() {
		return service.obtemCidades();
	}
	
	@GetMapping("/cidade/{id}")
	public Cidade obtemCidade(@PathVariable Long id) {
		return service.obtemCidade(id);
	}
	
	@PostMapping("/cidade")
	public Cidade salva(Cidade cidade) {
		return service.salva(cidade);
	}
	
	@DeleteMapping("/cidade/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}
	
}
