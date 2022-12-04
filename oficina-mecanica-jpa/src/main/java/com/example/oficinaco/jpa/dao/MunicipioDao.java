package com.example.oficinaco.jpa.dao;


import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.oficinaco.jpa.entidade.Municipio;

public interface MunicipioDao extends JpaRepository<Municipio,Integer>{

    
	@Query(nativeQuery = true, value = "select * from municipio m where lower(m.nome) like lower(:nome)")
	List<Municipio> listarPorNome(@Param("nome") String nome);
	




}
