package br.edu.cse.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.cse.entity.CidadeCombo;

@Repository
public class CidadeComboRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static final String QUERY_CIDADE_COMBO = "select id, nome from municipio where uf = ? order by nome ";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CidadeCombo> cidadesCombo(String uf){
		
		return jdbcTemplate.query(QUERY_CIDADE_COMBO, new BeanPropertyRowMapper(CidadeCombo.class), uf);
		
	}
}
