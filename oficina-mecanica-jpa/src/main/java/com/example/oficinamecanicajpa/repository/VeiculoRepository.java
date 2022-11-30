package com.example.oficinamecanicajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinamecanicajpa.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	
	@Query(nativeQuery = true, value = "select * from veiculo where lower(placa) = lower(:placa)")
	Veiculo consultarPorPlaca(@Param("placa") String placa);

}
