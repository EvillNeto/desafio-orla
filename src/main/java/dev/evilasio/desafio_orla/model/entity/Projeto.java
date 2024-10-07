package dev.evilasio.desafio_orla.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projeto extends BaseEntity {

    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projetos")
    private List<Funcionario> funcionarios;
}
