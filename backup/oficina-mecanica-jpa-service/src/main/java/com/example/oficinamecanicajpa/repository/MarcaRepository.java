package com.example.oficinamecanicajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinamecanicajpa.domain.Marca;


@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

    @Query(nativeQuery = true, value = "select * from marca p where lower(p.nome) like lower(:nome)")
	List<Marca> listarPorNome(@Param("nome") String nome);

}