package br.com.aulapdv.syspdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aulapdv.syspdv.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
}
