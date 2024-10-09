package dev.evilasio.desafio_orla.model.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends BaseEntity {

    private String nome;

    private String cpf;

    private String email;

    private BigDecimal salario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "funcionario_projetos", joinColumns = @JoinColumn(name = "funcionario_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "ID"))
    private List<Projeto> projetos;
}
