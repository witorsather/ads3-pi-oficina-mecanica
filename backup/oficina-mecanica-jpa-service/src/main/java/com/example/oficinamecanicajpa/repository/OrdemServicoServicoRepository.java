package com.example.oficinamecanicajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oficinamecanicajpa.domain.OrdemServicoServico;


@Repository
public interface OrdemServicoServicoRepository extends JpaRepository<OrdemServicoServico, Integer>{

}