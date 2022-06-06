package com.lucas.usuariocucumber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lucas.usuariocucumber.domain.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

	@Query(value = "FROM Usuario u WHERE u.id = :id")
	List<Usuario> buscar(Long id);
}
