package br.edu.cse.controller;

import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.Cidade;
import br.edu.cse.entity.CidadeCombo;
import br.edu.cse.service.CidadeService;

@RestController
@CrossOrigin
public class CidadeController {

	@Autowired
	private CidadeService service;
	
	@GetMapping("/cidades/{pagina}")
	public Collection<Cidade> obtemCidades(@PathVariable Long pagina) {
		Page<Cidade> retorno = service.obtemCidades(pagina.intValue());
		return retorno.getContent();
	}
	
	@GetMapping("/cidades/paginas")
	public Long obtemPaginas() {
		return (service.registros()/10);
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
	
	@GetMapping("/cidades/combo/{uf}")
	public List<CidadeCombo> obtemCidadesCombo(@PathVariable String uf) {
		return service.obtemCidades(uf);
	}
	
}
