package com.example.oficinaco.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Integer>{

    @Query(nativeQuery = true, value = "select * from produto p where lower(p.nome) like lower(:nome)")
	List<Produto> listarPorNome(@Param("nome") String nome);

}
