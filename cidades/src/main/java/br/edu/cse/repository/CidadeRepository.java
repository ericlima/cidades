package br.edu.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
