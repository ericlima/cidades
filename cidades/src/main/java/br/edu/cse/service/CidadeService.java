package br.edu.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.Cidade;
import br.edu.cse.entity.CidadeCombo;
import br.edu.cse.repository.CidadeComboRepository;
import br.edu.cse.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	@Autowired
	private CidadeComboRepository repositoryCombo;

	
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
	
	public List<CidadeCombo> obtemCidades(String uf) {
		return repositoryCombo.cidadesCombo(uf);
	}
	
}
