package br.edu.cse.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.Cidade;
import br.edu.cse.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public Collection<Cidade> obtemCidades() {
		return repository.findAll();
	}
	
	public Cidade obtemCidade(Long id) {
		return repository.findOne(id);
	}
	
	public Cidade salva(Cidade cidade) {
		return repository.save(cidade);
	}
	
	public void exclui(Long id) {
		repository.delete(id);
	}	
	
}
