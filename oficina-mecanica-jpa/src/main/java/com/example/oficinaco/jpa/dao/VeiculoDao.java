package com.example.oficinaco.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Veiculo;

@Repository
public interface VeiculoDao extends JpaRepository<Veiculo, Integer>{
	
	@Query(nativeQuery = true, value = "select * from veiculo v where lower(v.placa) like lower(:placa)")
	List<Veiculo> consultarPorPlaca(@Param("placa") String placa);

}
