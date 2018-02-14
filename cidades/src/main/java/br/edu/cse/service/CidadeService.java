package br.edu.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.Cidade;
import br.edu.cse.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public Page<Cidade> obtemCidades(int pagina) {
		
		Sort sort = new Sort(new Sort.Order(Direction.ASC, "nome"));
		
		Pageable pageable = new PageRequest(pagina,10, sort);
		
		return repository.findAll(pageable);
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
	
	public Long registros() {
		return repository.count();
	}
	
}
