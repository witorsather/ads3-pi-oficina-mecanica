package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Modelo;


@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer>{

}