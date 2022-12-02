package com.example.oficinamecanicajpa.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.oficinamecanicajpa.domain.Pessoa;

@Repository
public class PessoaImplRepository {

	@Autowired
	private EntityManager em;

	public List<Pessoa> listarPorNome(String nome, Boolean funcionario) {
		String sql = "select * from pessoa p where lower(p.nome) like lower(:nome)";

		if (funcionario != null) {
			sql += " and p.funcionario";
		}

		Query query = em.createNativeQuery(sql, Pessoa.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

}
