package com.example.oficinaco.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Marca;


@Repository
public interface MarcaDao extends JpaRepository<Marca, Integer>{

}
