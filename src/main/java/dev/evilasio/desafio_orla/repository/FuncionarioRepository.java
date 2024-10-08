package dev.evilasio.desafio_orla.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import dev.evilasio.desafio_orla.model.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, JpaSpecificationExecutor<Funcionario> {

    Optional<Funcionario> findById(Long id);

    Optional<Funcionario> findByCpf(String cpf);
}
