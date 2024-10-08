package dev.evilasio.desafio_orla.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import dev.evilasio.desafio_orla.model.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>, JpaSpecificationExecutor<Projeto> {

    Optional<Projeto> findById(Long id);
}
