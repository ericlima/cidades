package br.edu.cse.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.cse.entity.CidadeCombo;
import br.edu.cse.entity.UfCombo;

@Repository
public class CidadeComboRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static final String QUERY_CIDADE_COMBO = "select id, nome from municipio where uf = ? order by nome ";
	public static final String QUERY_UF_COMBO = "select uf from municipio group by uf order by uf";

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CidadeCombo> cidadesCombo(String uf){
		
		return jdbcTemplate.query(QUERY_CIDADE_COMBO, new BeanPropertyRowMapper(CidadeCombo.class), uf);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UfCombo> ufCombo(){
		
		return jdbcTemplate.query(QUERY_UF_COMBO, new BeanPropertyRowMapper(UfCombo.class));
		
	}

}
