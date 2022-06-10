package com.lucas.usuariocucumber.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lucas.usuariocucumber.domain.Soma;

@Repository
public interface SomaRepository extends PagingAndSortingRepository<Soma, Long>{

	@Query(value = "FROM Soma s WHERE s.id = :id")
	Soma buscar(Long id);
	
	@Query(value = "SELECT resultado FROM Soma s WHERE s.id = :id")
	Soma buscarResulta(Long id);
}
