package com.example.oficinaco.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer>{


    @Query(nativeQuery = true, value = "select * from marca m where lower(m.usuario) like lower(:usuario)")
	List<Login> listarPorUsuario(@Param("usuario") String usuario);




}
