package com.example.oficinamecanicajpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinamecanicajpa.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{
	
	@Query(nativeQuery = true, value = "select * from servico s where lower(s.nome) like lower(:nome)")
	List<Servico> listarPorNome(@Param("nome") String nome);

}
